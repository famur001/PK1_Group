package Vorlesungsaufgaben.Aufgabe36;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AngestellterBean {
	private StringProperty name;
	private double monatsgehalt;

	public AngestellterBean(String name, double monatsgehalt) {
		this.name = new SimpleStringProperty(name);
		this.monatsgehalt = monatsgehalt;
	}
	
	public StringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public void setMonatsgehalt(double monatsgehalt) {
		this.monatsgehalt = monatsgehalt;
	}

	public String getName() {
		return this.name.get();
	}

	public double getMonatsgehalt() {
		return monatsgehalt;
	}
}
