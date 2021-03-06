package fr.formation.enchere.eni.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.bll.ArticleManagerSing;
import fr.formation.enchere.eni.bll.BLLException;
import fr.formation.enchere.eni.bll.CategorieManagerSing;
import fr.formation.enchere.eni.bll.IArticleManager;
import fr.formation.enchere.eni.bll.ICategorieManager;
import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Categorie;
import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.ICategorieDAO;

/**
 * Servlet implementation class ArticleCreationServlet
 */
@WebServlet("/ArticleCreationServlet")
public class ArticleCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IArticleManager managerArticle = ArticleManagerSing.getInstance();
	private ICategorieManager managerCategorie = CategorieManagerSing.getInstance();
	ICategorieDAO daoC = DAOFact.getCategorieDAO();


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCreationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleModel modelA = new ArticleModel();
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("modelU");
		CategorieModel modelCat = new CategorieModel();
		
		try {
			modelCat.setLstCategories(daoC.selectAll());
		} catch (DALException e) {
			modelCat.setMessage("Impossible de récupérer les categories");
		}

		
		if (request.getParameter("valider") != null) {
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"));
			LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres"));
			Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			Utilisateur utilisateur = modelU.getUtilisateur();
			Categorie categorie = null;
			Integer noCategorie = Integer.parseInt(request.getParameter("categories"));
			try {
				categorie = managerCategorie.selectById(noCategorie);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
						
			ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres,
					dateFinEncheres, miseAPrix, utilisateur, categorie);

			modelA.setArticleVendu(articleVendu);
			try {
				managerArticle.insert(articleVendu);
				modelA.setMessage("Création d'article réussi");
			} catch (BLLException e) {
				modelA.setMessage("Erreur à la création d'article");
			}
		}
		request.getSession().setAttribute("modelA", modelA);
		request.setAttribute("modelCat", modelCat);
		request.setAttribute("modelU", modelU);
		request.getRequestDispatcher("/WEB-INF/ArticleCreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
