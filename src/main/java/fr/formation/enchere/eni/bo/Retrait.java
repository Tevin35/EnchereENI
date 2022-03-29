/**
 * 
 */
package fr.formation.enchere.eni.bo;

import java.util.Arrays;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:34:32
 *
 */
public class Retrait {
	
	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu[] articleVendu = new ArticleVendu[1];
	/**
	 * Constructeur.
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param articleVendu
	 */
	public Retrait(String rue, String codePostal, String ville, ArticleVendu[] articleVendu) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}
	/**
	 * Getter pour rue.
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * Setter pour rue.
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * Getter pour codePostal.
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * Setter pour codePostal.
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * Getter pour ville.
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * Setter pour ville.
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * Getter pour articleVendu.
	 * @return the articleVendu
	 */
	public ArticleVendu[] getArticleVendu() {
		return articleVendu;
	}
	/**
	 * Setter pour articleVendu.
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu[] articleVendu) {
		this.articleVendu = articleVendu;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [");
		if (rue != null) {
			builder.append("rue=");
			builder.append(rue);
			builder.append(", ");
		}
		if (codePostal != null) {
			builder.append("codePostal=");
			builder.append(codePostal);
			builder.append(", ");
		}
		if (ville != null) {
			builder.append("ville=");
			builder.append(ville);
			builder.append(", ");
		}
		if (articleVendu != null) {
			builder.append("articleVendu=");
			builder.append(Arrays.toString(articleVendu));
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
