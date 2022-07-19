package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;

public class CommandSpeichern implements Command{

	@Override
	public String menuItemName() {
		return "Speichern";
	}

	@Override
	public void execute(ApplicationContext context) {
		context.getFuhrpark().fuhrparkSpeichern(context);
		context.guthabenSpeichern();
		context.getLager().lagerSpeichern(context);
		context.niederlassungenSpeichern();
		
	}

}
