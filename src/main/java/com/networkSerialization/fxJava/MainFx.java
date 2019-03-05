package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//implements EventHandler<ActionEvent>
public class MainFx extends Application {

	Button button;

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("MyStage");

		button = new Button();
		button.setText("Click me");
		button.setOnAction(e -> System.out.println("All right baby!"));  // everytime click, handle method lauch; can use lambda as this interface got 1 method

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
