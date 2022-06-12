package Vorlesungsaufgaben.Aufgabe38;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AnotherClass implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Hallo FX!");
	}

}
