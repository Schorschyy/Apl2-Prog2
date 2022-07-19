package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Wertanlage;

public class CommmandWertanlagenAnzeigen implements Command {

	@Override
	public String menuItemName() {
		return "Wertanlagen Anzeigen";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		System.out.println("Anzahl BTC: 	"+Wertanlage.getAnzahlBTC());
		System.out.println("Anzahl Gold:	"+Wertanlage.getAnzahlGold());
		System.out.println("Anzahl Oil:		"+Wertanlage.getAnzahlOil());
		System.out.println("Anzahl Weed:	"+Wertanlage.getAnzahlWeed());
	}

}
