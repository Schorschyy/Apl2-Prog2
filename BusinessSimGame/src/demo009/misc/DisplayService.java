package demo009.misc;

import demo009.ApplicationContext;
import demo009.menu.Menu;
import demo009.menu.Submenu;
import demo009.menu.impl.CommandAnfordern;
import demo009.menu.impl.CommandEinstellen;
import demo009.menu.impl.CommandLoehneFestlegen;
import demo009.menu.impl.CommandPrintNiederlassungen;
import demo009.menu.impl.CommandVerkaufen;
import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;
import demo009.misc.DisplayService;

import java.util.ArrayList;
import java.util.List;


public class DisplayService {

	
	
//public static void anzeigenNiederlassung(String ort, String warenart, String status_angefordert, int anzfuhrwerke, int anzArbeiter) {
//	System.out.printf("%s \t%s \t\t %s \t\t\t %d \t\t\t %d \n", ort, warenart, status_angefordert, anzfuhrwerke, anzArbeiter);
//	System.out.printf("%s \t%s \t\t %s \t\t\t %d \t\t\t %d \n");
 
	public static void anzeigenNiederlassung(ApplicationContext context) {
		System.out.println("========== Niederlassungen");
		System.out.printf("%s \t\t%s \t %s \t %s\t %s \n", "Ort", "warenart", "status angefordert","anz ges Fuhrwerke", "anz Arbeiter");
		
		for (Niederlassung n : context.getNiederlassungen()) { 
		System.out.printf("%s \t%s \t\t %s \t\t\t %s \t\t\t %s \n",n.getOrt(),n.getWarenartString(),Boolean.toString(n.wurdeAngefordert()), n.getgesendeteFuhrwerke(),n.getAnzahlArbeitende());
	}
}

	public static void anzeigenLager(ApplicationContext context) {
		Util u = new Util();
		System.out.println("==========Lager");
		for(Warenart w : context.getLager().getEingelagerteWaren()) {
			System.out.println(u.convertWarenartToString(w)+":\t"+context.getLager().getBestand(w));
		}
	
	}
	
	public static void anzeigenGuthaben(ApplicationContext context) {
		System.out.printf("==========Finanzen \n Guthaben in Taler: %s \n==========\n",context.getGuthaben());
	}
}