package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("Start Window");

		//create choice lists
		ChoiceBox<String> list = new ChoiceBox<>();
		list.getItems().addAll("Apple", "Banana", "Cheese");
		list.setValue("Banana");                    // -> must be from list above

		//listener for choiceBox
//		list.getSelectionModel().selectedItemProperty().addListener((v, oldV, newV) -> System.out.println(newV));
		list.setOnAction(e -> System.out.println("result: " + list.getValue()));

		Button button = new Button("Add: ");
		button.setOnAction(e -> handleOrder(list));

		VBox layout = new VBox();
		layout.getChildren().addAll(list, button);

		Scene scene = new Scene(layout, 300, 200);

		window.setScene(scene);

		window.show();
	}

	private String handleOrder(ChoiceBox list) {
		String value = (String) list.getValue();
//		System.out.println(value);
		return value;
	}

}
