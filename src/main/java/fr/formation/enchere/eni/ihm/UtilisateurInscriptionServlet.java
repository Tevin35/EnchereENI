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
 * Servlet implementation class UtilisateurInscriptionServlet
 */
@WebServlet("/UtilisateurInscriptionServlet")
public class UtilisateurInscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUtilisateurManager manager = UtilisateurManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurInscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel modelU = new UtilisateurModel();

		if (request.getParameter("creer") != null) {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String confirmation = request.getParameter("confirmMotDePasse");

			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, 1000, false);

			modelU.setUtilisateur(utilisateur);

			if (motDePasse.equals(confirmation)) {
				try {
					manager.insert(utilisateur);
					modelU.setConnecter(true);
					if (modelU.isConnecter()) {
						request.getSession().setAttribute("modelU", modelU);
						request.getRequestDispatcher("PageAcceuilServlet").forward(request, response);
					}
				} catch (BLLException e) {
					modelU.setMessage("Erreur à l'inscription");
				}
			}else {
				modelU.setMessage("Les mot de passe ne coresponde pas");
			}

		}

		if (request.getParameter("annuler") != null) {
			request.getRequestDispatcher("PageAcceuilServlet").forward(request, response);
		}
		request.getSession().setAttribute("modelU", modelU);
		request.getRequestDispatcher("/WEB-INF/UtilisateurInscription.jsp").forward(request, response);
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
