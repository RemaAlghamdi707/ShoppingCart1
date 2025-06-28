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


import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<ProductComponent> cart = new ArrayList<>();

    private CartManager() {}

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(ProductComponent product) {
        cart.add(product);
    }

    public List<ProductComponent> getCart() {
        return cart;
    }

    public double getTotal() {
        return cart.stream().mapToDouble(ProductComponent::getPrice).sum();
    }

    public void clearCart() {
        cart.clear();
    }
}
