package pk1.mv.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pk1.mv.fachlogik.*;
import pk1.mv.gui.util.*;

public class Hauptfenster extends Application {

	private Medienverwaltung mv;
	private ObservableList<Medium> list;
	private ListView<Medium> listView;
	public Hauptfenster() {
		this.mv = new Medienverwaltung();
		this.list = FXCollections.<Medium>observableArrayList();
		this.listView = new ListView<Medium>(list);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hauptfenster");
		BorderPane root = new BorderPane();
		
		root.setTop(createMenuBar(primaryStage));
		
		root.setCenter(listView);
		
		Scene sc = new Scene(root, 700, 250);
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
	public MenuBar createMenuBar(Stage primaryStage) {
		MenuBar mb = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem laden = new MenuItem("Laden");
		laden.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mv.laden();
				list.addAll(mv.getMedienListe());
			}
		});
		MenuItem speichern = new MenuItem("Speichern");
		speichern.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mv.speichern();
			}
		});
		MenuItem medienliste = new MenuItem("Medienliste in Datei");
		medienliste.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name = InputView.create(primaryStage, "Medienliste in Datei", "Geben Sie bitte einen Namen ein", "").showView();
				mv.medienInDateiSchreiben(name);
			}
		});
		MenuItem beenden = new MenuItem("Beenden");
		beenden.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
			}
		});
		datei.getItems().addAll(laden, speichern, new SeparatorMenuItem(), medienliste, new SeparatorMenuItem(), beenden);
		
		
		Menu medium = new Menu("Medium");
		MenuItem audioNeu = new MenuItem("Audio neu");
		audioNeu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AudioerfassungView aev = new AudioerfassungView(null, primaryStage, mv, list);
				aev.showView();
			}
		});
		MenuItem bildNeu = new MenuItem("Bild neu");
		bildNeu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				BilderfassungView bev = new BilderfassungView(null, primaryStage, mv, list);
				bev.showView();
			}
		});
		medium.getItems().addAll(audioNeu, bildNeu);
		
		Menu anzeige = new Menu("Anzeige");
		MenuItem erscheinungsjahr = new MenuItem("Erscheinungsjahr");
		erscheinungsjahr.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double durchschnitt = mv.berechneErscheinungsjahr();
				MessageView.create(primaryStage, "Erscheinungsjahr", "Durchschnittliches Erscheinungsjahr ist " + durchschnitt).showView();
			}
		});
		MenuItem neuesMedium = new MenuItem("Neuestes Medium");
		neuesMedium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String msg = mv.sucheNeuesMedium() != null ? mv.sucheNeuesMedium().toString() : "Keine Medien vorhanden";
				MessageView.create(primaryStage, "Neuestes Medium", msg).showView();
			}
		});
		anzeige.getItems().addAll(erscheinungsjahr, neuesMedium);
		mb.getMenus().addAll(datei, medium, anzeige);
		return mb;
	}
	
	public static void main(String[] args) {
		launch();
	}

}
