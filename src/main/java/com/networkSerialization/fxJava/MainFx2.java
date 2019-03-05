package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFx2 extends Application {

	Stage window;
	Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;

		Label label1 = new Label("Welcome in scene 1 !");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		Button button3 = new Button("Go to new window!");
		button3.setOnAction(e -> AlertBox.display("alert window", "welcome in new window"));
		Button closeButton = new Button("Close!");
		closeButton.setOnAction(e -> closePorgram());

		//layout for scene 1
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1, button3, closeButton);
		scene1 = new Scene(layout1, 200, 200);

		Button button2 = new Button("Get back to scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		Button button4 = new Button("Go to question about my girlfriend");
		button4.setOnAction(e -> {
			boolean display = CommunicationBox.display("Would you like to send naked pics your girlfriend?");
			System.out.println(display);
		});

		//layout for scene 2
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(button2, button4);
		scene2 = new Scene(layout2, 300, 300);

		window.setTitle("Stage");
		window.setScene(scene1);
		window.show();

		window.setOnCloseRequest(e -> {   // -> It deals with do something and then close program no matter if boolean in it
			e.consume();            // -> correct closing. It indicates that we will handle closing
			closePorgram();
		});
	}

	public void closePorgram() {
		Boolean answer = CommunicationBox.display("Sure you wanna exit?");
		if (answer) {
			window.close();
		}
	}

}
