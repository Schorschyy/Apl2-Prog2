package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;


public class CommandFuhrwerkKaufen implements Command {

	@Override
	public String menuItemName() {
		
		return "Fuhrwerke kaufen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		System.out.println("========== "+menuItemName());
		System.out.println("Wieviele Fuhrwerke kaufen?");
		System.out.printf("Anzahl Fuhrwerke: %s\n", context.getFuhrpark().getAnzahlFuhrwerke());
		System.out.printf("Guthaben: %s\n", context.getGuthaben());
		System.out.printf("Preis: %s\n", context.getFuhrpark().getPreisFuhrwerk());
		
		int zukaufendeFuhrwerke =0;
		Scanner myScanner = new Scanner(System.in);
		boolean scannerErfolg = false;
		while(!scannerErfolg) {
			try {
				System.out.print("Anzahl:");
				zukaufendeFuhrwerke = myScanner.nextInt();
				if(zukaufendeFuhrwerke * context.getFuhrpark().getPreisFuhrwerk() <= context.getGuthaben()) {
					scannerErfolg=true;
				}
				myScanner.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scannerErfolg=false;
				myScanner.nextLine();
			}
		}
	
		
		int neueAnzFuhrpark = context.getFuhrpark().getAnzahlFuhrwerke() + zukaufendeFuhrwerke;
		context.getFuhrpark().setAnzahlFuhrwerke(neueAnzFuhrpark);
		context.guthabenMinus(zukaufendeFuhrwerke * context.getFuhrpark().getPreisFuhrwerk());
		System.out.printf("Neue Anzahl Fuhrwerke: %s\n", context.getFuhrpark().getAnzahlFuhrwerke());
	}

}
