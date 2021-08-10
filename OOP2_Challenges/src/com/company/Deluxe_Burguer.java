package com.company;

import java.sql.SQLOutput;

public class Deluxe_Burguer extends Hamburguer{
    public Deluxe_Burguer(String bread, String meat, int price) {
        super(bread, meat, price, new Ingredient("Coke",2),new Ingredient ("chips",2));
    }

    @Override
    public void addIngredient(Ingredient extra) {
        System.out.println("You are not allowed to add more Ingredients");
    }
}
