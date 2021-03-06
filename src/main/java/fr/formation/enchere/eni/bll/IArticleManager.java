/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:35:34
 *
 */
public interface IArticleManager {

	public void insert(ArticleVendu articleVendu) throws BLLException;
	
	public void update(ArticleVendu articleVendu) throws BLLException;

	public List<ArticleVendu> selectAll() throws BLLException;
	
	public ArticleVendu selectById(Integer id) throws BLLException;
	
	public void delete(ArticleVendu articleVendu) throws BLLException;

	/**
	 * Méthode en charge de 
	 * @param articleVendu
	 * @return
	 * @throws BLLException
	 */
	public ArticleVendu selectById(ArticleVendu articleVendu) throws BLLException;

	/**
	 * Méthode en charge de 
	 * @param id
	 * @throws BLLException
	 */
	void deleteUtilisateur(Integer id) throws BLLException;

	public List<ArticleVendu> filtreCat(Integer noCat) throws BLLException;
	
	public List<ArticleVendu> filtreRecherche(String recherche) throws BLLException;
}
