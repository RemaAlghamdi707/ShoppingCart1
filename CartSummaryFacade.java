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


import java.util.List;

public class CartSummaryFacade {
    public String generateSummary() {
        List<ProductComponent> cart = CartManager.getInstance().getCart();
        if (cart.isEmpty()) return "Your cart is empty.";

        StringBuilder sb = new StringBuilder();
        sb.append("CART SUMMARY:\n\n");
        double total = 0;
        int count = 1;

        for (ProductComponent item : cart) {
            sb.append(count++).append(". ")
              .append(item.getName())
              .append(" - ").append(item.getPrice()).append(" SAR\n");
            total += item.getPrice();
        }

        sb.append("\nTOTAL: ").append(String.format("%.2f", total)).append(" SAR");
        return sb.toString();
    }
}



