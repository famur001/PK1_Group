package Praktikum_02_Array;

public class Medienverwaltung {
	
	private Medium[] medien;
	private int anzahlMedien;
	
	public Medienverwaltung(int anzahl) {
		this.medien = new Medium[anzahl];
		anzahlMedien = 0;
	}
	
	public void aufnehmen(Medium m) {
		if( anzahlMedien < medien.length ) {
			medien[anzahlMedien++] = m;
		} else {
			System.out.println("Die Medienliste ist full");
		}
	}
	
	public void zeigeMedien() {
		for(int i = 0; i < anzahlMedien; i++) {
			medien[i].druckeDaten();
		}
	}
	
	public void sucheNeuesMedium() {
		
		int alter = medien[0].alter();
		int pos = 0;
		for(int i = 1; i < anzahlMedien; i++) {
			if(medien[i].alter() < alter) {
				alter = medien[i].alter();
				pos = i;
			}
		}
		medien[pos].druckeDaten();
		
	}
	
	public double berechneErscheinungsjahr() {
		
		if( medien.length >  0) {
			double durchschnitt = 0.0;
			
			for( int i = 0; i < anzahlMedien; i++ ) {
				durchschnitt += medien[i].getJahr();
			}
			durchschnitt /= anzahlMedien;
			
			return durchschnitt;
		}
		return 0.0;
	}
	
}
