package demo009.model;

import java.util.*;

import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import demo009.ApplicationContext;
import demo009.misc.Util;


public class Wertanlage {

	
	
	public static int anzahlGold = 0;
	public static int anzahlWeed= 0;
	public static int anzahlOil = 0;
	public static int anzahlBTC = 0;
	
	public static HashMap<String,Integer> wertanlagen = new HashMap<>();
	
	public static void insertWertanlagen() {
		wertanlagen.put("Gold",100);
		wertanlagen.put("Weed",10);
		wertanlagen.put("Oil",30);
		wertanlagen.put("BTC",70);
	}
	
	
	public static int counter = 0;
	
	public static int getAnzahlGold() {
		return anzahlGold;
	}
	public static int getAnzahlWeed() {
		return anzahlWeed;
	}
	public static int getAnzahlOil() {
		return anzahlOil;
	}
	public static int getAnzahlBTC() {
		return anzahlBTC;
	}
	public static void setAnzahlGold(int neueAnlage) {
		anzahlGold = anzahlGold + neueAnlage;
	}
	
	public static void setAnzahlWeed(int neueAnlage) {
		anzahlWeed = anzahlWeed + neueAnlage;
	}
	
	public static void setAnzahlOil(int neueAnlage) {
		anzahlOil = anzahlOil + neueAnlage;
	}
	
	public static void setAnzahlBTC(int neueAnlage) {
		anzahlBTC = anzahlBTC + neueAnlage;
	}
	
	
	
	public static void printWertanlagen() {
		System.out.println(" Wertanlage:		Wert:");
		
		int count = 0;
		for (String key: wertanlagen.keySet()) {  
			System.out.println(count+": "+key+ "			" + wertanlagen.get(key));
			count++;
		}
		System.out.println(count+": Zurück");
		counter = count;
	
		
	}
	
	
	public static int getPreisWertanlage(int position) {
		
		Collection<Integer> preis = wertanlagen.values();
		ArrayList<Integer> listOfPrices = new ArrayList<>(preis);
		
		int preisAnlage = listOfPrices.get(position);
		return preisAnlage;
	}
	
	public static String getWertanlage(int position) {
		
		Collection<String> wertanlage = wertanlagen.keySet();
		ArrayList<String> listOfWertanlagen = new ArrayList<String>(wertanlage);
		
		String artWertanlage = listOfWertanlagen.get(position);
		return artWertanlage;
	}
	
	
	public static int getcounter() {
		return counter;
	}
	public static void printListNiederlassung(ApplicationContext context) {
		List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
		
		for(int i = 0; i < listeNiederlassung.size(); i++) {
			System.out.println(listeNiederlassung.get(i));
			
		}
	}

}


