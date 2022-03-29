/**
 * 
 */
package fr.formation.enchere.eni.bll;

/**
 * Classe en charge de n'avoir qu'une seule instance de bll
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 15:04:05
 *
 */
public class UtilisateurManagerSing {

	private static IUtilisateurManager instance;
	public static IUtilisateurManager getInstance() {
		if(instance==null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
}
