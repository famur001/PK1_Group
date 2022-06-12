package Vorlesungsaufgaben.Aufgabe38;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXEvents_Selbst extends Application implements EventHandler<ActionEvent> {

	public void start(Stage primaryStage) {
		
		Button btn = new Button("Sag 'Hallo FX'");
		
		btn.setOnAction(this);
		
		BorderPane root = new BorderPane();
		root.setCenter(btn);
		Scene scene = new Scene(root, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Hallo FX");
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
