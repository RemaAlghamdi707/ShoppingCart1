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


public class BundleBuilder {
    private ProductBundle bundle;

    public void reset() {
        bundle = new ProductBundle("Custom Bundle");
    }

    public void addMacbook() {
        bundle.add(new SingleProduct("MacBook Pro 14\"", 8499));
    }

    public void addIphone() {
        bundle.add(new SingleProduct("iPhone 16 Pro", 5499));
    }

    public void addIpad() {
        bundle.add(new SingleProduct("iPad Air", 2999));
    }

    public void addAirpods() {
        bundle.add(new SingleProduct("AirPods Pro", 999));
    }

    public void addKeyboard() {
        bundle.add(new SingleProduct("Magic Keyboard", 899));
    }

    public void addMouse() {
        bundle.add(new SingleProduct("Magic Mouse", 499));
    }

    public void addPencil() {
        bundle.add(new SingleProduct("Apple Pencil", 499));
    }

    public ProductComponent build(String name) {
        bundle.setName(name + " - Total: " + bundle.getPrice() + " SAR");
        return bundle;
    }
}




