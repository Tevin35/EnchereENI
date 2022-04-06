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

		UtilisateurModel modelU = new UtilisateurModel();

		if (request.getParameter("connexion") != null) {
			// verification que l'utlisateur existe sinon lui demander de s'inscrire
			String pseudo = request.getParameter("pseudo");
			String password = request.getParameter("password");
			try {
				if (manager.selectLogin(pseudo, password) != null) {
					// Connexion reussi garder l'utlisateur connecter
					modelU.setUtilisateur(manager.selectLogin(pseudo, password));
					modelU.setConnecter(true);
					// retour page d'acceuil
					request.getSession().setAttribute("modelU", modelU);
					request.getRequestDispatcher("PageAcceuilServlet").forward(request, response);

				} else {
					modelU.setMessage("Mot de passe incorrecte ou compte inexistant.");
					request.getSession().setAttribute("modelU", modelU);
					request.getRequestDispatcher("/WEB-INF/UtilisateurConnexion.jsp").forward(request, response);
				}

			} catch (BLLException e) {
				modelU.setMessage("Erreur Select");
			}

		} else if (request.getParameter("inscription") != null) {
			request.getRequestDispatcher("UtilisateurInscriptionServlet").forward(request, response);
		} else {
			request.getSession().setAttribute("modelU", modelU);
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
