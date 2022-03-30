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
	
	public void delete(ArticleVendu articleVendu) throws BLLException;

}
