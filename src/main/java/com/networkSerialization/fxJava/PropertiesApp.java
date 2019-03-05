package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PropertiesApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		window.setTitle("properties");

		Person ziemo = new Person();

		ziemo.nameProperty().addListener((v, oldV, newV) -> {
			System.out.println("name changed to: " + newV);
			System.out.println("firstNameProperty(): " + ziemo.nameProperty());
			System.out.println("getName: " + ziemo.getName());
		});

		//binding
		StringProperty x = new SimpleStringProperty("ziemo");
		StringProperty y = new SimpleStringProperty();
		y.bind(x);

		System.out.println("x:" + x.getValue());
		System.out.println("y:" + y.getValue());

		//elemets
		Button butt = new Button("start");
		butt.setOnAction(e -> ziemo.setName("ania"));

		//bind
		TextField input1 = new TextField();
		Label label = new Label("welcome! This is your ");
		Label label2 = new Label();
		label2.textProperty().bind(input1.textProperty());

		VBox lay = new VBox();
		lay.getChildren().addAll(butt, input1, label, label2);

		Scene scene = new Scene(lay, 300, 300);
		window.setScene(scene);
		window.show();
	}
}
