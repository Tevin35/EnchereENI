/**
 * 
 */
package fr.formation.enchere.eni.bll;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:36:35
 *
 */
public interface IUtilisateurManager {
	
	public void insert(Utilisateur utilisateur) throws BLLException;
	
	public void update(Utilisateur utilisateur) throws BLLException;

}
