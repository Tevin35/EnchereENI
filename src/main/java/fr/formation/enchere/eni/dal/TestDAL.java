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
		
		IArticleDAO dao = DAOFact.getArticleDAO();
		try {
			System.out.println(dao.selectById(1));
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}	
}
