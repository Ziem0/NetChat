package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrreViewApp extends Application {

	TreeView<String> tree;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage window = primaryStage;
		window.setTitle("Start Window");

		//creating items for TreeView
		TreeItem<String> root, ziemo, ania;

		//root
		root = new TreeItem<>();   // no need to create name for root cause it doesnt display
		root.setExpanded(true);    // so expand automatically, cause name isn't set

		//ziemo
		ziemo = makeBranch("Ziemo", root);
		makeBranch("basket", ziemo);
		makeBranch("programming", ziemo);
		makeBranch("music", ziemo);

		//ania
		ania = makeBranch("Ania", root);
		makeBranch("makeup", ania);
		makeBranch("singing", ania);
		makeBranch("psychology", ania);

		//create TreeView
		tree = new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty()
			.addListener((v, oldV, newV) -> {
				if (newV != null) {
					System.out.println(newV);
				}
			});

		VBox layout = new VBox();
		layout.getChildren().add(tree);

		Scene scene = new Scene(layout, 300, 200);

		window.setScene(scene);

		window.show();
	}

	private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}

}
