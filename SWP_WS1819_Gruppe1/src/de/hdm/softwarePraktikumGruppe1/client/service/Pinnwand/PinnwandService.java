package de.hdm.softwarePraktikumGruppe1.client.service.Pinnwand;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.softwarePraktikumGruppe1.shared.bo.Abonnement;
import de.hdm.softwarePraktikumGruppe1.shared.bo.Beitrag;
import de.hdm.softwarePraktikumGruppe1.shared.bo.Kommentar;
import de.hdm.softwarePraktikumGruppe1.shared.bo.Like;
import de.hdm.softwarePraktikumGruppe1.shared.bo.User;

@RemoteServiceRelativePath("pinnwandService")
public interface PinnwandService extends RemoteService{

	void init() throws IllegalArgumentException;
	public Vector<User> showAllUser();
	User createSingleUserTestMethod(String vorname, String nachname, String nickname);
	/**
	 * Methode um einen User zu erzeugen
	 */
	void createUser(String firstName, String lastName, String nickName, String gMail, Timestamp timestamp ) throws IllegalArgumentException;
	
	/**
	 * Methode um einen User zu Bearbeiten
	 */
	public void editUser(User u);
	/**
	 * Methode um einen User zu Loeschen
	 */
	public void deleteUser();
	
	/**
	 * Methode zur Ueberpruefung der Zugangsberechtigung 
	 */
	public User loginCheck(String nickname, String password);
	
	/**
	 * Methode um einen User anhand seiner ID zu suchen
	 */
	public User searchUserById(int userId);
	
	/**
	 * Methode um einen User upzudaten
	 */
	public User updateUser(User u);
	
	/**
	 * Methode um einen User anhand seines Nicknamens zu suchen
	 */
	public User searchUserByNickname(String nickname);
	
	/**
	 * Methode um einen Beitrag zu erzeugen
	 */
	public void createBeitrag(String inhalt);
	
	/**
	 * Methode um alle Beiträge eines Users auszugeben
	 */
	public ArrayList<Beitrag> findAllBeitraegeOfUser(User u);
	
	/**
	 * Methode um einen Beitrag zu Loeschen
	 */
	public void deleteBeitrag(Beitrag b);
	
	/**
	 * Methode um einen Beitrag zu Bearbeiten
	 */
	public Beitrag editBeitrag(Beitrag b);
	
	/**
	 * Methode um alle Abonnements eines Users anzuzeigen
	 */
	public ArrayList<Abonnement> showAllAbonnementsByUser(User u);
	
	/**
	 * Methode um ein neues Abonnement zu erzeugen
	 */
	public void createAbonnement(User u1, User u2);
	
	/**
	 * Methode um ein bestehendes Abonnement zu Loeschen
	 */
	public void deleteAbonnement(Abonnement a);
	
	/**
	 * Methode um einen neues Kommentar zu erzeugen
	 */
	public void createKommentar(String inhalt);
	
	/**
	 * Methode zum Loeschen eines Kommentars
	 */
	public void deleteKommentar(Kommentar k);
	
	/**
	 * Methode zum anzeigen aller Kommentare
	 */
	public ArrayList<Kommentar> findAllKommentare(Beitrag b);
	
	/**
	 * Methode zum Bearbeiten eines Kommentars
	 */
	public Kommentar editKommentar(Kommentar k);
	
	/**
	 * Methode zum erzeugen eines Likes
	 */
	public void createLike(Like l, Beitrag b);
	
	/**
	 * Methode zur Ueberpruefung ob der Beitrag bereits geliket ist
	 */
	public boolean likeCheck(User u, Beitrag b);
	
	/**
	 * Methode um einen Beitrag zu entliken
	 */
	public void deleteLike(Like l);
	
	/**
	 * Methode um ein Like zu suchen
	 */
	public Like searchLike(Like l);
	
	/**
	 * Methode um alle Likes eines Beitrags zu zaehlen
	 */
	public int countLikes(Beitrag b);
	
	/**
	 * Methode um Likes eines Beitrags zu entfernen
	 */
	public void deleteLikesOfBeitrag(Beitrag b);
}


