/**
 * 
 */
package fr.formation.enchere.eni.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.ArticleVendu;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 31 mars 2022
 * @version EnchereENI- V0.1
 * @since  31 mars 2022 - 11:08:11
 *
 */
public class ArticleModel {
	private ArticleVendu articleVendu;
	private List<ArticleVendu> lstArticles = new ArrayList<>();
	private String message;
	private boolean connecter;
	private Integer encheres;

	/**
	 * Constructeur.
	 */
	public ArticleModel() {
		super();
	}

	/**
	 * Constructeur.
	 * @param encheres
	 */
	public ArticleModel(Integer encheres) {
		super();
		this.encheres = encheres;
	}

	/**
	 * Getter pour encheres.
	 * @return the encheres
	 */
	public Integer getEncheres() {
		return encheres;
	}

	/**
	 * Setter pour encheres.
	 * @param encheres the encheres to set
	 */
	public void setEncheres(Integer encheres) {
		this.encheres = encheres;
	}

	/**
	 * Constructeur.
	 * @param articleVendu
	 * @param lstArticles
	 * @param message
	 */
	public ArticleModel(ArticleVendu articleVendu, List<ArticleVendu> lstArticles, String message) {
		this.articleVendu = articleVendu;
		this.lstArticles = lstArticles;
		this.message = message;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isConnecter() {
		return connecter;
	}

	public void setConnecter(boolean connecter) {
		this.connecter = connecter;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleModel [");
		if (articleVendu != null) {
			builder.append("articleVendu=");
			builder.append(articleVendu);
			builder.append(", ");
		}
		if (lstArticles != null) {
			builder.append("lstArticles=");
			builder.append(lstArticles);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		builder.append("connecter=");
		builder.append(connecter);
		builder.append("]");
		return builder.toString();
	}

}
