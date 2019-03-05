package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComplexLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("StartWindow");
		window.setMinWidth(300);
		window.setMinHeight(300);

		HBox top = new HBox();
		Button button1 = new Button("File");
		Button button2 = new Button("Edit");
		Button button3 = new Button("View");
		top.getChildren().addAll(button1, button2, button3);

		VBox left = new VBox();
		Button button4 = new Button("Links");
		Button button5 = new Button("Pics");
		Button button6 = new Button("Others");
		left.getChildren().addAll(button4, button5, button6);


		//CheckBoxes
		CheckBox box1 = new CheckBox("Cheese");
		CheckBox box2 = new CheckBox("Ham");
		box1.setSelected(true);

		Button orderBtn = new Button("order");
		orderBtn.setOnAction(e -> checkOrder(box1, box2, window));

		VBox menu = new VBox();
		menu.getChildren().addAll(box1, box2, orderBtn);

		//create borderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(top);
		borderPane.setLeft(left);
		borderPane.setRight(menu);

		Scene scene = new Scene(borderPane);

		window.setScene(scene);
		window.show();
	}

	private void checkOrder(CheckBox checkBox1, CheckBox checkBox2, Stage window) {
		if (checkBox1.isSelected()) {
			System.out.println("ordered: " + checkBox1.getText());
		}

		if (checkBox2.isSelected()) {
			System.out.println("ordered: " + checkBox2.getText());
		}
		System.out.println();
	}
}
