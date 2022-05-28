package Vorlesungsaufgaben.Aufgabe36;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Aufgabe36a {

	public static void main(String[] args) {
		
		// Aufgabe 36a
		AngestellterBean angestellter = new AngestellterBean("Ahmad", 5000);
		Eingabefeld eingabe = new Eingabefeld(angestellter.getName());
		
		/*eingabe.textProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed( ObservableValue o, String oldValue, String newValue ) {
				//System.out.println(oldValue + " - " + newValue);
				angestellter.setName(newValue);
			}
			
		});*/
		
		// Mit InvalidationListener
		eingabe.textProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable ob) {
				SimpleStringProperty ssp = (SimpleStringProperty) ob;
				angestellter.setName(ssp.get());
			}
		});
		
		/*System.out.println(angestellter.getName());
		eingabe.setText("NeuerName1");
		System.out.println(angestellter.getName());*/
		
		
		// Aufgabe 36b
		StringProperty nameAngestellter = angestellter.nameProperty();
		StringProperty textEinagbe = eingabe.textProperty();
		
		textEinagbe.bind(nameAngestellter);

		System.out.println("Vorher: " + eingabe.getText());
		angestellter.setName("NEuerNAmeeee01");
		System.out.println("Nachher: " + eingabe.getText());

	}

}
