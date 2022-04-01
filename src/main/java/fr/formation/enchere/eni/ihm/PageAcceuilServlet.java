package fr.formation.enchere.eni.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.ICategorieDAO;

/**
 * Servlet implementation class PageAcceuilServlet
 */
@WebServlet("/PageAcceuilServlet")
public class PageAcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICategorieDAO daoC = DAOFact.getCategorieDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAcceuilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurModel modelU = (UtilisateurModel) request.getSession().getAttribute("model");
		CategorieModel modelCat = new CategorieModel();
		
		try {
			modelCat.setLstCategories(daoC.selectAll());
		} catch (DALException e) {
			modelCat.setMessage("Impossible de récupérer les categories");
		}
		
		request.setAttribute("modelCat", modelCat);
		request.setAttribute("model", modelU);
		request.getRequestDispatcher("/WEB-INF/PageAcceuil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
