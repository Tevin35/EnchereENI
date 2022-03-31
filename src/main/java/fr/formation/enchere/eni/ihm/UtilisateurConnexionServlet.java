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
 * Servlet implementation class UtilisateurConnexionServlet
 */
@WebServlet("/UtilisateurConnexionServlet")
public class UtilisateurConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUtilisateurManager manager = UtilisateurManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel model = new UtilisateurModel();
		
		if (request.getParameter("connexion") != null) {
			// verification que l'utlisateur existe sinon lui demander de s'inscrire
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");

			try {
				for (Utilisateur utilisateur : manager.selectAll()) {

					if (utilisateur.getPseudo().trim().equalsIgnoreCase(pseudo)
							&& utilisateur.getMotDePasse().equals(password)) {
						// Connexion reussi garder l'utlisateur connecter
						model.setUtilisateur(utilisateur);
						model.setConnecter(true);
						// retour page d'acceuil
						request.getSession().setAttribute("model", model);
						request.getRequestDispatcher("PageAcceuilServlet").forward(request, response);
						break;
					} else {
						model.setMessage("Compte inexistant, veuillez en créer un.");
						request.getSession().setAttribute("model", model);
						request.getRequestDispatcher("/WEB-INF/UtilisateurConnexion.jsp").forward(request, response);
					}
				}
			} catch (BLLException e) {
				model.setMessage("Erreur Select");
			}

		} else if (request.getParameter("inscription") != null) {
			request.getRequestDispatcher("UtilisateurInscriptionServlet").forward(request, response);
		} else {
			request.getSession().setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/UtilisateurConnexion.jsp").forward(request, response);
		}

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
