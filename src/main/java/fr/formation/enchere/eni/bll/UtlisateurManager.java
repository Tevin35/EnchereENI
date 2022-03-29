/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IUtilisateurDAO;

/**
 * Classe en charge de
 * @author cmounier2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 16:45:38
 *
 */
public class UtlisateurManager implements IUtilisateurManager {
	
	private IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();
	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public List<Utilisateur> selelctAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - ERREUR DANS LA FONCTION SELECT : " + e.getMessage());
		}
	}

}
