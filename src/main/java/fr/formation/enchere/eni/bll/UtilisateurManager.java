/**
 * 
 */
package fr.formation.enchere.eni.bll;

import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IUtilisateurDAO;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 14:17:11
 *
 */
public class UtilisateurManager implements IUtilisateurManager {
	
	private IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();

	/**
	*{@inheritedDoc}
	*/
	@Override
	public void delete(Utilisateur utilisateur) throws BLLException {
		
		try {
			dao.delete(utilisateur);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction delete : " + e.getMessage());
		}
		
	}

}
