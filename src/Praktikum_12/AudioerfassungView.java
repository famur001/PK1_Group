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
import pk1.mv.fachlogik.Audio;
import pk1.mv.fachlogik.Bild;
import pk1.mv.fachlogik.Medienverwaltung;
import pk1.mv.fachlogik.Medium;

public class AudioerfassungView extends Stage {
	
	private Audio audio;
	private TextField tf_titel;
	private TextField tf_aufnahmejahr;
	private TextField tf_interpert;
	private TextField tf_dauer;
	private Medienverwaltung mv;
	private ObservableList<Medium> list;
	
	public AudioerfassungView(Audio audio, Stage primaryStage, Medienverwaltung mv, ObservableList<Medium> list) {
		this.initOwner(primaryStage);
		this.initModality(Modality.WINDOW_MODAL);
		this.audio = audio;
		this.tf_titel = new TextField();
		this.tf_aufnahmejahr = new TextField();
		this.tf_interpert = new TextField();
		this.tf_dauer = new TextField();
		this.mv = mv;
		this.list = list;
	}
	
	public void showView() {
		setTitle("Audioerfassung");
		
		if(this.audio != null) {
			tf_titel.setText(this.audio.getTitel());
			tf_aufnahmejahr.setText(this.audio.getJahr()+"");
			tf_interpert.setText(this.audio.getInterpret());
			tf_dauer.setText(this.audio.getDauer()+"");
		}
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		Label titel = new Label("Titel:");
		GridPane.setHgrow(tf_titel, Priority.ALWAYS);
		gp.addRow(0, titel, tf_titel);
		
		Label aufnahmejahr = new Label("Aufnahmejahr:");
		GridPane.setHgrow(tf_aufnahmejahr, Priority.ALWAYS);
		gp.addRow(1, aufnahmejahr, tf_aufnahmejahr);
		
		Label ort = new Label("Interpret:");
		GridPane.setHgrow(tf_interpert, Priority.ALWAYS);
		gp.addRow(2, ort, tf_interpert);

		Label dauer = new Label("Dauer:");
		GridPane.setHgrow(tf_dauer, Priority.ALWAYS);
		gp.addRow(3, dauer, tf_dauer);
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10); // Abschaende zwsichen den Elementen
		Button neu = new Button("Neu");
		neu.setOnAction((ActionEvent event) -> {
				save();
				close();
			});
		Button abbrechen = new Button("Abbrechen");
		hb.getChildren().addAll(neu, abbrechen);

		root.setTop(gp);
		root.setBottom(hb);
		
		Scene sc = new Scene(root, 400, 200);
		setScene(sc);
		showAndWait();
	}
	
	public void save() {
		if (tf_titel != null && tf_aufnahmejahr != null
			&& tf_interpert != null && tf_dauer != null) {
			audio = new Audio(tf_titel.getText(), Integer.parseInt(tf_aufnahmejahr.getText()),
						tf_interpert.getText(), Integer.parseInt(tf_dauer.getText()));
			this.mv.aufnehmen(audio); // in die Medienverwaltung hinzufuegen
			this.list.add(audio); // in der ListView anzeigen
		}
	}
	
}
