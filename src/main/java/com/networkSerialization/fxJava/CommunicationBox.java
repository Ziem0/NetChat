package com.networkSerialization.fxJava;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommunicationBox {

	private static boolean answer;

	public static boolean display(String message) {

		Stage window = new Stage();
		window.setMinHeight(300);
		window.setMinWidth(300);
		window.setTitle("Window to choose option");

		Label label = new Label();
		label.setText(message);
		Button buttonY = new Button("Yes");
		buttonY.setOnAction(e -> {
			answer = true;
			window.close();
		});
		Button buttonN = new Button("No");
		buttonN.setOnAction(e -> {
			answer = false;
			window.close();
		});

		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, buttonN, buttonY);

		Scene scene = new Scene(layout, 300, 300);

		window.setScene(scene);
		window.showAndWait();

		return answer;
	}
}
