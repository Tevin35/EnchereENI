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
import fr.formation.enchere.eni.bll.IUtilisateurManager;
import fr.formation.enchere.eni.bll.UtilisateurManagerSing;
import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Categorie;
import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Servlet implementation class ArticleCreationServlet
 */
@WebServlet("/ArticleCreationServlet")
public class ArticleCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IArticleManager managerArticle = ArticleManagerSing.getInstance();
	private IUtilisateurManager managerUtilisateur = UtilisateurManagerSing.getInstance();
	private ICategorieManager managerCategorie = CategorieManagerSing.getInstance();
       
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
		ArticleModel model = new ArticleModel();
		
		if (request.getParameter("valider") != null) {
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"));
			LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres"));
			Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			Integer prixVente = Integer.parseInt(request.getParameter("prixVente"));
			Utilisateur utilisateur = null;
			Integer noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
			try {
				utilisateur = managerUtilisateur.selectById(noUtilisateur);
				System.out.println(utilisateur);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			Categorie categorie = null;
			Integer noCategorie = Integer.parseInt(request.getParameter("noCategorie"));
			try {
				categorie = managerCategorie.selectById(noCategorie);
				System.out.println(categorie);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}

			ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, dateDebutEncheres,
					dateFinEncheres, miseAPrix, prixVente, utilisateur, categorie);

			model.setArticleVendu(articleVendu);
			System.out.println(articleVendu);
			try {
				managerArticle.insert(articleVendu);
				model.setMessage("Création d'article réussi");
			} catch (BLLException e) {
				model.setMessage("Erreur à la création d'article");
			}
		}
		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/ArticleCreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
