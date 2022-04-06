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

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Retrait;
import fr.formation.enchere.eni.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 15:18:15
 *
 */
public class RetraitDAO implements IRetraitDAO {

	private final String SELECTALL = "SELECT no_article, rue, code_postal, ville FROM RETRAITS";
	private final String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (? ,? ,? , ?)";
	private final String UPDATE = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
	private final String DELETE = "DELETE INTO RETRAITS WHERE no_article = ?";
	private final String SELECTBYID = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";

	private IArticleDAO daoA = DAOFact.getArticleDAO();

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public List<Retrait> selectAll() throws DALException {

		ArticleVendu[] articleVendus = new ArticleVendu[1];
		List<Retrait> result = new ArrayList<Retrait>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				ArticleVendu article = daoA.selectById(rs.getInt("no_article"));
				for (int i = 0; i < articleVendus.length; i++) {
					articleVendus[i] = article;
				}
				Retrait retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						articleVendus);
				result.add(retrait);
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
	public Retrait selectById(Integer id) throws DALException {

		ArticleVendu[] articleVendus = new ArticleVendu[1];

		Retrait result = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				ArticleVendu article = daoA.selectById(rs.getInt("no_article"));
				for (int i = 0; i < articleVendus.length; i++) {
					articleVendus[i] = article;
				}
				result = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						articleVendus);

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

	public void insert(Retrait retrait) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
//			ArticleVendu[] articleVendus = new ArticleVendu[1];
//			Integer id = null;
//			ArticleVendu[] article = retrait.getArticleVendu();
//			for (ArticleVendu articleVendu : article) {
//				id = articleVendu.getNoArticle();
//			}
			PreparedStatement stmt = cnx.prepareStatement(INSERT);

			stmt.setInt(1, retrait.getNoArticle().getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4, retrait.getVille());

			stmt.executeUpdate();

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

			PreparedStatement stmt = cnx.prepareStatement(DELETE);

			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Erreur dans la fonction delete : " + e.getMessage());
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void update(Retrait retrait, Integer id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(UPDATE);

			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());

			stmt.setInt(4, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("DAL - Erreur dans la fonction update : " + e.getMessage());
		}

	}

}
