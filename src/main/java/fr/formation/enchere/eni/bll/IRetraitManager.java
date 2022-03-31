/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Retrait;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 11:36:18
 *
 */
public interface IRetraitManager {

	public void insert(Retrait retrait) throws BLLException;
	
	public void update(Retrait retrait) throws BLLException;

	public List<Retrait> selectAll() throws BLLException;
	
	public Retrait selectById(Retrait retrait) throws BLLException;
	
	public void delete (Retrait retrait) throws BLLException;

}
