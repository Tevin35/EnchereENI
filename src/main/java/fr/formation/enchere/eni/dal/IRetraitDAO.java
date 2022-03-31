/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.util.List;

import fr.formation.enchere.eni.bo.Retrait;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:30:41
 *
 */
public interface IRetraitDAO {

	public void insert(Retrait retrait) throws DALException;
	
	public void update(Retrait retrait, Integer id) throws DALException;
	
	public List<Retrait> selectAll() throws DALException;
	
	public void delete(Integer id) throws DALException;
	
	public Retrait selectById(Integer id) throws DALException;
	
	
}
