package fr.formation.enchere.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IArticleDAO;
import fr.formation.enchere.eni.dal.ICategorieDAO;

/**
 * Servlet implementation class PageAcceuilServlet
 */
@WebServlet("/PageAcceuilServlet")
public class PageAcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICategorieDAO daoC = DAOFact.getCategorieDAO();
	IArticleDAO daoA = DAOFact.getArticleDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAcceuilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("model");
		CategorieModel modelCat = new CategorieModel();
		ArticleModel modelA = new ArticleModel();
		
		
		
		try {
			modelCat.setLstCategories(daoC.selectAll());
		} catch (DALException e) {
			modelCat.setMessage("Impossible de récupérer les categories");
		}
		if (request.getParameter("deco") != null) {
			request.getSession().invalidate();
			modelU.setConnecter(false);
			request.setAttribute("model", modelU);
			request.getRequestDispatcher("/WEB-INF/PageAcceuil.jsp").forward(request, response);
		}else {
			try {
				modelA.setLstArticles(daoA.selectAll());
			} catch (DALException e) {
				System.out.println("erreur de select : " + e.getMessage());
			}
			
			request.setAttribute("modelCat", modelCat);
			request.setAttribute("model", modelU);
			request.setAttribute("modelA", modelA);
			request.getRequestDispatcher("/WEB-INF/PageAcceuil.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
