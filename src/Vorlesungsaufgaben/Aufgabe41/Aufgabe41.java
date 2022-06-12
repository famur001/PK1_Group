package Vorlesungsaufgaben.Aufgabe41;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe41 extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		root.setPadding(new Insets(10));
		primaryStage.setTitle("Farb-Test");
		
		Rectangle rectangle = new Rectangle(50, 50);
		rectangle.setFill(Color.BLUE);

		root.getChildren().add(rectangle);
		
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				rectangle.setX(event.getSceneX());
				rectangle.setY(event.getSceneY());
			}
		});
		
		
		Scene scene = new Scene(root, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
