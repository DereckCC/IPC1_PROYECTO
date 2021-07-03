package com.G7;

import java.io.Serializable;

public class Facturas implements Serializable {
    public int id;
    public int client;
    public String date;
    public Productos[] products;

    public Facturas (int id, int client, String date, Productos[] products){
        this.id = id;
        this.client = client;
        this.date = date;
        this.products= products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Productos[] getProducts() {
        return products;
    }

    public void setProducts(Productos[] products) {
        this.products = products;
    }
}
