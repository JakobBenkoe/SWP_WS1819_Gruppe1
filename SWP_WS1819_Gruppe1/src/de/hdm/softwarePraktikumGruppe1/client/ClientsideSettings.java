package de.hdm.softwarePraktikumGruppe1.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.softwarePraktikumGruppe1.shared.CommonSettings;
import de.hdm.softwarePraktikumGruppe1.shared.LoginService;
import de.hdm.softwarePraktikumGruppe1.shared.LoginServiceAsync;
import de.hdm.softwarePraktikumGruppe1.shared.Pinnwandverwaltung;
import de.hdm.softwarePraktikumGruppe1.shared.PinnwandverwaltungAsync;
import de.hdm.softwarePraktikumGruppe1.shared.ReportGeneratorAsync;

/**
 * Klasse mit Eigenschaften und Diensten, die für alle Client-seitigen Klassen
 * relevant sind.
 * 
 * @author AdamGniady
 * @version 1.0 
 */
public class ClientsideSettings extends CommonSettings {

  /**
   * Remote Service Proxy zur Verbindungsaufnahme mit dem Server-seitgen Dienst
   * <code>Pinnwandverwaltung</code>.
   */

  private static PinnwandverwaltungAsync pinnwandverwaltung = null;

  /**
   * Remote Service Proxy zur Verbindungsaufnahme mit dem Server-seitgen Dienst
   * namens <code>ReportGenerator</code>.
   */
  private static ReportGeneratorAsync reportGenerator = null;
  
  /**
	 * Remote Service Proxy zur Verbindungsaufnahme mit den serverseitigen Dienst
	 * LoginService
	 */
  private static LoginServiceAsync loginService = null;

  /**
   * Name des Client-seitigen Loggers.
   */
  private static final String LOGGER_NAME = "Social Media Pinnwand Web Client";
  
  /**
   * Instanz des Client-seitigen Loggers.
   */
  private static final Logger log = Logger.getLogger(LOGGER_NAME);

  /**
	* Auslesen des applikationsweiten client-seitig zentralen Loggers
	* 
	* @return Logger-Instanz
	*/
  public static Logger getLogger() {
    return log;
  }

  /**
   * Anlegen und Auslesen der Pinnwandverwaltung
   */
  public static PinnwandverwaltungAsync getPinnwandverwaltung() {
    // Gab es bislang noch keine Pinnwandverwaltungs-Instanz, dann...
    if (pinnwandverwaltung == null) {
      // Zunächst instantiieren wir Pinnwandverwaltung
      pinnwandverwaltung = GWT.create(Pinnwandverwaltung.class);
    }

    // So, nun brauchen wir die Pinnwandverwaltung nur noch zurückzugeben.
    return pinnwandverwaltung;
  }
  
  /**
	 * Anlegen und Auslesen des Loginservice
	 */
	public static LoginServiceAsync getLoginService() {
		if (loginService == null) {
			loginService = GWT.create(LoginService.class);
		}
		return loginService;
	}

	/**
	 * Anlegen und Auslesen des ReportGenerators
	 */
	public static ReportGeneratorAsync getReportGenerator() {
	    // Gab es bislang noch keine ReportGenerator-Instanz, dann...
		if (reportGenerator == null) {
		  // Zunächst instantiieren wir ReportGenerator
		  reportGenerator = GWT.create(ReportGenerator.class);
		
		  final AsyncCallback<Void> initReportGeneratorCallback = new AsyncCallback<Void>() {
		    @Override
			public void onFailure(Throwable caught) {
		      ClientsideSettings.getLogger().severe(
		          "Der ReportGenerator konnte nicht initialisiert werden!");
		    }
		
		    @Override
			public void onSuccess(Void result) {
		      ClientsideSettings.getLogger().info(
		          "Der ReportGenerator wurde initialisiert.");
		    }
		  };
		  	
		  reportGenerator.init(initReportGeneratorCallback);
		}

		// So, nun brauchen wir den ReportGenerator nur noch zurückzugeben.
		    return reportGenerator;
		}
}
