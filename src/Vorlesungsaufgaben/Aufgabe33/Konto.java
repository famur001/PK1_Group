package Vorlesungsaufgaben.Aufgabe33;

import java.io.Serializable;

public class Konto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7132927542940401873L;
	
	private double guthaben;
	
	public Konto(double guthaben) {
		this.guthaben = guthaben;
	}
	
	public double getGuthaben() {
		return guthaben;
	}

}
