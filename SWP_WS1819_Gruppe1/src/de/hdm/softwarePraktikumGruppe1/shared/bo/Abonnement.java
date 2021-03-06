/**
 * 
 */
package de.hdm.softwarePraktikumGruppe1.shared.bo;

/**
 * @author GianlucaBernert, AdamGniady
 * Klasse eines Abonnement Objekts das BusinessObject als Superklasse besitzt
 */
public class Abonnement {
	
	private static final long serialVersionUID = 1L;
	private int abonnementId;
	private int ownerId;
	private int pinnwandId;

	/**
	 * Der Konstruktor nimmt zwei Parameter entgegen. Zum einen den Owner des
	 * Abonnements und zum anderen die zu abonnierende Pinnwand. 
	 * 
	 * @param owner
	 * @param pinnwand
	 */
	public Abonnement(int ownerId, int pinnwandId) {
		this.ownerId = ownerId;
		this.pinnwandId = pinnwandId;
	}
	
	/*
	 * Leerer Konstruktor. Die Zuweisung der Attribute wird über die Setter-Methoden realisiert.
	 */
	public Abonnement() {
		
	}
	
	/*
	 * Methode, die die AbonnementId zurueck gibt
	 */
	public int getAbonnementId() {
		return abonnementId;
	}

	/*
	 * Methode, die das Setzen einer vorläufigen Id ermöglicht
	 */
	public void setAbonnementId(int abonnementId) {
		this.abonnementId = abonnementId;
	}
	
	/**
	 * Methode die den Besitzer des Abonnements zurueck gibt
	 */
	public int getOwnerId() {
		return ownerId;
	}
	
	/**
	 * Methode doe den Besitzer des Abonnements setzt
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	/**
	 * Methode die die abonnierte Pinnwand zurueck gibt
	 */
	public int getPinnwandId() {
		return pinnwandId;
	}
	
	/**
	 * Methode die die zu abonierende Pinnwand setzt
	 */
	public void setPinnwandId(int pinnwandId) {
		this.pinnwandId = pinnwandId;
	}
	
	/*
	 * Methode die den PinnwandUserString abbildet
	 */
	public String pinnwandUserString() {
		return null;
	}
}
