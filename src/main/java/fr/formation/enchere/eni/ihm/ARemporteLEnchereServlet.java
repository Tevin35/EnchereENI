package fr.formation.enchere.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.bll.ArticleManagerSing;
import fr.formation.enchere.eni.bll.IArticleManager;

/**
 * Servlet implementation class ARemporteLEnchereServlet
 */
@WebServlet("/ARemporteLEnchereServlet")
public class ARemporteLEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IArticleManager manager = ArticleManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ARemporteLEnchereServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArticleModel model = new ArticleModel();

		try {
			System.out.println(manager.selectById(1));
			model.setArticleVendu(manager.selectById(1));

		} catch (Exception e) {
			e.printStackTrace();

		}

		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/ARemporteLEnchereServlet.jsp").forward(request, response);
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
