/**
 * 
 */
package fr.formation.enchere.eni.bll;

/**
 * Classe en charge de
 * @author cmounier2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since  31 mars 2022 - 11:29:15
 *
 */
public class CategorieManagerSing {

	private static ICategorieManager instance;
	public static ICategorieManager getInstance() {
		if(instance==null) {
			instance = new CategorieManager();
		}
		return instance;
	}
}
