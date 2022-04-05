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

		ArticleModel modelA = new ArticleModel();
		UtilisateurModel modelU = new UtilisateurModel();

		try {
			System.out.println(managerArticle.selectById(2));
			modelA.setArticleVendu(managerArticle.selectById(2));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("modelA", modelA);
		request.getRequestDispatcher("/WEB-INF/DetailVente.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
