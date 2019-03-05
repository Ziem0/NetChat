package com.networkSerialization.fxJava;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewApp extends Application {

	TableView<Product> table;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		window.setTitle("Table");

		//column1
		TableColumn<Product, String> name = new TableColumn<>("Name");
		name.setMinWidth(200);
		name.setCellValueFactory(new PropertyValueFactory<>("name"));

		//column2
		TableColumn<Product, String> price = new TableColumn<>("Price");
		price.setMinWidth(200);
		price.setCellValueFactory(new PropertyValueFactory<>("price"));

		//column3
		TableColumn<Product, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setMinWidth(200);
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		table = new TableView<>();
		table.setItems(getProducts());
		table.getColumns().addAll(name, price, quantity);

		//input
		TextField nameI = new TextField();
		nameI.setPromptText("name");
		TextField priceI = new TextField();
		priceI.setPromptText("price");
		TextField quantityI = new TextField();
		quantityI.setPromptText("quantity");

		//button
		Button add = new Button("add");
		add.setOnAction(e -> addButtonHandler(nameI, priceI, quantityI));
		Button delete = new Button("delete");
		delete.setOnAction(e -> deleteButtonHandler());

		HBox frame = new HBox();
		frame.setPadding(new Insets(10, 10, 10, 10));
		frame.setSpacing(10);
		frame.getChildren().addAll(nameI, priceI, quantityI, add, delete);

		VBox layout = new VBox();
		layout.getChildren().addAll(table, frame);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

	public void addButtonHandler(TextField nameI, TextField priceI, TextField quantityI) {
		Product newPr = new Product();
		newPr.setName(nameI.getText());
		newPr.setPrice(priceI.getText());
		newPr.setQuantity(Integer.parseInt(quantityI.getText()));
		table.getItems().add(newPr);
		nameI.clear();
		priceI.clear();
		quantityI.clear();
	}

	public void deleteButtonHandler() {
		ObservableList<Product> selectedProduct, productsAll;
		selectedProduct = table.getSelectionModel().getSelectedItems();
		productsAll = table.getItems();
		selectedProduct.forEach(productsAll::remove);
	}

	//get all products
	public ObservableList<Product> getProducts() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("guitar", "5000", 2));
		products.add(new Product("amp", "6000", 3));
		products.add(new Product("cable", "200", 4));
		products.add(new Product("pick", "5", 5));
		products.add(new Product("strings", "32", 6));
		return products;
	}
}
