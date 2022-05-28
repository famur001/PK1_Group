package Vorlesungsaufgaben.Aufgabe36;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;

public class Vorlesung7 {
	
	public static void main(String[] args) {
		
		SimpleIntegerProperty sip = new SimpleIntegerProperty();
		sip.set(100);
		
		sip.addListener(new InvalidationListener() {
			public void invalidated(Observable o) {
				SimpleIntegerProperty sp = (SimpleIntegerProperty) o;
				System.out.println("Neuer Wert");
			}
		});
		
		sip.set(150);
		sip.set(110);
		sip.set(50);
		
	}

}
