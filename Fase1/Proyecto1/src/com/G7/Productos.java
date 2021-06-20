package com.G7;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Productos  implements Serializable {
    public int id;
    public String name;
    public String description;
    public double cost;
    public double price;
    public ingredientes[] ingredients;

    public Productos(int id, String name, String description, double cost, double price,ingredientes[] ingredients ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ingredientes[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(ingredientes[] ingredients) {
        this.ingredients = ingredients;
    }
}
