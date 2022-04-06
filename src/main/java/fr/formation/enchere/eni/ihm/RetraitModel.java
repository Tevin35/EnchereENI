/**
 * 
 */
package fr.formation.enchere.eni.ihm;

import fr.formation.enchere.eni.bo.ArticleVendu;
import fr.formation.enchere.eni.bo.Retrait;

/**
 * Classe en charge de
 * @author tabhay2022
 * @date 6 avr. 2022
 * @version EnchereENI- V0.1
 * @since  6 avr. 2022 - 11:59:10
 *
 */
public class RetraitModel {
	private Retrait retrait;
	private ArticleVendu articleVendu;
	private String message;
	private boolean connecter;
	public Retrait getRetrait() {
		return retrait;
	}
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
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
		builder.append("RetraitModel [");
		if (retrait != null) {
			builder.append("retrait=");
			builder.append(retrait);
			builder.append(", ");
		}
		if (articleVendu != null) {
			builder.append("articleVendu=");
			builder.append(articleVendu);
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
