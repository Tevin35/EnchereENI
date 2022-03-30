/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.util.List;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:29:17
 *
 */
public interface IUtilisateurDAO {
	
	public void insert(Utilisateur utilisateur) throws DALException;
	
	public void update(Utilisateur utilisateur, Integer id) throws DALException;

	public List<Utilisateur>selectAll() throws DALException; 
	
	public Utilisateur selectById(Integer id) throws DALException;
	
	public void delete(Integer id) throws DALException;
}
