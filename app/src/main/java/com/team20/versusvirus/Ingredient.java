package com.team20.versusvirus;

public class Ingredient{
    public Integer id_ingredient;
    public Double quantity;
    public String quantifier, type, name;

    public Ingredient(Integer id_ingredient, Double quantity, String quantifier, String type, String name) {
        this.id_ingredient = id_ingredient;
        this.quantity = quantity;
        this.quantifier = quantifier;
        this.type = type;
        this.name = name;
    }

    public Ingredient() {}
}
