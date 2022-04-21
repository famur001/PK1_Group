package Vorlesungsaufgaben;

import javax.swing.JOptionPane;

public class Aufgabe20 {

	public static void main(String[] args) {
		
		int eingabe = JOptionPane.showConfirmDialog(null, "dhdhd");
		
		System.out.println(eingabe);
		//int zahl = Integer.parseInt(eingabe);
		//JOptionPane.showMessageDialog(null, zahl);
		
		for(int i = 0; i < 8; i++) {
			System.out.printf("2 hoch %4d ist %.0f%n", i, Math.pow(2, i));
		}

	}

}
