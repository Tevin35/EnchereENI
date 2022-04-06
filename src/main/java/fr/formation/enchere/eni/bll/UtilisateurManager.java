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
 * 
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 14:11:25
 *
 */
public class UtilisateurManager implements IUtilisateurManager {

	private IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();

	/**
	 * {@inheriteDoc}
	 * 
	 * @throws BLLException
	 */
	@Override
	public void insert(Utilisateur utilisateur) throws BLLException {

		try {
			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction insert : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void delete(Utilisateur utilisateur) throws BLLException {

		
		Integer id = utilisateur.getNoUtilisateur();
		
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction delete : " + e.getMessage());
		}

	}

	/**
	 * {@inheriteDoc}
	 * 
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
	
	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public List<Utilisateur> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectAll : " + e.getMessage());
		}
	}

	/**
	*{@inheriteDoc}
	*/
	@Override
	public Utilisateur selectLogin(String pseudo, String mdp) throws BLLException {
		
		try {
			return dao.selectLogin(pseudo, mdp);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectLogin  : " + e.getMessage());
		}
	}
	
	/**
	*{@inheriteDoc}
	*/
	@Override
	public Utilisateur selectPseudo(String pseudo) throws BLLException {
		
		try {
			return dao.selectPseudo(pseudo);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectPseudo  : " + e.getMessage());
		}
	}
	
	/**
	*{@inheriteDoc}
	*/
	@Override
	public Utilisateur selectById(Integer id) throws BLLException {
		
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById  : " + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public Utilisateur selectById(Utilisateur utilisateur) throws BLLException {
		
		try {
			return dao.selectById(utilisateur);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById  : " + e.getMessage());
		}
	}

}
