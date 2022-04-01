/**
 * 
 */
package fr.formation.enchere.eni.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.Categorie;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 1 avr. 2022
 * @version EnchereENI- V0.1
 * @since 1 avr. 2022 - 11:53:29
 *
 */
public class CategorieModel {

	private Categorie categorie;
	private List<Categorie> lstCategories = new ArrayList<>();
	private String message;

	/**
	 * Constructeur.
	 * 
	 * @param categorie
	 * @param lstCategories
	 * @param message
	 */
	public CategorieModel(Categorie categorie, List<Categorie> lstCategories, String message) {
		super();
		this.categorie = categorie;
		this.lstCategories = lstCategories;
		this.message = message;
	}

	/**
	 * Constructeur.
	 */
	public CategorieModel() {
		super();
	}

	/**
	 * Getter pour categorie.
	 * 
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter pour categorie.
	 * 
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Getter pour lstCategories.
	 * 
	 * @return the lstCategories
	 */
	public List<Categorie> getLstCategories() {
		return lstCategories;
	}

	/**
	 * Setter pour lstCategories.
	 * 
	 * @param lstCategories the lstCategories to set
	 */
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}

	/**
	 * Getter pour message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter pour message.
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * {@inheriteDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategorieModel [");
		if (categorie != null) {
			builder.append("categorie=");
			builder.append(categorie);
			builder.append(", ");
		}
		if (lstCategories != null) {
			builder.append("lstCategories=");
			builder.append(lstCategories);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
		}
		builder.append("]");
		return builder.toString();
	}

}
