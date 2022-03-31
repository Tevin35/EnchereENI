/**
 * 
 */
package fr.formation.enchere.eni.dal;

import fr.formation.enchere.eni.bo.Categorie;

/**
 * Classe en charge de
 * @author cmounier2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since  31 mars 2022 - 09:44:11
 *
 */
public class InsertCategorie {

	/**
	 * Méthode en charge de 
	 * @param args
	 */
	public static void main(String[] args) {
		ICategorieDAO dao = DAOFact.getCategorieDAO();
		
		Categorie info = new Categorie("Informatique", null);
		
		
		
		
		try {
			dao.insert(info);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
