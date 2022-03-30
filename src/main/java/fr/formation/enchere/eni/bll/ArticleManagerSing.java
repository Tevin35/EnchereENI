/**
 * 
 */
package fr.formation.enchere.eni.bll;

/**
 * Classe en charge de n'avoir qu'une seule instance de bll
 * @author tabhay2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since  30 mars 2022 - 11:54:54
 *
 */
public class ArticleManagerSing {
	
	private static IArticleManager instance;
	public static IArticleManager getInstance() {
		if(instance==null) {
			instance = new ArticleManager();
		}
		return instance;
	}
}
