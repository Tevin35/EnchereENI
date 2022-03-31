/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Enchere;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IEnchereDAO;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since  30 mars 2022 - 16:48:40
 *
 */
public class EnchereManager implements IEnchereManager{
	
	IEnchereDAO dao = DAOFact.getEnchereDAO();

	/**
	*{@inheriteDoc}
	*/
	@Override
	public void insert(Enchere enchere) throws BLLException {
		
		try {
			dao.insert(enchere);
		} catch (DALException e) {
			throw new BLLException("BLL - Erreur dans la fonction insert : " + e.getMessage());
		}
		
	}

	/**
	*{@inheriteDoc}
	*/
	@Override
	public void update(Enchere enchere, Integer id) throws BLLException {

		try {
			dao.update(enchere, id);
		} catch (DALException e) {
			throw new BLLException("BLL - Erreur dans la fonction update : " + e.getMessage());
		}
		
	}

	/**
	*{@inheriteDoc}
	*/
	@Override
	public void delete(Integer id) throws BLLException {

		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("BLL - Erreur dans la fonction delete : " + e.getMessage());
		}
		
	}

	/**
	*{@inheriteDoc}
	*/
	@Override
	public List<Enchere> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - Erreur dans la fonction selectAll : " + e.getMessage());
		}
	}

	/**
	*{@inheriteDoc}
	*/
	@Override
	public Enchere selectById(Integer id) throws BLLException {
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("BLL - Erreur dans la fonction salectById : " + e.getMessage());
		}
	}

}
