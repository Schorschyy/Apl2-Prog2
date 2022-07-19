package demo009.model;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import demo009.ApplicationContext;
import demo009.misc.Util;

public class Fuhrpark {

	private int anzahlFuhrwerke;
	
	private int preisFuhrwerk;
	
	public Fuhrpark(int anzahlFuhrwerke, int preisFuhrwerk) {
		this.anzahlFuhrwerke=anzahlFuhrwerke;
		this.preisFuhrwerk=preisFuhrwerk;
	}

	public int getAnzahlFuhrwerke() {
		return anzahlFuhrwerke;
	}

	public void setAnzahlFuhrwerke(int anzahlFuhrwerke) {
		this.anzahlFuhrwerke = anzahlFuhrwerke;
	}
	
	public int getPreisFuhrwerk() {
		return preisFuhrwerk;
	}

	public void setPreisFuhrwerk(int preisFuhrwerk) {
		this.preisFuhrwerk = preisFuhrwerk;
	}
	
	public void fuhrparkSpeichern(ApplicationContext context) {
		File fuhrparkDaten = new File(context.getDateipfad()+"Fuhrpark.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(fuhrparkDaten);
			fw.write(this.anzahlFuhrwerke + ";" + this.preisFuhrwerk);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}