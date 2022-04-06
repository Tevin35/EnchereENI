/**
 * 
 */
package fr.formation.enchere.eni.bll;

import java.util.List;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:36:35
 *
 */
public interface IUtilisateurManager {
	
	public void insert(Utilisateur utilisateur) throws BLLException;
	
	public void update(Utilisateur utilisateur) throws BLLException;

	public List<Utilisateur> selectAll() throws BLLException;
	
	public Utilisateur selectById(Integer id) throws BLLException;
	
	public Utilisateur selectLogin(String pseudo, String mdp) throws BLLException;
	
	public Utilisateur selectById(Utilisateur utilisateur) throws BLLException;

	/**
	 * Méthode en charge de 
	 * @param pseudo
	 * @return
	 * @throws BLLException
	 */
	Utilisateur selectPseudo(String pseudo) throws BLLException;

	/**
	 * Méthode en charge de 
	 * @param id
	 * @throws BLLException
	 */
	void delete(Integer id) throws BLLException;

}
