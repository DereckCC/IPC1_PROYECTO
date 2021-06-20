package com.G7;

import java.io.Serializable;

public class Clientes implements Serializable {
    public int id;
    public String name;
    public String address;
    public int phone;
    public String nit;

    public  Clientes (int id, String name,String address, int phone, String  nit){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nit = nit;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
