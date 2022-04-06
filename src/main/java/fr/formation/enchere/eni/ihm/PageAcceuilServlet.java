package fr.formation.enchere.eni.ihm;

import java.io.IOException;

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


/**
 * Servlet implementation class PageAcceuilServlet
 */
@WebServlet("/PageAcceuilServlet")
public class PageAcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICategorieManager managerC = CategorieManagerSing.getInstance();
	IArticleManager managerA = ArticleManagerSing.getInstance();
       
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
		
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("modelU");
		CategorieModel modelCat = new CategorieModel();
		ArticleModel modelA = new ArticleModel();
		
		try {
			modelCat.setLstCategories(managerC.selectAll());
		} catch (BLLException e) {
			modelCat.setMessage("Impossible de récupérer les categories");
		}
		if (request.getParameter("deco") != null) {
			request.getSession().invalidate();
			modelU.setConnecter(false);
			request.setAttribute("model", modelU);
			request.getRequestDispatcher("/WEB-INF/PageAcceuil.jsp").forward(request, response);
		}else {
			try {
				modelA.setLstArticles(managerA.selectAll());
			} catch (BLLException e) {
				System.out.println("erreur de select : " + e.getMessage());
			}
			
			request.setAttribute("modelCat", modelCat);
			request.setAttribute("modelU", modelU);
			request.getSession().setAttribute("modelA", modelA);
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
