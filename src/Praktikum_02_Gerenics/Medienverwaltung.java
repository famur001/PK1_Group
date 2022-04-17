package Praktikum_02_Gerenics;

import java.util.ArrayList;
import java.util.Iterator;

public class Medienverwaltung {
	
	private ArrayList<Medium> medien;
	
	public Medienverwaltung() {
		this.medien = new ArrayList<Medium>();
	}
	
	public void aufnehmen(Medium m) {
		medien.add(m);
	}
	
	public void zeigeMedien() {
		Iterator<Medium> it = medien.iterator();
		while( it.hasNext() ) {
			it.next().druckeDaten();
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
		medien.get(pos).druckeDaten();
		
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
