package Vorlesungsaufgaben.Aufgabe33;

import java.io.Serializable;

public class Kunde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -65564684516L;
	
	private String nachname;
	private Konto einKonto;
	
	public Kunde(String nachname, Konto konto) {
		this.nachname = nachname;
		this.einKonto = konto;
	}
	
	public void druckeDaten() {
		System.out.println(nachname + ", " + einKonto.getGuthaben());
	}
	
}
