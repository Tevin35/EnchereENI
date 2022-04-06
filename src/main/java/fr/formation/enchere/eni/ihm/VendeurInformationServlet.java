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
 * Servlet implementation class VendeurInformationServlet
 */
@WebServlet("/VendeurInformationServlet")
public class VendeurInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IUtilisateurManager managerU = UtilisateurManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendeurInformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurModel modelU = new UtilisateurModel();
		
		String pseudo = request.getParameter("pseudo");
		Utilisateur utilisateur = null;
		try {
			utilisateur = managerU.selectPseudo(pseudo);
		} catch (BLLException e) {
			modelU.setMessage("Erreur dans le select : " + e.getMessage());
		}
		modelU.setUtilisateur(utilisateur);
		
		request.setAttribute("modelU", modelU);
		request.getRequestDispatcher("/WEB-INF/VendeurInformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
