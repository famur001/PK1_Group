package Vorlesungsaufgaben.Aufgabe38GridPane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Aufgabe38 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10));
		
		Label label1 = new Label("Label 1");
		Label label2 = new Label("Label 2");
		TextField tf0 = new TextField("TextField 0");
		TextField tf1 = new TextField("TextField 1");
		TextField tf2 = new TextField("TextField 2");
		Button btn = new Button("Start");
		GridPane.setHalignment(btn, HPos.CENTER);
		ListView<String> list = new ListView<String>();
		
		for( int i = 0; i < 100; i++ ) {
			list.getItems().add("This is item " + i);
		}
		
		root.add(list, 0, 0, 1, 3);
		root.add(label1, 1, 0);
		root.add(label2, 1, 1);
		root.add(tf0, 2, 0);
		root.add(tf1, 2, 1);
		root.add(tf2, 2, 2);
		root.add(btn, 2, 3);
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
