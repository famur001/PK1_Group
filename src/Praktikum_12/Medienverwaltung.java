package Praktikum_12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import pk1.mv.datehaltung.Dao;
import pk1.mv.datehaltung.PersistenzException;

public class Medienverwaltung {
	
	private ArrayList<Medium> medien;
	private Dao dao = new Dao();
	
	public Medienverwaltung() {
		this.medien = new ArrayList<Medium>();
	}
	
	public ArrayList<Medium> getMedienListe() {
		return medien;
	}
	
	// Serialisierung
	public void speichern() {
		try {
			this.dao.speichern(medien);
		} catch (PersistenzException exp) {
			exp.printStackTrace();
		}
	}
	
	// Deserialisierung
	public void laden() {
		try {
			this.medien = (ArrayList<Medium>) this.dao.laden();
		} catch (PersistenzException exp) {
			exp.printStackTrace();
		}
	}
	
	public void aufnehmen(Medium m) {
		medien.add(m);
	}
	
	public void zeigeMedien(OutputStream stream) {
		Collections.sort(medien);
		medien.forEach( m -> m.druckeDaten(stream) );
	}
	
	public Medium sucheNeuesMedium() {
		
		return medien.stream().min( (a,b) -> Integer.compare(a.alter(), b.alter()) ).orElse(null);
		
		/*
		 * 
		if(medien.isEmpty())
			return null;
		
		int alter = medien.get(0).alter();
		int pos = 0;
		for(int i = 1; i < medien.size(); i++) {
			if(medien.get(i).alter() < alter) {
				alter = medien.get(i).alter();
				pos = i;
			}
		}
		return medien.get(pos);*/
		
	}
	
	public double berechneErscheinungsjahr() {
		
		if( !medien.isEmpty() ) {
			double durchschnitt = 0.0;
			durchschnitt += medien.stream().map(o -> o.getJahr()).reduce(0, (a,b)->a+b);
			
			/*for( Medium a: medien ) {
				durchschnitt += a.getJahr();
			}*/
			durchschnitt /= medien.size();
			
			return durchschnitt;
		}
		return 0.0;
	}
	
	public Iterator<Medium> iterator() {
		return medien.iterator();
	}
	
	public void medienInDateiSchreiben(String dateiname) {
		boolean ok = false;
		File file = null;
		do {
			try {
				if(dateiname == null) {
					return;
				}
				if(dateiname.isEmpty()) {
					throw new EmptyFileException();
				}
				file = new File(dateiname+".txt");
			} catch( EmptyFileException exp ) {
				int auswahl = JOptionPane.showConfirmDialog(null,"Dateiname ist leer! Neuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
				if( auswahl == JOptionPane.NO_OPTION ) {
					return;
				} else { // Yes
					ok = false;
				}
			}
			if(file != null) {
				try (OutputStream os = new FileOutputStream(file);
						PrintStream ps = new PrintStream(os)) {
					zeigeMedien(ps);
					ok = true;
				} catch(IOException exp) {
					exp.printStackTrace();
				}
				
			}
		} while(!ok);
	}
	
}
