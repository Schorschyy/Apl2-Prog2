package demo009.menu.impl;

import java.util.Scanner;
import java.util.List;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Niederlassung;

public class CommandEntlassen implements Command {

	@Override
	public String menuItemName() {
		return "Arbeitende entlassen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		
		int indexNdls = 0;
		int auswahlNiederlassungIndex=0;
		
		System.out.println("========== "+menuItemName());
		System.out.println("========== In Welcher Niederlassung sollen Arbeiter entlassen werden?");
		System.out.println("   Ort\t\tArbeiter\tLohn");
		
		List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
	
		for(Niederlassung n : listeNiederlassung) {
			System.out.printf("%s: %s \t%s\t\t%s\n",indexNdls, n.getOrt(), n.getAnzahlArbeitende(), n.getLohn());
		indexNdls++;
		}
	
		System.out.printf("%s: Zurück\n", indexNdls);
		
		Scanner myScanner = new Scanner(System.in);
		boolean scannerErfolg = false;
		while(!scannerErfolg) {
			try {
				System.out.print("Auswahl:");
				auswahlNiederlassungIndex = myScanner.nextInt();
				scannerErfolg=true;
				myScanner.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scannerErfolg=false;
				myScanner.nextLine();
			}
		}
		if(auswahlNiederlassungIndex == indexNdls) {
			return;
		}
		
		 scannerErfolg = false;
		 int entlasseneArbeiter = 0;
		 while(!scannerErfolg) {
				try {
					System.out.print("Wieviele Arbeiter entlassen?");
					entlasseneArbeiter = myScanner.nextInt();
					if(entlasseneArbeiter >= 0) {
					scannerErfolg = true;
					}
					myScanner.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
					scannerErfolg=false;
					myScanner.nextLine();
				}
			}
	
		 int aktuelleArbeiter = listeNiederlassung.get(auswahlNiederlassungIndex).getAnzahlArbeitende() - entlasseneArbeiter;
		 context.getNiederlassungen().get(auswahlNiederlassungIndex).setAnzahlArbeitende(aktuelleArbeiter);
	
	}

}