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
 * @since 29 mars 2022 - 11:34:18
 *
 */
public class ArticleVendu {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
	private Enchere concerne;
	private List<Categorie> lstCategories = new ArrayList<Categorie>();
	private Retrait lieuRetrait;
	private Utilisateur noUtilisateur;
	private Categorie noCategorie;
	/**
	 * Constructeur.
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param lstUtilisateurs
	 * @param concerne
	 * @param lstCategories
	 * @param lieuRetrait
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente,
			List<Utilisateur> lstUtilisateurs, Enchere concerne, List<Categorie> lstCategories, Retrait lieuRetrait,
			Utilisateur noUtilisateur, Categorie noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.lstUtilisateurs = lstUtilisateurs;
		this.concerne = concerne;
		this.lstCategories = lstCategories;
		this.lieuRetrait = lieuRetrait;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	/**
	 * Constructeur.
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, Utilisateur noUtilisateur, Categorie noCategorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	
	/**
	 * Constructeur.
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Utilisateur noUtilisateur,
			Categorie noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	
	
	
	/**
	 * Constructeur.
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
	}
	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Integer getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public Integer getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public List<Utilisateur> getLstUtilisateurs() {
		return lstUtilisateurs;
	}
	public void setLstUtilisateurs(List<Utilisateur> lstUtilisateurs) {
		this.lstUtilisateurs = lstUtilisateurs;
	}
	public Enchere getConcerne() {
		return concerne;
	}
	public void setConcerne(Enchere concerne) {
		this.concerne = concerne;
	}
	public List<Categorie> getLstCategories() {
		return lstCategories;
	}
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public Categorie getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(Categorie noCategorie) {
		this.noCategorie = noCategorie;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [");
		if (noArticle != null) {
			builder.append("noArticle=");
			builder.append(noArticle);
			builder.append(", ");
		}
		if (nomArticle != null) {
			builder.append("nomArticle=");
			builder.append(nomArticle);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (dateDebutEncheres != null) {
			builder.append("dateDebutEncheres=");
			builder.append(dateDebutEncheres);
			builder.append(", ");
		}
		if (dateFinEncheres != null) {
			builder.append("dateFinEncheres=");
			builder.append(dateFinEncheres);
			builder.append(", ");
		}
		if (miseAPrix != null) {
			builder.append("miseAPrix=");
			builder.append(miseAPrix);
			builder.append(", ");
		}
		if (prixVente != null) {
			builder.append("prixVente=");
			builder.append(prixVente);
			builder.append(", ");
		}
		if (etatVente != null) {
			builder.append("etatVente=");
			builder.append(etatVente);
			builder.append(", ");
		}
		if (lstUtilisateurs != null) {
			builder.append("lstUtilisateurs=");
			builder.append(lstUtilisateurs);
			builder.append(", ");
		}
		if (concerne != null) {
			builder.append("concerne=");
			builder.append(concerne);
			builder.append(", ");
		}
		if (lstCategories != null) {
			builder.append("lstCategories=");
			builder.append(lstCategories);
			builder.append(", ");
		}
		if (lieuRetrait != null) {
			builder.append("lieuRetrait=");
			builder.append(lieuRetrait);
			builder.append(", ");
		}
		if (noUtilisateur != null) {
			builder.append("noUtilisateur=");
			builder.append(noUtilisateur);
			builder.append(", ");
		}
		if (noCategorie != null) {
			builder.append("noCategorie=");
			builder.append(noCategorie);
		}
		builder.append("]");
		return builder.toString();
	}

	
	
}