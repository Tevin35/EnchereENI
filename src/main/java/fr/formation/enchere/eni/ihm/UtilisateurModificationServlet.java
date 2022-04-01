package fr.formation.enchere.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.bll.BLLException;
import fr.formation.enchere.eni.bll.IUtilisateurManager;
import fr.formation.enchere.eni.bll.UtilisateurManagerSing;
import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurModificationServlet
 */
@WebServlet("/UtilisateurModificationServlet")
public class UtilisateurModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUtilisateurManager manager = UtilisateurManagerSing.getInstance();

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
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");

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

			Utilisateur utilisateur = new Utilisateur(model.getUtilisateur().getNoUtilisateur(), pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, model.getUtilisateur().getCredit(), model.getUtilisateur().isAdministrateur());

			try {
				manager.update(utilisateur);
			} catch (BLLException e) {

			}
		}

		// delete
		if (request.getParameter("supprimer") != null) {

			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("newPassword");

			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, model.getUtilisateur().getCredit(), model.getUtilisateur().isAdministrateur());

			try {
				manager.delete(utilisateur);
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
