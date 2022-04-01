/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IArticleDAO;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since  30 mars 2022 - 11:33:23
 *
 */
public class ArticleManager implements IArticleManager {
	private IArticleDAO dao = DAOFact.getArticleDAO();

	/**
	*{@inheriteDoc}
	 * @throws BLLException 
	*/
	@Override
	public void insert(ArticleVendu articleVendu) throws BLLException {

		try {
			dao.insert(articleVendu);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction insert : " + e.getMessage());
		}
	}
		
	/**
	*{@inheritedDoc}
	*/
	@Override
	public void delete(ArticleVendu articleVendu) throws BLLException {
		
		Integer id = articleVendu.getNoArticle();
		
		try {
			dao.delete(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction delete : " + e.getMessage());
		}
		
	}

	/**
	*{@inheriteDoc}
	 * @throws BLLException 
	*/
	@Override
	public void update(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.update(articleVendu, articleVendu.getNoArticle());
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());
		}
	}
	
	/**
	*{@inheritedDoc}
	 * @throws BLLException 
	*/
	@Override
	public List<ArticleVendu> selectAll() throws BLLException {
		try {
			return dao.selectAll();
		} catch (DALException e) {
			throw new BLLException("BLL - ERREUR DANS LA FONCTION SELECT : " + e.getMessage());
		}
	}

	/**
	*{@inheritedDoc}
	*/
	@Override
	public ArticleVendu selectById(ArticleVendu articleVendu) throws BLLException {
		
		Integer id = articleVendu.getNoArticle();
		
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
	public ArticleVendu selectById(Integer id1) throws BLLException {
		
		try {
			return dao.selectById(id1);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById  : " + e.getMessage());
		}
	}

}
