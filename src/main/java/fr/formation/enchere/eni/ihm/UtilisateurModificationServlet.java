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
import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurModificationServlet
 */
@WebServlet("/UtilisateurModificationServlet")
public class UtilisateurModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUtilisateurManager managerU = UtilisateurManagerSing.getInstance();
	IArticleManager managerA = ArticleManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurModificationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("modelU");
		
		
		// update
		if (request.getParameter("modifier") != null) {

			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("newMotDePasse");

			Utilisateur utilisateur = new Utilisateur(modelU.getUtilisateur().getNoUtilisateur(), pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, modelU.getUtilisateur().getCredit(), modelU.getUtilisateur().isAdministrateur());

			try {
				managerU.update(utilisateur);
			} catch (BLLException e) {

			}
		}

		// delete
		if (request.getParameter("supprimer") != null) {

			try {
				managerA.deleteUtilisateur(modelU.getUtilisateur().getNoUtilisateur());
				managerU.delete(modelU.getUtilisateur().getNoUtilisateur());
				modelU.setUtilisateur(null);
				modelU.setConnecter(false);
				request.getRequestDispatcher("PageAcceuilServlet").forward(request, response);
			} catch (BLLException e) {

			}
		}

		request.getRequestDispatcher("/WEB-INF/UtilisateurModification.jsp").forward(request, response);
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
