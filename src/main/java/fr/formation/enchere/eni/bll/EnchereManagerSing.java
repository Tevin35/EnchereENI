/**
 * 
 */
package fr.formation.enchere.eni.bll;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since  31 mars 2022 - 09:16:58
 *
 */
public class EnchereManagerSing {
	
	private static IEnchereManager instance;
	public static IEnchereManager getInstance() {
		if(instance==null) {
			instance = new EnchereManager();
		}
		return instance;
	}

}
