/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.dal.DALException;
import fr.formation.enchere.eni.dal.DAOFact;
import fr.formation.enchere.eni.dal.IArticleDAO;

/**
 * Classe en charge de
 * 
 * @author tabhay2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since 30 mars 2022 - 11:33:23
 *
 */
public class ArticleManager implements IArticleManager {
	private IArticleDAO dao = DAOFact.getArticleDAO();

	/**
	 * {@inheriteDoc}
	 * 
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
	 * {@inheritedDoc}
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
	 * {@inheritedDoc}
	 */
	@Override
	public void deleteUtilisateur(Integer id) throws BLLException {

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
	public void update(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.update(articleVendu, articleVendu.getNoArticle());
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction update : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 * 
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
	 * {@inheritedDoc}
	 */
	@Override
	public ArticleVendu selectById(Integer id) throws BLLException {

		try {
			return dao.selectById(id);
		} catch (DALException e) {
			throw new BLLException("BLL - erreur dans la fonction selectById  : " + e.getMessage());
		}
	}

	/**
	 * {@inheriteDoc}
	 */
	@Override
	public ArticleVendu selectById(ArticleVendu articleVendu) throws BLLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ArticleVendu> filtreCat(Integer noCat) throws BLLException {
		List<ArticleVendu> lstArticle = new ArrayList<ArticleVendu>();
		List<ArticleVendu> lstFiltre = new ArrayList<ArticleVendu>();

		try {
			lstArticle = selectAll();

			for (ArticleVendu articleVendu : lstArticle) {
				if (articleVendu.getNoCategorie().getNoCategorie() == noCat) {
					lstFiltre.add(articleVendu);
				}
			}

		} catch (BLLException e) {
			throw new BLLException("erreur dans le filtre categorie");
		}
		return lstFiltre;
	}

	public List<ArticleVendu> filtreRecherche(String recherche) throws BLLException {
		List<ArticleVendu> lstArticle = new ArrayList<ArticleVendu>();
		List<ArticleVendu> lstFiltre = new ArrayList<ArticleVendu>();
		try {
			lstArticle = selectAll();

			// nom article
			for (ArticleVendu articleVendu : lstArticle) {
				if (articleVendu.getNomArticle().contains(recherche)) {
					lstFiltre.add(articleVendu);
				}
			}
		} catch (BLLException e) {
			throw new BLLException("erreur dans le filtre recherche");
		}

		// nom vendeur

		// description

		return lstFiltre;
	}

}
