/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.util.List;

import fr.formation.enchere.eni.bo.Categorie;
import fr.formation.enchere.eni.bo.Retrait;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 11:30:28
 *
 */
public interface ICategorieDAO {

	public void insert(Categorie categorie) throws DALException;

	public void update(Categorie categorie, Integer id) throws DALException;

	public List<Categorie> selectAll() throws DALException;

	public void delete(Integer id) throws DALException;

	public Categorie selectById(Integer id) throws DALException;

}
