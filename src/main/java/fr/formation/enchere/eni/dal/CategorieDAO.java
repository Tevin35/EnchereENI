/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.Categorie;
import fr.formation.enchere.eni.bo.Retrait;
import fr.formation.enchere.eni.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 15:22:22
 *
 */
public class CategorieDAO implements ICategorieDAO {

	private final String SELECT = "SELECT no_categorie, libelle FROM CATEGORIES";
	private final String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private final String UPDATE = "UPDATE CATEGORIES SET libelle = ?, WHERE no_categorie = ?";
	private final String DELETE = "DELETE INTO CATEGORIES WHERE no_categorie = ?";
	private final String SELECT_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<Categorie> selectAll() throws DALException {
		List<Categorie> result = new ArrayList<Categorie>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")), rs.getString("categorie_article"));
				result.add(categorie);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme de select : " + e.getMessage());

		}
		return result;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void insert(Categorie categorie) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, categorie.getLibelle());
			stmt.setString(2, categorie.getCategorie_article());

			Integer nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie((rs.getInt(1)));
				}
			}

			Integer nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie((rs.getInt(1)));
				}
			}

		} catch (SQLException e) {
			throw new DALException("DAL - Erreur dans la fonction insert : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void delete(Integer id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(2, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction delete : " + e.getMessage());
		}

	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void update(Categorie categorie, Integer id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(UPDATE);

			stmt.setString(1, categorie.getLibelle());
			stmt.setString(2, categorie.getCategorie_article());

			stmt.setInt(3, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("DAL - Erreur dans la fonction update : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void selectById(Integer id) throws DALException {
		Retrait result = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"), rs.getString("categorie_article"));

			}
		} catch (SQLException e) {
			throw new DALException("Probleme de select : " + e.getMessage());

		}
		return result;
	}

}