package Praktikum_05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
		
		Medienverwaltung mv = new Medienverwaltung();
		
		Scanner sc = new Scanner(System.in);
		int eingabe = 0;
		do {
			System.out.println("Medienverwaltung\n");
			System.out.println("1. Audio aufnehmen");
			System.out.println("2. Bild aufnehmen");
			System.out.println("3. Zeige alle Medien");
			System.out.println("4. Medienliste in Datei schreiben");
			System.out.println("5. Zeige neues Medium");
			System.out.println("6. Berechne durchschnittliches Erscheinungsjahr");
			System.out.println("7. Beenden\n");
			
			boolean ok3 = false;
			do {
				try {
					System.out.println("Bitte Menüpunkt waehlen: ");
					eingabe = sc.nextInt();
					ok3 = true;
				} catch( InputMismatchException e ) {
					System.err.println("Ungültige Eingabe\n");
					sc.next();
				}
			} while(!ok3); // <=> ok3==false (Durchlaufen, solange ok3 den Wert false hat)
			
			switch(eingabe) {
			case 1: //String titel, int jahr, String interpret, int dauer
				String titel = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
				int jahrInt = 0;
				boolean ok = false;
				do {
					try {
						String jahr = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
						jahrInt = Integer.parseInt(jahr);
						ok = true;
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
						//ok = false;
					}
				}while(!ok);
				String interpret = JOptionPane.showInputDialog(null, "Geben Sie den Interpret ein");
				ok = false;
				int dauerInt = 0;
				do {
					try {
						String dauer = JOptionPane.showInputDialog(null, "Geben Sie die Dauer ein");
						dauerInt = Integer.parseInt(dauer);
						ok = true;
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben");
					}
				}while(!ok);
				Audio audio = new Audio(titel, jahrInt, interpret, dauerInt);
				mv.aufnehmen(audio);
				break;
			case 2: //String titel, int jahr, String ort
				String titel2 = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
				
				int jahrInt2 = 0;
				boolean ok2 = false;
				do {
					try {
						String jahr2 = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
						jahrInt2 = Integer.parseInt(jahr2);
						ok2 = true;
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
					}
				}while(!ok2);
				
				String ort = JOptionPane.showInputDialog(null, "Geben Sie den Ort ein");
				Bild bild = new Bild(titel2, jahrInt2, ort);
				mv.aufnehmen(bild);
				break;
			case 3:
				mv.zeigeMedien(System.out);
				break;
			case 4:
				medienInDateiSchreiben(mv);
				break;
			case 5:
				mv.sucheNeuesMedium();
				break;
			case 6:
				System.out.println( mv.berechneErscheinungsjahr() );
				break;
			case 7: System.out.println("Programm beendet!");
				break;
			default:
				System.out.println("Bitte eine Zahl zwischen 1-6 auswählen.");
			}
			
		} while(eingabe != 6);
	}
	
	public static void medienInDateiSchreiben(Medienverwaltung mv) {
		boolean ok = false;
		File file = null;
		do {
			
			try {
				String dateiname = JOptionPane.showInputDialog(null, "Bitte Dateiname eingeben");
				
				if(dateiname == null) { // Wenn Cancel gedrückt wird
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
					
					mv.zeigeMedien(ps);
					ok = true;
					
				} catch(IOException exp) {
					exp.printStackTrace();
				}
				
			}
		
		} while(!ok);
		
	}
	
}
