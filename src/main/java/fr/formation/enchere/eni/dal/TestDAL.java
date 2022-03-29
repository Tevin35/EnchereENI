/**
 * 
 */
package fr.formation.enchere.eni.dal;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 14:59:39
 *
 */
public class TestDAL {
	public static void main(String[] args) {
		IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();
		
		Utilisateur utilisateur = utilisateur.getNoUtilisateur(2);
		
		
		try {
			dao.delete(utilisateur);
		} catch (DALException e) {
			e.getMessage();
		}
	}
}
