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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("modelU");
		CategorieModel modelCat = new CategorieModel();
		ArticleModel modelA = new ArticleModel();
		
		String destination = "/WEB-INF/PageAcceuil.jsp";
		
		Integer categorie = null;
		String rechercher = null;

		if (request.getParameter("deco") != null) {
			request.getSession().invalidate();
			modelU.setConnecter(false);
			
			try {
				modelCat.setLstCategories(managerC.selectAll());
				modelA.setLstArticles(managerA.selectAll());
			} catch (BLLException e) {
				System.out.println("il y a pas d'erreur balec");
			}				
			request.setAttribute("modelCat", modelCat);
			request.setAttribute("modelU", modelU);
			request.getSession().setAttribute("modelA", modelA);
		} else {
			if (request.getParameter("submit") != null) {
				
			
			rechercher = request.getParameter("rechercher");
			categorie = Integer.parseInt(request.getParameter("categories"));

			String ouvertes = request.getParameter("ouvertes");
			String mesEncheres = request.getParameter("mesEncheres");
			String remporte = request.getParameter("remporte");
			String enCour = request.getParameter("enCour");
			String debute = request.getParameter("debute");
			String termine = request.getParameter("termine");
			
			//System.out.println(rechercher);
			//System.out.println(categorie);
			//System.out.println(ouvertes);			
			}
			try {
				if (categorie != null) {
					modelA.setLstArticles(managerA.filtreCat(categorie));
					modelCat.setLstCategories(managerC.selectAll());
				}else if (rechercher != null) {
					
				}else {
					modelCat.setLstCategories(managerC.selectAll());
					modelA.setLstArticles(managerA.selectAll());
				}
			} catch (BLLException e) {
				System.out.println("erreur de select : " + e.getMessage());
			}

			request.setAttribute("modelCat", modelCat);
			request.setAttribute("modelU", modelU);
			request.getSession().setAttribute("modelA", modelA);
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
