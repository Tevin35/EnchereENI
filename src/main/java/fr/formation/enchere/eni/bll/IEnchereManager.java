/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Enchere;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:36:03
 *
 */
public interface IEnchereManager {

	public void insert(Enchere enchere) throws BLLException;
	
	public void update(Enchere enchere, Integer id) throws BLLException;
	
	public void delete(Integer id) throws BLLException;
	
	public List<Enchere> selectAll() throws BLLException;
	
	public Enchere selectById(Integer id) throws BLLException;
	
}
