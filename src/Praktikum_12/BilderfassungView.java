package Praktikum_12;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.mv.fachlogik.Bild;
import pk1.mv.fachlogik.Medienverwaltung;
import pk1.mv.fachlogik.Medium;

public class BilderfassungView extends Stage {

	private Bild bild;
	private TextField tf_titel;
	private TextField tf_ort;
	private TextField tf_aufnahmejahr;
	private Medienverwaltung mv;
	private ObservableList<Medium> list;
	
	public BilderfassungView(Bild bild, Stage primaryStage, Medienverwaltung mv, ObservableList<Medium> list) {
		this.initOwner(primaryStage);
		this.initModality(Modality.WINDOW_MODAL);
		this.bild = bild;
		this.tf_titel = new TextField();
		this.tf_ort = new TextField();
		this.tf_aufnahmejahr = new TextField();
		this.mv = mv;
		this.list = list;
	}
	
	public void showView() {
		setTitle("Bilderfassung");
		
		if(this.bild != null) {
			tf_titel.setText(this.bild.getTitel());
			tf_ort.setText(this.bild.getOrt());
			tf_aufnahmejahr.setText(this.bild.getJahr()+"");
		}
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		Label titel = new Label("Titel:");
		GridPane.setHgrow(tf_titel, Priority.ALWAYS);
		gp.addRow(0, titel, tf_titel);
		
		Label ort = new Label("Ort:");
		GridPane.setHgrow(tf_ort, Priority.ALWAYS);
		gp.addRow(1, ort, tf_ort);
		
		Label aufnahmejahr = new Label("Aufnahmejahr:");
		GridPane.setHgrow(tf_aufnahmejahr, Priority.ALWAYS);
		gp.addRow(2, aufnahmejahr, tf_aufnahmejahr);
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10); // Abschaende zwsichen den Elementen
		Button neu = new Button("Neu");
		neu.setOnAction((ActionEvent arg0) -> {
				save();
				close();
			});
		Button abbrechen = new Button("Abbrechen");
		hb.getChildren().addAll(neu, abbrechen);

		root.setTop(gp);
		root.setBottom(hb);
		
		// immer
		Scene sc = new Scene(root, 400, 200);
		setScene(sc);
		showAndWait(); // Hauptfenster sperren, solange dieses Fenster offen ist.
	}
	
	private void save() {
		if(tf_titel != null && tf_aufnahmejahr != null && tf_ort != null) {
			bild = new Bild(tf_titel.getText(), Integer.parseInt(tf_aufnahmejahr.getText()), tf_ort.getText());
			mv.aufnehmen(bild);
			this.list.add(bild);
		}
	}
	
}
