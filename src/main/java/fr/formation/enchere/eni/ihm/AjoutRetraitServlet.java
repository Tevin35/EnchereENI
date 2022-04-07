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
import fr.formation.enchere.eni.bll.IRetraitManager;
import fr.formation.enchere.eni.bll.RetraitManagerSing;
import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Retrait;

/**
 * Servlet implementation class AjoutRetraitServlet
 */
@WebServlet("/AjoutRetraitServlet")
public class AjoutRetraitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IArticleManager managerArticle = ArticleManagerSing.getInstance();
	private IRetraitManager managerRetrait = RetraitManagerSing.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutRetraitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleModel modelA = new ArticleModel();
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("model");
		RetraitModel modelR = new RetraitModel();
		
		if (request.getParameter("valider") != null) {
			ArticleVendu articleVendu = modelA.getArticleVendu();
			Integer noArticle = Integer.parseInt(request.getParameter("noArticle"));
			try {
				articleVendu = managerArticle.selectById(articleVendu);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			
			Retrait retrait = null;
			try {
				retrait = new Retrait(managerArticle.selectById(noArticle), rue, codePostal, ville);
			} catch (BLLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			modelR.setRetrait(retrait);
			try {
				managerRetrait.insert(retrait);
				modelR.setMessage("Création du retrait réussi");
			} catch (BLLException e) {
				modelR.setMessage("Erreur à la création du retrait");
			}
		}
		request.getSession().setAttribute("modelA", modelA);
		request.setAttribute("modelU", modelU);
		request.getRequestDispatcher("/WEB-INF/AjoutRetrait.jsp").forward(request, response);
	}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
