/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopping;


/**
 * Name, ID:-
 * Samar Asiri, 444000717
 * Rema Al-Ghamdi, 444001279
 * Aya Babkoor, 444002180
 * Raghad Al-Subhi, 444003965
 * 
 * Groub: 1
 */


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ProductScreen {
    private CommandManager commandManager = new CommandManager();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shopping Cart");

        ListView<ProductComponent> productList = new ListView<>();
        ListView<ProductComponent> cartList = new ListView<>();
        Label totalLabel = new Label("Total: 0.00 SAR");

        productList.getItems().addAll(
                new SingleProduct("MacBook Pro 14\"", 8499),
                new SingleProduct("iPhone 16 Pro", 5499),
                new SingleProduct("iPad Air", 2999),
                new SingleProduct("AirPods Pro", 999),
                new SingleProduct("Magic Keyboard", 899),
                new SingleProduct("Magic Mouse", 499),
                new SingleProduct("Apple Pencil", 499)
        );

        Button addButton = new Button("Add to Cart");
        Button removeButton = new Button("Remove from Cart");
        Button undoButton = new Button("Undo");
        Button backButton = new Button("Back to Main");

        String buttonStyle = "-fx-border-color: #1a237e; -fx-border-width: 2; " +
                "-fx-background-color: transparent; -fx-text-fill: #1a237e; " +
                "-fx-font-weight: bold; -fx-font-size: 14px; " +
                "-fx-pref-width: 200px; -fx-pref-height: 40px; " +
                "-fx-background-radius: 15px;";

        addButton.setStyle(buttonStyle);
        removeButton.setStyle(buttonStyle);
        undoButton.setStyle(buttonStyle);
        backButton.setStyle(buttonStyle);

        addButton.setOnAction(e -> {
            ProductComponent selected = productList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                commandManager.executeCommand(new AddToCartCommand(selected, CartManager.getInstance().getCart()));
                updateCart(cartList, totalLabel);
            }
        });

        removeButton.setOnAction(e -> {
            ProductComponent selected = cartList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                commandManager.executeCommand(new RemoveFromCartCommand(selected, CartManager.getInstance().getCart()));
                updateCart(cartList, totalLabel);
            }
        });

        undoButton.setOnAction(e -> {
            commandManager.undoLastCommand();
            updateCart(cartList, totalLabel);
        });

        backButton.setOnAction(e -> new MainScreen().start(primaryStage));

        VBox left = new VBox(10, new Label("Available Products:"), productList, addButton);
        VBox right = new VBox(10, new Label("Your Cart:"), cartList, totalLabel, removeButton, undoButton, backButton);

        HBox root = new HBox(20, left, right);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0fcfa;");

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCart(ListView<ProductComponent> cartList, Label totalLabel) {
        cartList.getItems().setAll(CartManager.getInstance().getCart());
        totalLabel.setText("Total: " + String.format("%.2f", CartManager.getInstance().getTotal()) + " SAR");
    }
}
