package Praktikum_02_Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Medienverwaltung {
	
	private ArrayList medien;
	
	public Medienverwaltung() {
		this.medien = new ArrayList();
	}
	
	public void aufnehmen(Medium m) {
		medien.add(m);
	}
	
	public void zeigeMedien() {
		Iterator it = medien.iterator();
		while( it.hasNext() ) {
			Medium m = (Medium)it.next();
			m.druckeDaten();
		}
	}
	
	public void sucheNeuesMedium() {
		
		Medium m = (Medium)medien.get(0);
		int alter = m.alter();
		int pos = 0;
		for(int i = 1; i < medien.size(); i++) {
			Medium zw = (Medium)medien.get(i);
			if(zw.alter() < alter) {
				alter = zw.alter();
				pos = i;
			}
		}
		Medium erg = (Medium) medien.get(pos);
		erg.druckeDaten();
		
	}
	
	public double berechneErscheinungsjahr() {
		
		if( !medien.isEmpty() ) {
			double durchschnitt = 0.0;
			
			for( Object a: medien ) {
				Medium m = (Medium)a;
				durchschnitt += m.getJahr();
			}
			durchschnitt /= medien.size();
			
			return durchschnitt;
		}
		return 0.0;
	}
	
}
