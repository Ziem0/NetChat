package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("Start Window");


		ListView<String> list = new ListView<>();
		list.getItems().addAll("Titanic", "BraveHeart", "Minions");
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Button button = new Button("Add: ");
		button.setOnAction(e -> handleList(list));

		VBox layout = new VBox();
		layout.getChildren().addAll(list, button);

		Scene scene = new Scene(layout, 300, 200);

		window.setScene(scene);

		window.show();
	}

	private void handleList(ListView<String> list) {
		ObservableList<String> selectedItems = list.getSelectionModel().getSelectedItems();
		selectedItems.forEach(System.out::println);
		System.out.println();
	}

}
