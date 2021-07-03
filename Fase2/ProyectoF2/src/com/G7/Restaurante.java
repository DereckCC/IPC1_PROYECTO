package com.G7;

import java.io.Serializable;

public class Restaurante implements Serializable {
    public String name;
    public String address;
    public int phone;
    public String load;

    public Restaurante(String name, String address, int phone, String load){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.load = load;

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

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }


    public String[] toArreglo(){
        String retorno [] = {this.name, this.address, String.valueOf(this.phone), this.load};
        return retorno;
    }
}
