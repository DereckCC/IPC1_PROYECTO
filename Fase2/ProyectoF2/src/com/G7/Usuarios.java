package com.G7;

import java.io.Serializable;

    public class Usuarios implements Serializable {
        public String username;
        public String password;

    public Usuarios(String nombre, String pass){
        this.username = nombre;
        this.password = pass;

}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] toArreglo(){
        String retorno [] = {this.username};
        return retorno;
    }
}
