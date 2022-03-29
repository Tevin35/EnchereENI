/**
 * 
 */
package fr.formation.enchere.eni.bo;

/**
 * Classe en charge de
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since  29 mars 2022 - 11:34:44
 *
 */
public class Categorie {

	private Integer noCategorie;
	private String libelle;
	private ArticleVendu categorieArticle;
	/**
	 * Constructeur.
	 * @param noCategorie
	 * @param libelle
	 * @param categorieArticle
	 */
	public Categorie(Integer noCategorie, String libelle, ArticleVendu categorieArticle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.categorieArticle = categorieArticle;
	}
	/**
	 * Constructeur.
	 * @param libelle
	 * @param categorieArticle
	 */
	public Categorie(String libelle, ArticleVendu categorieArticle) {
		super();
		this.libelle = libelle;
		this.categorieArticle = categorieArticle;
	}
	/**
	 * Getter pour noCategorie.
	 * @return the noCategorie
	 */
	public Integer getNoCategorie() {
		return noCategorie;
	}
	/**
	 * Setter pour noCategorie.
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	/**
	 * Getter pour libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Setter pour libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Getter pour categorieArticle.
	 * @return the categorieArticle
	 */
	public ArticleVendu getCategorieArticle() {
		return categorieArticle;
	}
	/**
	 * Setter pour categorieArticle.
	 * @param categorieArticle the categorieArticle to set
	 */
	public void setCategorieArticle(ArticleVendu categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	/**
	*{@inheritedDoc}
	*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [");
		if (noCategorie != null) {
			builder.append("noCategorie=");
			builder.append(noCategorie);
			builder.append(", ");
		}
		if (libelle != null) {
			builder.append("libelle=");
			builder.append(libelle);
			builder.append(", ");
		}
		if (categorieArticle != null) {
			builder.append("categorieArticle=");
			builder.append(categorieArticle);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
