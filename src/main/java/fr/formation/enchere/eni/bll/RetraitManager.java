/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Retrait;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IRetraitDAO;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since 31 mars 2022 - 10:23:47
 *
 */
public class RetraitManager implements IRetraitManager {

	private IRetraitDAO dao = DAOFact.getRetraitDAO();

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void insert(Retrait retrait) throws BLLException {

		try {
			dao.insert(retrait);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction insert : " + e.getMessage());
		}
	}

	public void delete(Retrait retrait) throws BLLException {
		Integer id = null;
		ArticleVendu[] articlevendus = retrait.getArticleVendu();
		for (ArticleVendu articleVendu : articlevendus) {
			id = articleVendu.getNoArticle();

		}

		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());

		}
	}

	public void update(Retrait retrait) throws BLLException {
		Integer id = null;
		ArticleVendu[] articlevendus = retrait.getArticleVendu();
		for (ArticleVendu articleVendu : articlevendus) {
			id = articleVendu.getNoArticle();

		}
		try {
			dao.update(retrait, id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());
		}
	}

	public List<Retrait> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectAll : " + e.getMessage());
		}
	}

	public Retrait selectById(Retrait retrait) throws BLLException {

		Integer id = null;
		ArticleVendu[] articlevendus = retrait.getArticleVendu();
		for (ArticleVendu articleVendu : articlevendus) {
			id = articleVendu.getNoArticle();
		}
		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById : " + e.getMessage());
		}
	}

}
