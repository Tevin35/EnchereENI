/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 15:07:16
 *
 */
public class UtilisateurDAO implements IUtilisateurDAO {

	private final String SELECT = "SELECT  no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<Utilisateur> selectAll() throws DALException {
		List<Utilisateur> result = new ArrayList<Utilisateur>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				result.add(utilisateur);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme de select : " + e.getMessage());
		}
		return result;
	}

}
