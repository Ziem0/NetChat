package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("Grid window");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(5);
		grid.setVgap(10);

		//Name label
		Label label = new Label("Username:");
		GridPane.setConstraints(label, 0, 0);

		//Input
		TextField textField = new TextField("ziemo");   //is default input
		GridPane.setConstraints(textField, 1, 0);

		//Password label
		Label label2 = new Label("Password:");
		GridPane.setConstraints(label2, 0, 1);

		//Input
		TextField textField2 = new TextField();
		textField2.setPromptText("password");  //is default prompt
		GridPane.setConstraints(textField2, 1, 1);

		Button button = new Button("Login");
		button.setOnAction(e -> checkUsername(textField, textField2, window));
		GridPane.setConstraints(button, 2, 2);

		grid.getChildren().addAll(label, textField, label2, textField2, button);

		Scene scene = new Scene(grid);

		window.setScene(scene);
		window.show();
	}

	private void checkUsername(TextField username, TextField password, Stage window) {
		if (username.getText().equals("ziemoe") && password.getText().equals("1212")) {
			System.out.println("that's right! you logged!");
			window.close();
		} else {
			System.out.println("incorrect inputs!");
		}
	}



}
