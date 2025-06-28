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


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }
    
    public static String systemCurrency() {
        return "SAR";
    }
    
    public static String storeName() {
        return "Apple Store";
    }
    
    public static String[] supportedProducts() {
        return new String[] {
            "MacBook Pro 14\" - 8,499 SAR",
            "iPhone 16 Pro - 5,499 SAR",
            "iPad Air - 2,999 SAR",
            "AirPods Pro - 999 SAR",
            "Magic Keyboard - 899 SAR",
            "Magic Mouse - 499 SAR",
            "Apple Pencil - 499 SAR"
        };
    }
    
    public static void displaySystemInfo(Stage stage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("System Information");
        alert.setHeaderText("Store Configuration Details");
        
        String content = "Store Name: " + storeName() + "\n"
                + "Currency: " + systemCurrency() + "\n\n"
                + "Java Version: " + javaVersion() + "\n"
                + "JavaFX Version: " + javafxVersion() + "\n\n"
                + "Supported Products:\n";
        
        for (String product : supportedProducts()) {
            content += "- " + product + "\n";
        }
        
        alert.setContentText(content);
        alert.initOwner(stage);
        alert.showAndWait();
    }
}
