package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("menu");

		Menu file = new Menu("_File");

		MenuItem newProject = new MenuItem("New project..");
		newProject.setOnAction(e -> System.out.println("create new project..."));
		file.getItems().add(newProject);
		file.getItems().add(new MenuItem("Settings"));
		file.getItems().add(new SeparatorMenuItem());
		file.getItems().add(new MenuItem("Exit"));

		Menu difficulty = new Menu("Difficulty");
		ToggleGroup toggleDifficulty = new ToggleGroup();

		RadioMenuItem easy = new RadioMenuItem("easy");
		RadioMenuItem medium = new RadioMenuItem("medium");
		RadioMenuItem hard = new RadioMenuItem("hard");

		easy.setToggleGroup(toggleDifficulty);
		medium.setToggleGroup(toggleDifficulty);
		hard.setToggleGroup(toggleDifficulty);

		difficulty.getItems().addAll(easy, medium, hard);

		MenuBar main = new MenuBar();
		main.getMenus().addAll(file, difficulty);

		BorderPane lay = new BorderPane();
		lay.setTop(main);
		lay.setStyle("-fx-background-color: black");
		Scene scene = new Scene(lay, 400, 300);
		window.setScene(scene);
		window.show();
	}
}
