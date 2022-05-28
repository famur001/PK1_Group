package Vorlesungsaufgaben.Aufgabe36;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Eingabefeld {
	private StringProperty text; // Eingabefeld

	public Eingabefeld(String text) {
		super();
		this.text = new SimpleStringProperty(text);
	}

	public StringProperty textProperty() {
		return text;
	}

	public void setText(String text) {
		this.text.set(text);
	}

	public String getText() {
		return text.get();
	}
}