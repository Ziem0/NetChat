package com.networkSerialization.fxJava;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		window.setMinHeight(200);

		Label label1 = new Label();
		label1.setText(message);
		Button button1 = new Button("Close this alert");
		button1.setOnAction(e -> window.close());

		VBox layout = new VBox(20);
		layout.getChildren().addAll(label1, button1);
		layout.setAlignment(Pos.BASELINE_CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

}
