package fr.formation.enchere.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.bll.ArticleManagerSing;
import fr.formation.enchere.eni.bll.BLLException;
import fr.formation.enchere.eni.bll.IArticleManager;
import fr.formation.enchere.eni.bll.IUtilisateurManager;
import fr.formation.enchere.eni.bll.UtilisateurManagerSing;
import fr.formation.enchere.eni.bo.ArticleVendu;

/**
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/DetailVenteServlet")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IArticleManager managerArticle = ArticleManagerSing.getInstance();
	private IUtilisateurManager managerUtilisateur = UtilisateurManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailVenteServlet() {

		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleModel modelA = (ArticleModel) request.getSession().getAttribute("modelA");
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("modelU");

		Integer noArticle =  Integer.parseInt(request.getParameter("noArticle"));
		
		String destination = "/WEB-INF/DetailVente.jsp";
		
		try {
			modelA.setArticleVendu(managerArticle.selectById(noArticle));
		} catch (BLLException e) {
			modelA.setMessage("erreur dans le select");
		}
		if (request.getParameter("encherir") != null) {
			System.out.println("blop");
		}

		if (request.getParameter("submit") != null) {
			System.out.println(request.getParameter("maproposition"));
			modelA.setEncheres(Integer.parseInt(request.getParameter("maproposition")));
			request.setAttribute("modelA", modelA);
			request.setAttribute("modelU", modelU);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
		request.setAttribute("modelA", modelA);
		request.setAttribute("modelU", modelU);
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
