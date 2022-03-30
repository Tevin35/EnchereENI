/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.util.List;

import fr.formation.enchere.eni.bo.Enchere;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:18:38
 *
 */
public interface IEnchereDAO {

	public void insert(Enchere enchere) throws DALException;
	
	public void update(Enchere enchere, Integer id) throws DALException;
	
	public void delete(Integer id) throws DALException;
	
	public List<Enchere> selectAll() throws DALException;
	
	public Enchere selectById(Integer id);
	
}
