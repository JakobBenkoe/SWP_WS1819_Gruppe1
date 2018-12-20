/**
 * 
 */
package de.hdm.softwarePraktikumGruppe1.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.softwarePraktikumGruppe1.shared.bo.Abonnement;
import de.hdm.softwarePraktikumGruppe1.shared.bo.Pinnwand;
import de.hdm.softwarePraktikumGruppe1.shared.bo.User;

/**
 * @author GianlucaBerner
 * @author Yesin Soufi
 * 
 */
public class AbonnementMapper {
	
	private static AbonnementMapper abonnementMapper;
	
	/**
	 * Ein gesch�tzter Konstruktor der weitere Instanzierungen von AbonnementMapper Objekten verhindert.
	 */
	protected AbonnementMapper() {
	}
	
	/**
	 * Stellt die Singeleton-Eigenschaft der Mapperklasse sicher
	 * @return Sie gibt den AbonnementMapper zur�ck.
	 */
	
	public static AbonnementMapper abonnementMapper() {
		if (abonnementMapper == null) {
			abonnementMapper = new AbonnementMapper();
		} 
		
		return abonnementMapper;
	}
	
public Abonnement findById(int AbonnementID) {
		
		Connection con = DBConnection.connection();
		
		
	try {
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery ("SELECT Abonnement_ID,  FROM Abonnement " + "WHERE Abonnement_id=" + AbonnementID + " ORDER BY Abonnement_ID");
	
		if(rs.next()) {
			Abonnement a = new Abonnement();
			a.setOwnerId(rs.getInt("AbonnementID"));
			
			
			return a;
		
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
			}
	return null;
		}
		
		public Vector<Abonnement> findAll(Vector<Abonnement> result){
			Connection con = DBConnection.connection();
			
			try {
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT AbonnementID" + "FROM Abonnement" + "ORDED BY AbonnementID");
				
				while(rs.next()) {
					Abonnement a = new Abonnement();
					a.setOwnerId(rs.getInt("AbonnementID"));
					
					
					result.addElement(a);
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				return result;
					
				}
			
			public Abonnement insert(Abonnement a) {
				Connection con = DBConnection.connection();

				try {
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("SELECT MAX(AbonnementID) AS maxid " + "FROM User ");

					if (rs.next()) {
						
						a.setOwnerId(rs.getInt("maxid") + 1);

						stmt = con.createStatement();
						
						stmt.executeUpdate("INSERT INTO user (AbonnementID, Pinnwand_PinnwandID, User_UserID) " + "VALUES (" + 
								"'" + a.getOwnerId() + "'," + 
								"'" + a.getPinnwand_PinnwandID() + "'," + 
								"'" + a.getUser_UserID() + "'");
						
								
					
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return a;
				
			}
			
			public Abonnement update(Abonnement a) {
				Connection con = DBConnection.connection();

				try {
					Statement stmt = con.createStatement();

					stmt.executeUpdate("UPDATE User " + "SET AbonnementID=\"" + a.getOwnerId()  + "WHERE id=" + a.getOwnerId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				
				return a; 
			}
			
			public void delete(Abonnement a) {
				Connection con = DBConnection.connection();

				try {
					Statement stmt = con.createStatement();

					stmt.executeUpdate("DELETE FROM Abonnement " + "WHERE AbonnementID=" + a.getOwnerId());
				} catch (SQLException e) {
					e.printStackTrace();
					} 
				}
			
			public Vector<Abonnement> getAllAbonnementByUser(User u){
				
				Connection con= DBConnection.connection();
				Vector <Abonnement> result = new Vector <Abonnement>();
				
			try {
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT (AbonnementID, Pinnwand_PinnwandID, User_UserID) FROM abonnement" + "WHERE User_UserID" + u.getUserId(u));
						
						while(rs.next()) {
							
							Abonnement a = new Abonnement();
							
							a.setOwnerId(rs.getInt("AbonnementID"));
							a.setPinnwand_PinnwandID(rs.getInt("Pinnwand_PinnwandID"));
							a.setUser_UserID(rs.getInt("User_UserID"));
							result.addElement(a);
						}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
			
				
			
			}
			
			public Vector<Abonnement> getAllAbonnementsByPinnwand(Pinnwand p){
				
				Connection con= DBConnection.connection();
				Vector <Abonnement> result = new Vector <Abonnement>();
				
			try {
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT (PinnwandID, Pinnwand_PinnwandID, User_UserID) FROM pinnwand" + "WHERE Pinnwand_PinnwandID" + p.getOwnerId());
						
						while(rs.next()) {
							
							Abonnement a = new Abonnement();
							
							a.setOwnerId(rs.getInt("PinnwandID"));
							a.setPinnwand_PinnwandID(rs.getInt("Pinnwand_PinnwandID"));
							a.setUser_UserID(rs.getInt("User_UserID"));
							result.addElement(a);
						}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
			
}		
				
}