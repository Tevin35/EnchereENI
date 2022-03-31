/**
 * 
 */
package fr.formation.enchere.eni.bll;

/**
 * Classe en charge de
 * @author cmounier2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since  30 mars 2022 - 16:52:54
 *
 */
public class RetraitManagerSing {
	private static IRetraitManager instance;
	public static IRetraitManager getInstance() {
		if(instance==null) {
			instance = new RetraitManager();
		}
		return instance;
	}
	

}
