/**
 * 
 */
package fr.formation.enchere.eni.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.eni.bo.Utilisateur;

/**
 * Classe en charge de
 * 
 * @author msorin2022
 * @date 30 mars 2022
 * @version EnchereENI- V0.1
 * @since 30 mars 2022 - 10:18:30
 *
 */
public class UtilisateurModel {

	private Utilisateur utilisateur;
	private List<Utilisateur> lstUtilisateurs = new ArrayList<>();
	private String message;

	/**
	 * Constructeur.
	 */
	public UtilisateurModel() {
		super();
	}

	/**
	 * Constructeur.
	 * 
	 * @param utilisateur
	 * @param lstUtilisateurs
	 * @param message
	 */
	public UtilisateurModel(Utilisateur utilisateur, List<Utilisateur> lstUtilisateurs, String message) {
		super();
		this.utilisateur = utilisateur;
		this.lstUtilisateurs = lstUtilisateurs;
		this.message = message;
	}

	/**
	 * Getter pour utliUtilisateur.
	 * 
	 * @return the utliUtilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter pour utliUtilisateur.
	 * 
	 * @param utliUtilisateur the utliUtilisateur to set
	 */
	public void setUtilisateur(Utilisateur utliUtilisateur) {
		this.utilisateur = utliUtilisateur;
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
		builder.append("UtilisateurModel [");
		if (utilisateur != null) {
			builder.append("utilisateur=");
			builder.append(utilisateur);
			builder.append(", ");
		}
		if (lstUtilisateurs != null) {
			builder.append("lstUtilisateurs=");
			builder.append(lstUtilisateurs);
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
