/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:30:00
 *
 */
public interface IArticleDAO  {

	public void insert(ArticleVendu articleVendu) throws DALException;
	
	public void update(ArticleVendu articleVendu, Integer id) throws DALException;

	public List<ArticleVendu> selectAll() throws DALException;
	
	public void delete(Integer id) throws DALException;
	
}
