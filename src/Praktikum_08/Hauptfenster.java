package Praktikum_08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hauptfenster");
		
		BorderPane root = new BorderPane();
		
		BilderfassungView bev = new BilderfassungView(null, primaryStage);
		bev.showView();
		
		Scene sc = new Scene(root, 500, 500);
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
