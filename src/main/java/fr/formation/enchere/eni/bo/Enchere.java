/**
 * 
 */
package fr.formation.enchere.eni.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 29 mars 2022
 * @version EnchereENI- V0.1
 * @since 29 mars 2022 - 11:34:54
 *
 */
public class Enchere {

	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
	private List<ArticleVendu> lstArticleVendus = new ArrayList<ArticleVendu>();

	/**
	 * Constructeur.
	 * 
	 * @param noEnchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param lstUtilisateurs
	 * @param lstArticleVendus
	 */
	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere, List<Utilisateur> lstUtilisateurs,
			List<ArticleVendu> lstArticleVendus) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.lstUtilisateurs = lstUtilisateurs;
		this.lstArticleVendus = lstArticleVendus;
	}

	/**
	 * Getter pour noEnchere.
	 * 
	 * @return the noEnchere
	 */
	public Integer getNoEnchere() {
		return noEnchere;
	}

	/**
	 * Setter pour noEnchere.
	 * 
	 * @param noEnchere the noEnchere to set
	 */
	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}

	/**
	 * Getter pour dateEnchere.
	 * 
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * Setter pour dateEnchere.
	 * 
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * Getter pour montantEnchere.
	 * 
	 * @return the montantEnchere
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * Setter pour montantEnchere.
	 * 
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * Getter pour lstUtilisateurs.
	 * 
	 * @return the lstUtilisateurs
	 */
	public List<Utilisateur> getLstUtilisateurs() {
		return lstUtilisateurs;
	}

	/**
	 * Setter pour lstUtilisateurs.
	 * 
	 * @param lstUtilisateurs the lstUtilisateurs to set
	 */
	public void setLstUtilisateurs(List<Utilisateur> lstUtilisateurs) {
		this.lstUtilisateurs = lstUtilisateurs;
	}

	/**
	 * Getter pour lstArticleVendus.
	 * 
	 * @return the lstArticleVendus
	 */
	public List<ArticleVendu> getLstArticleVendus() {
		return lstArticleVendus;
	}

	/**
	 * Setter pour lstArticleVendus.
	 * 
	 * @param lstArticleVendus the lstArticleVendus to set
	 */
	public void setLstArticleVendus(List<ArticleVendu> lstArticleVendus) {
		this.lstArticleVendus = lstArticleVendus;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [");
		if (dateEnchere != null) {
			builder.append("dateEnchere=");
			builder.append(dateEnchere);
			builder.append(", ");
		}
		if (montantEnchere != null) {
			builder.append("montantEnchere=");
			builder.append(montantEnchere);
			builder.append(", ");
		}
		if (lstUtilisateurs != null) {
			builder.append("lstUtilisateurs=");
			builder.append(lstUtilisateurs);
			builder.append(", ");
		}
		if (lstArticleVendus != null) {
			builder.append("lstArticleVendus=");
			builder.append(lstArticleVendus);
		}
		builder.append("]");
		return builder.toString();
	}

}
