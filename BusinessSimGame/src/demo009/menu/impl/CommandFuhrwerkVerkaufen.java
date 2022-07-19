package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;


public class CommandFuhrwerkVerkaufen implements Command {

	@Override
	public String menuItemName() {
		
		return "Fuhrwerke verkaufen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		System.out.println("========== "+menuItemName());
		System.out.println("Wieviele Fuhrwerke verkaufen?");
		System.out.printf("Anzahl Fuhrwerke: %s\n", context.getFuhrpark().getAnzahlFuhrwerke());
		System.out.printf("Guthaben: %s\n", context.getGuthaben());
		System.out.printf("Preis: %s\n", context.getFuhrpark().getPreisFuhrwerk());
		
		int zuVerkaufendeFuhrwerke =0;
		Scanner myScanner = new Scanner(System.in);
		boolean scannerErfolg = false;
		while(!scannerErfolg) {
			try {
				System.out.print("Anzahl:");
				zuVerkaufendeFuhrwerke = myScanner.nextInt();
				if(zuVerkaufendeFuhrwerke <= context.getFuhrpark().getAnzahlFuhrwerke()) {
					scannerErfolg=true;
				}
				myScanner.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scannerErfolg=false;
				myScanner.nextLine();
			}
		}
	
		
		int neueAnzFuhrpark = context.getFuhrpark().getAnzahlFuhrwerke() - zuVerkaufendeFuhrwerke;
		context.getFuhrpark().setAnzahlFuhrwerke(neueAnzFuhrpark);
		context.guthabenPlus(zuVerkaufendeFuhrwerke * context.getFuhrpark().getPreisFuhrwerk());
		System.out.printf("Neue Anzahl Fuhrwerke: %s\n", context.getFuhrpark().getAnzahlFuhrwerke());
	}

}
