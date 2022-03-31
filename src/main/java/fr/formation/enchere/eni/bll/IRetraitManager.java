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

	public void addRetrait(Retrait retrait) throws BLLException;

	public List<Retrait> getAllRetraits() throws BLLException;

}
