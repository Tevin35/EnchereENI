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

	public List<ArticleVendu>selectAll();
	
}
