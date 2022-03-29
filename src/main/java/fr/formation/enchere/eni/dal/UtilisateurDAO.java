/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 14:04:10
 *
 */
public class UtilisateurDAO implements IUtilisateurDAO {
	private final String DELETE =  "DELETE INTO UTILISATEURS (pseudo, nom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administateur) WHERE no_utilisateur = ?";
	
	@Override
	public void delete(Utilisateur utilisateur) throws DALException{
		try (Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement stmt = cnx.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());
			stmt.setInt(12, utilisateur.getNoUtilisateur());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction delete : " + e.getMessage());
		}
		
	
	}
}
