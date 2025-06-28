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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SummaryScreen {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Your Cart");

        TextArea summaryArea = new TextArea();
        summaryArea.setEditable(false);

        Button loadButton = new Button("Load Summary");
        Button clearButton = new Button("Clear Cart");
        Button backButton = new Button("Back to Main");

        String buttonStyle = "-fx-border-color: #1a237e; -fx-border-width: 2; " +
                "-fx-background-color: transparent; -fx-text-fill: #1a237e; " +
                "-fx-font-weight: bold; -fx-font-size: 14px; " +
                "-fx-pref-width: 200px; -fx-pref-height: 40px; " +
                "-fx-background-radius: 15px;";

        loadButton.setStyle(buttonStyle);
        clearButton.setStyle(buttonStyle);
        backButton.setStyle(buttonStyle);

        loadButton.setOnAction(e -> {
            CartSummaryFacade facade = new CartSummaryFacade();
            summaryArea.setText(facade.generateSummary());
        });

        clearButton.setOnAction(e -> {
            CartManager.getInstance().clearCart();
            summaryArea.clear();
        });

        backButton.setOnAction(e -> new MainScreen().start(primaryStage));

        VBox root = new VBox(10, new Label("Cart Summary:"), summaryArea, loadButton, clearButton, backButton);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0fcfa;");

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}






