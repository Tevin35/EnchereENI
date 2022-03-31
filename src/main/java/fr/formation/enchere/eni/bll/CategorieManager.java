/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Categorie;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.ICategorieDAO;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since 31 mars 2022 - 11:33:51
 *
 */
public class CategorieManager implements ICategorieManager {

	private ICategorieDAO dao = DAOFact.getCategorieDAO();

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void insert(Categorie categorie) throws BLLException {

		try {
			dao.insert(categorie);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction insert : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void delete(Categorie categorie) throws BLLException {

		Integer id = categorie.getNoCategorie();

		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction delete : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void update(Categorie categorie) throws BLLException {
		try {
			dao.update(categorie, categorie.getNoCategorie());
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<Categorie> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectAll : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public Categorie selectById(Categorie categorie) throws BLLException {

		Integer id = categorie.getNoCategorie();

		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById : " + e.getMessage());
		}
	}	

}
