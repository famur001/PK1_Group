package Praktikum_03;

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
			System.out.println("4. Zeige neues Medium");
			System.out.println("5. Berechne durchschnittliches Erscheinungsjahr");
			System.out.println("6. Beenden\n");
			System.out.print("Bitte Menueüunkt waehlen: ");
			
			eingabe = sc.nextInt();
			
			switch(eingabe) {
			case 1: //String titel, int jahr, String interpret, int dauer
				String titel = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
				String jahr = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
				int jahrInt = Integer.parseInt(jahr);
				String interpret = JOptionPane.showInputDialog(null, "Geben Sie den Interpret ein");
				String dauer = JOptionPane.showInputDialog(null, "Geben Sie die Dauer ein");
				int dauerInt = Integer.parseInt(dauer);
				Audio audio = new Audio(titel, jahrInt, interpret, dauerInt);
				mv.aufnehmen(audio);
				break;
			case 2: //String titel, int jahr, String ort
				String titel2 = JOptionPane.showInputDialog(null, "Geben Sie den Titel ein");
				String jahr2 = JOptionPane.showInputDialog(null, "Geben Sie das Jahr ein");
				int jahrInt2 = Integer.parseInt(jahr2);
				String ort = JOptionPane.showInputDialog(null, "Geben Sie den Ort ein");
				Bild bild = new Bild(titel2, jahrInt2, ort);
				mv.aufnehmen(bild);
				break;
			case 3:
				mv.zeigeMedien();
				break;
			case 4:
				mv.sucheNeuesMedium();
				break;
			case 5:
				System.out.println( mv.berechneErscheinungsjahr() );
				break;
			case 6: System.out.println("Programm beendet!");
				break;
			default:
				System.out.println("Bitte eine Zahl zwischen 1-6 auswählen.");
			}
			
		} while(eingabe != 6);
	}
	
}
