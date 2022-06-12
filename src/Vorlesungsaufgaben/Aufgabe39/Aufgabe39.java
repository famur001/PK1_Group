package Vorlesungsaufgaben.Aufgabe39;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe39 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		primaryStage.setTitle("Farb-Test");
		
		Rectangle rectangle = new Rectangle(100, 100);
		rectangle.setFill(Color.GREEN);
		
		Button button = new Button("Farbenwechsel");
		BorderPane.setAlignment(button, Pos.CENTER);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				rectangle.setFill(Color.rgb((int)(Math.random()*100), (int)(Math.random()*200), (int)(Math.random()*210)));
			}
		});
		
		root.setCenter(rectangle);
		root.setBottom(button);
		
		Scene scene = new Scene(root, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
