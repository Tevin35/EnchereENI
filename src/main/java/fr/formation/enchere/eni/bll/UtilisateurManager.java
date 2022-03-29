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
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 14:11:25
 *
 */
public class UtilisateurManager implements IUtilisateurManager{
	
	private IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();

	/**
	*{@inheriteDoc}
	 * @throws BLLException 
	*/
	@Override
	public void insert(Utilisateur utilisateur) throws BLLException {

		try {
			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction insert : " + e.getMessage());
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

	/**
	*{@inheriteDoc}
	 * @throws BLLException 
	*/
	@Override
	public void update(Utilisateur utilisateur) throws BLLException {
		try {
			dao.update(utilisateur, utilisateur.getNoUtilisateur());
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());
		}
	}

}
