package demo009;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.menu.Menu;
import demo009.menu.Submenu;
import demo009.menu.impl.CommandAnfordern;
import demo009.menu.impl.CommandEinstellen;
import demo009.menu.impl.CommandEntlassen;
import demo009.menu.impl.CommandFuhrwerkKaufen;
import demo009.menu.impl.CommandFuhrwerkVerkaufen;
import demo009.menu.impl.CommandLoehneFestlegen;
import demo009.menu.impl.CommandPrintNiederlassungen;
import demo009.menu.impl.CommandSpeichern;
import demo009.menu.impl.CommandVerkaufen;
import demo009.menu.impl.CommandWertanlageKaufen;
import demo009.menu.impl.CommmandWertanlagenAnzeigen;
import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;
import demo009.model.Wertanlage; 
import demo009.misc.DisplayService;

import java.util.ArrayList;
import java.util.List;

public class BusinessSimulation {

	// ApplicationContext enthaelt alle Objekte, die f�r den Spielstand des
	// aktuellen Spiels relevant sind. Auch technische Aspekte des Spiels
	// koennen darin enthalten sein.
	ApplicationContext appContext;
	
	Menu mainMenu;
	
	public BusinessSimulation() {
		this.appContext = new ApplicationContext();
	}
	
	public void play() {

		initStartzustand();
		
		mainMenu = initMainMenu();
		
		int runde=1;
		while(true) {
			System.out.println("=====================================");
			System.out.println("========== Runde "+runde+" ==========");
		
			DisplayService.anzeigenNiederlassung(appContext);
			DisplayService.anzeigenLager(appContext);
			DisplayService.anzeigenGuthaben(appContext);
			Wertanlage.insertWertanlagen();
					
			// TODO Aktuellen Bestand im Lager ausgeben
			// TODO aktuelle Liste der Niederlassungen ausgeben
			// TODO Guthaben ausgeben
			
			// mit Hilfe des Menus kann der Spieler seine Ressourcen verwalten
			mainMenu.showMenu();
			
			// Produktion durchfuehren
			// produzierte Menge vor dem n�chsten Rundenbeginn bei allen Niederlassungen abholen und einlagern
			int produzierteMenge;
			Warenart produzierteWarenart;
			System.out.println("========== Produzierte Mengen");
			for (Niederlassung niederlassung : appContext.getNiederlassungen()) { 
				niederlassung.produzieren();
				produzierteMenge=niederlassung.abholen();
				produzierteWarenart=niederlassung.getWarenart();
				appContext.getLager().einlagern(produzierteWarenart, produzierteMenge);
				System.out.printf("Ort: %10s Ware: %10s produzierte Menge: %d\n",
						niederlassung.getOrt(),niederlassung.getWarenartString(),produzierteMenge);
			}
			
			appContext.lohnZahlung();
			// aufraeumen am Ende der Runde
			appContext.geplanteTransporteZuruecksetzen();
			runde++;
		}
	}
	
	private void initStartzustand() {
		// Niederlassungen als Startkapital anlegen
		appContext.addNiederlassung(new Niederlassung("Einbeck", Warenart.BIER, 1,1));
		appContext.addNiederlassung(new Niederlassung("Hamburg", Warenart.BIER, 1,1));
		
		// es gibt ein zentrales Lager in Augsburg
		appContext.setLager(new Lager("Augsburg"));
		
		// Fuhrpark ist anfangs mit einem Fuhrwerk bestueckt und Preis pro
		// Fuhrwerk ist 20 Taler
		appContext.setFuhrpark(new Fuhrpark(1, 20));
		
		
	}
	
	private Menu initMainMenu() {
		
		// Untermenu f�r die Verwaltung der Niederlassungen und Transporte
		
		Submenu subNiederlassung = new Submenu("Niederlassungen, Anforderungen verwalten", appContext, "Zur�ck");
		subNiederlassung.setCommand(new CommandAnfordern());
		subNiederlassung.setCommand(new CommandEinstellen());
		subNiederlassung.setCommand(new CommandEntlassen());
		subNiederlassung.setCommand(new CommandLoehneFestlegen());
		
		
		// Untermenu f�r die Verwaltung der Fuhrwerke
		
		Submenu subFuhrpark = new Submenu("Fuhrpark verwalten", appContext, "Zur�ck");
		subFuhrpark.setCommand(new CommandFuhrwerkKaufen());
		subFuhrpark.setCommand(new CommandFuhrwerkVerkaufen());
		// TODO CommandFuhrwerkeReparieren
		
		Submenu subWertanlagen = new Submenu("Wertanlagen verwalten", appContext, "Zurück");
		subWertanlagen.setCommand(new CommandWertanlageKaufen());
		subWertanlagen.setCommand(new CommmandWertanlagenAnzeigen());
		
		// Hauptmenu
		
		Menu mainMenu = new Menu("Hauptmenu", appContext, "Runde beenden");
		mainMenu.setCommand(new CommandVerkaufen());
		mainMenu.setCommand(subNiederlassung);
		mainMenu.setCommand(subFuhrpark);
		mainMenu.setCommand(subWertanlagen);
		mainMenu.setCommand(new CommandPrintNiederlassungen());
		mainMenu.setCommand(new CommandSpeichern());
		
		
		return mainMenu;
	}


}