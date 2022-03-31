/**
 * 
 */
package fr.formation.enchere.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Enchere;
import fr.formation.enchere.eni.bo.Utilisateur;
import fr.formation.enchere.eni.dal.util.ConnectionProvider;

/**
 * Classe en charge de
 * 
 * @author cmounier2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 15:20:25
 *
 */
public class EnchereDAO implements IEnchereDAO {

	private String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_articles, no_utilisateur) VALUES (?, ?, ?, ?)";
	private String UPDATE = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ?, no_articles = ?, no_utilisateur = ? WHERE no_enchere = ?";
	private String DELETE = "DELETE INTO ENCHERES WHERE no_enchere = ?";
	private String SELECTALL = "SELECT date_enchere, montant_enchere, no_articles, no_utilisateur FROM ENCHERES";
	private String SELECTBYID = "SELECT date_enchere, montant_enchere, no_articles, no_utilisateur FROM ENCHERES WHERE no_enchere = ?";

	private IUtilisateurDAO daoU = DAOFact.getUtilisateurDAO();
	private IArticleDAO daoA = DAOFact.getArticleDAO();

	/**
	 * {@inheriteDoc}
	 * 
	 * @throws DALException
	 */
	@Override
	public void insert(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stmt.setDate(1, Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.setInt(3, enchere.getLstArticleVendus().get(0).getNoArticle());
			stmt.setInt(4, enchere.getLstUtilisateurs().get(0).getNoUtilisateur());

			Integer nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					enchere.setNoEnchere((rs.getInt(1)));
				}
			}

		} catch (SQLException e) {
			throw new DALException("DAL - Erreur dans la fonction insert : " + e.getMessage());
		}

	}

	/**
	 * {@inheriteDoc}
	 * 
	 * @throws DALException
	 */
	@Override
	public void update(Enchere enchere, Integer id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(UPDATE);

			stmt.setDate(1, Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.setInt(3, enchere.getLstArticleVendus().get(0).getNoArticle());
			stmt.setInt(4, enchere.getLstUtilisateurs().get(0).getNoUtilisateur());

			stmt.setInt(5, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("DAL - Erreur dans la fonction update : " + e.getMessage());
		}
	}

	/**
	 * {@inheriteDoc}
	 * 
	 * @throws DALException
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
	 * {@inheriteDoc}
	 * 
	 * @throws DALException
	 */
	@Override
	public List<Enchere> selectAll() throws DALException {
		List<Enchere> result = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				List<Utilisateur> lstUtilisateurs = new ArrayList<>();
				List<ArticleVendu> lstArticleVendus = new ArrayList<>();

				lstUtilisateurs.add(daoU.selectById(rs.getInt("no_utilisateur")));
				lstArticleVendus.add(daoA.selectById(rs.getInt("no_article")));

				Enchere enchere = new Enchere(rs.getInt("no_enchere"), rs.getDate("date_enchere").toLocalDate(),
						rs.getInt("montant_enchere"), lstUtilisateurs, lstArticleVendus);
				result.add(enchere);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme dans la fonction selectAll : " + e.getMessage());
		}
		return result;
	}

	/**
	 * {@inheriteDoc}
	 */
	@Override
	public Enchere selectById(Integer id) throws DALException {

		Enchere enchere = null;
		List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
		List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				Utilisateur utilisateur = daoU.selectById(rs.getInt("no_utilisateur"));
				ArticleVendu article = daoA.selectById(rs.getInt("no_article"));

				lstUtilisateurs.add(utilisateur);
				lstArticleVendus.add(article);

				enchere = new Enchere(rs.getInt("no_enchere"), rs.getDate("date_enchere").toLocalDate(),
						rs.getInt("montant_enchere"), lstUtilisateurs, lstArticleVendus);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme dans la fonction selectById : " + e.getMessage());
		}
		return enchere;
	}

}
