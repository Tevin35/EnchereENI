package fr.formation.enchere.eni.dal;

public class DAOFact{
	public static IUtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAO();
	}
	public static IArticleDAO getArticleDAO() {
		return new ArticleDAO();
	}
}