package Vorlesungsaufgaben.Aufgabe38;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXEvents_InnerClass extends Application {

	class InnerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			System.out.println("Hallo FX");
		}
	}
	
	public void start(Stage primaryStage) {
		
		Button btn = new Button("Sag 'Hallo FX'");
		
		InnerClass ic = new InnerClass();
		
		btn.setOnAction(ic);
		
		BorderPane root = new BorderPane();
		root.setCenter(btn);
		Scene scene = new Scene(root, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
