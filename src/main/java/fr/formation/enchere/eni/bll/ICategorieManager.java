/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Categorie;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:35:47
 *
 */
public interface ICategorieManager {

	public void insert(Categorie categorie) throws BLLException;
	
	public void update (Categorie categorie) throws BLLException;
	
	public List<Categorie> selectAll() throws BLLException;
	
	public Categorie selectById(Integer id) throws BLLException;
	
	public void delete (Categorie categorie) throws BLLException;

	/**
	 * Méthode en charge de 
	 * @param categorie
	 * @return
	 * @throws BLLException
	 */
	public Categorie selectById(Categorie categorie) throws BLLException;
	
}
