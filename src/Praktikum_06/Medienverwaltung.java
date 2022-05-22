package Praktikum_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Vorlesungsaufgaben.Aufgabe33.Kunde;

public class Medienverwaltung {
	
	private ArrayList<Medium> medien;
	
	private String pfad = "C:\\Users\\fathi\\OneDrive\\Desktop\\Neuer Ordner\\medienliste.txt";
	private File file = new File(pfad);
	
	public Medienverwaltung() {
		this.medien = new ArrayList<Medium>();
	}
	
	// Serialisierung
	public void speichern() {
		try ( FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(medien);
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
	// Deserialisierung
	public void laden() {
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			//medien = (ArrayList<Medium>) ois.readObject();
			ArrayList<Medium> liste = (ArrayList<Medium>) ois.readObject();
			medien.addAll(liste);
			Medium.idZaehler = liste.size();
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}  catch(ClassNotFoundException exp) {
			exp.printStackTrace();
		}
	}
	
	public void aufnehmen(Medium m) {
		medien.add(m);
	}
	
	public void zeigeMedien(OutputStream stream) {
		Collections.sort(medien);
		Iterator<Medium> it = medien.iterator();
		while( it.hasNext() ) {
			it.next().druckeDaten(stream);
			System.out.println();
		}
	}
	
	public void sucheNeuesMedium() {
		
		int alter = medien.get(0).alter();
		int pos = 0;
		for(int i = 1; i < medien.size(); i++) {
			if(medien.get(i).alter() < alter) {
				alter = medien.get(i).alter();
				pos = i;
			}
		}
		medien.get(pos).druckeDaten(System.out);
		
	}
	
	public double berechneErscheinungsjahr() {
		
		if( !medien.isEmpty() ) {
			double durchschnitt = 0.0;
			
			for( Medium a: medien ) {
				durchschnitt += a.getJahr();
			}
			durchschnitt /= medien.size();
			
			return durchschnitt;
		}
		return 0.0;
	}
	
}
