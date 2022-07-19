package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Wertanlage;

public class CommandWertanlageKaufen implements Command {
	
	
	@Override
	public String menuItemName() {
		return "Wertanlage kaufen" ;
	}

	@Override
	public void execute(ApplicationContext context) {
	
	System.out.println("Welche Wertanlage kaufen?");
	Wertanlage.printWertanlagen();
	
	int auswahlanlage = 0;
	

	
	Scanner myScanner = new Scanner(System.in);
	boolean scannerErfolg = false;
	while(!scannerErfolg) {
		try {
			System.out.print("Auswahl:");
			auswahlanlage = myScanner.nextInt();
			scannerErfolg=true;
			myScanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			scannerErfolg=false;
			myScanner.nextLine();
		}

	
	}
	
	if(auswahlanlage ==	Wertanlage.counter) {
		return;
	}
	
	int anzahl = 0;
	scannerErfolg = false;
	while(!scannerErfolg) {
		try {
			System.out.print("Wie oft Wertanlage beschaffen?");
			anzahl = myScanner.nextInt();
			if(context.getGuthaben() >= (anzahl * Wertanlage.getPreisWertanlage(auswahlanlage))){
			scannerErfolg=true;
			}
			myScanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			scannerErfolg=false;
			myScanner.nextLine();
		}
		
	}

	if(auswahlanlage == 0) {
		Wertanlage.setAnzahlBTC(anzahl);
	}
	
	if(auswahlanlage == 1) {
		Wertanlage.setAnzahlGold(anzahl);
	}
	
	if(auswahlanlage == 2) {
		Wertanlage.setAnzahlOil(anzahl);
	}
	
	if(auswahlanlage == 3) {
		Wertanlage.setAnzahlWeed(anzahl);
	}
	
	context.guthabenMinus(anzahl * Wertanlage.getPreisWertanlage(auswahlanlage));
	
}
}