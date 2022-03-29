/**
 * 
 */
package fr.formation.enchere.eni.dal;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 14:41:55
 *
 */
public class TestDAL {
	public static void main(String[] args) {
		Utilisateur utilisateur = new Utilisateur("Lubulul", "Hut", "Laurent", "laurent.hut@mail.com", "0202130405",
				"6 rue de Paris", "01000", "Paris", "0000", 1000, false);

		IUtilisateurDAO dao = DAOFact.getUtilisateurDAO();
		
		try {
			dao.insert(utilisateur);
		} catch (DALException e) {
			e.getMessage();
		}
		
		Utilisateur utilisateurModif = new Utilisateur("Lubulul", "Hut", "Laurent", "laurent.hut@mail.com", "0450700119",
				"6 rue de Paris", "01000", "Paris", "0000", 1000, false);
		
		try {
			dao.update(utilisateurModif, utilisateur.getNoUtilisateur());
		} catch (DALException e) {
			e.getMessage();
		}
	}
	
	

}
