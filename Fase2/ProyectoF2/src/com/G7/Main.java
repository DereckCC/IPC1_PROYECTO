package com.G7;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;


import javax.swing.*;


public class Main {
    public static Scanner consola = new Scanner(System.in);
    public static ArrayList<Usuarios> usuariosArr;
    public static ArrayList<Productos> productosArr;
    public static ArrayList<Clientes> clientesArr;
    public static ArrayList<Facturas> facturasArr;
    public static ArrayList<Restaurante> restauranteArr;
    public static String usuarioLog;


    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(new NoireLookAndFeel());
            cargarRestaurante();
            cargarUsuarios();
            cargarProductos();
            cargarCliente();
            cargarFacturas();
            Login nuevo = new Login();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void cargarRestaurante() {
        String contenidoResta = Files.getContentOfFile("config.json");
        Gson gsonR = new Gson();
        Restaurante resta = gsonR.fromJson(contenidoResta, Restaurante.class);
        System.out.println();
        restauranteArr = new ArrayList<>();
        restauranteArr.add(resta);
    }

    public static void cargarUsuarios() {

        String usuarioRepetido="";
        try {
            String contenidoUsuarios = Files.getContentOfFile("users.json");
            Gson gsonU = new Gson();
            Usuarios[] usuaris = gsonU.fromJson(contenidoUsuarios, Usuarios[].class);
            System.out.println();
            usuariosArr = new ArrayList<>();

            for (Usuarios usuario : usuaris) {
                boolean flag = false;
                for (int i = 0; i < usuariosArr.size(); i++) {

                    if (usuario.getUsername().equals(usuariosArr.get(i).getUsername())) {
                        flag = true;
                        usuarioRepetido = usuario.getUsername();
                        break;
                    }
                }
                if (flag) {
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " El usuario " + usuarioRepetido + " ya existe,se omitió el registro." + "\n");
                    continue;
                }
                usuariosArr.add(usuario);
            }
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS: Error en la carga de usuarios.json" + "\n");
        }
    }

    public static void cargarProductos() {
        int productoRepetido=0;
        try{
            String contenidoProductos = Files.getContentOfFile("products.json");
            Gson gsonP = new Gson();
            Productos[] produc = gsonP.fromJson(contenidoProductos, Productos[].class);
            System.out.println();
            productosArr = new ArrayList<>();

            for (Productos prodic : produc) {
                boolean flag = false;
                for (int i = 0; i < productosArr.size(); i++) {

                    if (prodic.getId()==productosArr.get(i).getId()) {
                        flag = true;
                        productoRepetido = prodic.getId();
                        break;
                    }
                }
                if (flag) {
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " El producto con id " + productoRepetido + " ya existe,se omitió el registro." + "\n");
                    continue;
                }

                productosArr.add(prodic);
            }

        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS: Error en la carga de productos.json" + "\n");

        }

    }

    public static void cargarCliente() {
        int clienteRepetido=0;
        try{
            String contenidoClientes = Files.getContentOfFile("clients.json");
            Gson gsonC = new Gson();
            Clientes[] client = gsonC.fromJson(contenidoClientes, Clientes[].class);
            System.out.println();

            clientesArr = new ArrayList<>();

            for (Clientes clie : client) {
                boolean flag = false;
                for (int i = 0; i < clientesArr.size(); i++) {

                    if (clie.getId()==clientesArr.get(i).getId()) {
                        flag = true;
                        clienteRepetido = clie.getId();
                        break;
                    }
                }
                if (flag) {
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " El cliente con id " + clienteRepetido + " ya existe,se omitió el registro." + "\n");
                    continue;
                }

                clientesArr.add(clie);
        }
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES: Error en la carga de clientes.json" + "\n");

        }
    }

    public static void cargarFacturas() {
        int facturaRepetida=0;
        try {
            String contenidoFactura = Files.getContentOfFile("invoices.json");
            Gson gsonF = new Gson();
            Facturas[] factu = gsonF.fromJson(contenidoFactura, Facturas[].class);
            facturasArr = new ArrayList<>();

            for (Facturas fact : factu) {
                boolean flag = false;
                for (int i = 0; i < facturasArr.size(); i++) {

                    if (fact.getId()==facturasArr.get(i).getId()) {
                        flag = true;
                        facturaRepetida = fact.getId();
                        break;
                    }
                }
                if (flag) {
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " La factura con id " + facturaRepetida + " ya existe,se omitió el registro." + "\n");
                    continue;
                }
                facturasArr.add(fact);
            }
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS: Error en la carga de facturas.json" + "\n");

        }

    }

    public static void startMenu() throws IOException {
        System.out.println("Seleccione una opcion:");
        System.out.println("01. Informacion del restaurante.");
        System.out.println("02. Usuarios.");
        System.out.println("03. Productos.");
        System.out.println("04. Clientes.");
        System.out.println("05. Facturas.");
        System.out.println("06. Guardar Cambios.");
        System.out.println("07. Cerrar.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                mostrarRestaurante();
                System.out.println();
                break;
            case "2":
                menuUsuarios();
                System.out.println();
                break;
            case "3":
                menuProductos();
                System.out.println();
                break;
            case "4":
                menuClientes();
                System.out.println();
                break;
            case "5":
                menuFacturas();
                System.out.println();
                break;
            case "6":
                menuGuardarCambios();
                System.out.println();
                break;
            case "7":
                System.out.println("bai");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }
        startMenu();
    }

    public static void mostrarRestaurante() {
        System.out.println("Nombre\t\t\t\t\t\t Dirección\t\t\t\tTelefono\t\tCarga");
        for (int i = 0; i < restauranteArr.size(); i++) {
            System.out.println(restauranteArr.get(i).getName() + "\t\t" + restauranteArr.get(i).getAddress() + "\t\t" + restauranteArr.get(i).getPhone() + "\t\t" + restauranteArr.get(i).getLoad() + "\n");
        }
    }

    public static void menuUsuarios() {
        System.out.println("01. Listar Usuarios..");
        System.out.println("02. Eliminar Usuario.");
        System.out.println("03. Ver Usuarios.");
        System.out.println("04. Regresar al menu principal.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                mostrarUsuario();
                break;
            case "2":
                eliminarUsuario();
                break;
            case "3":
                verUsuario();
                break;
            case "4":
                System.out.println("\n");
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }

    }

    public static void mostrarUsuario() {
        System.out.println("ID\t\t Username\t\t\t password*");
        for (int i = 0; i < usuariosArr.size(); i++) {

            System.out.println("|" + i + " \t\t" + usuariosArr.get(i).getUsername() + "\t\t" + usuariosArr.get(i).getPassword() + "|");
        }
        System.out.println();
    }

    public static void eliminarUsuario() {
        try {
            System.out.println("Escriba el id del usuario que desea eliminar.");
            int eliminar = consola.nextInt();
            String nombreEliminado= usuariosArr.get(eliminar).getUsername();
            usuariosArr.remove(eliminar);
            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ usuarioLog+":"+" Elimino el usuario "+'\u0022'+nombreEliminado +'\u0022'+" con id "+ eliminar+ "\n");
            System.out.println(usuarioLog+":"+" Elimino el usuario "+'\u0022'+nombreEliminado +'\u0022'+" con id "+ eliminar);
        } catch (Exception e) {
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "Usuarios: Error en la eliminación de usuario, el id no existe." + "\n");

        }
    }

    public static void verUsuario() {
        try {
            System.out.println("Escriba el id del usuario que desea ver:");
            int ver = consola.nextInt();
            System.out.println("Username: " + usuariosArr.get(ver).getUsername());
            System.out.println("Password: " + usuariosArr.get(ver).getPassword());
            System.out.println();
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() +"\t---Usuarios: Error de lectura de mostrar usuario, el usuario con id ingresado no existe"+ "\n");

        }

    }

    public static void menuProductos() {
        System.out.println("01. Listar Productos.");
        System.out.println("02. Eliminar Producto.");
        System.out.println("03. Ver Producto.");
        System.out.println("04. Regresar al menu principal.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                mostrarProductos();
                break;
            case "2":
                eliminarProducto();
                break;
            case "3":
                verProducto();
                break;
            case "4":
                System.out.println("\n");
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }
    }

    public static void mostrarProductos() {
        System.out.println("ID\t\t Name\t\t description\t\t cost\t\t price\t\t ingredientes:\t\t name\t\t quantity\t\t units*");
        for (int i = 0; i < productosArr.size(); i++) {
            ingredientes[] meingredientes = productosArr.get(i).getIngredients();
            for (int j = 0; j < meingredientes.length; j++) {
                System.out.println("|" + productosArr.get(i).getId() + "\t\t" + productosArr.get(i).getName() + "\t\t" + productosArr.get(i).getDescription() + "\t\t" + productosArr.get(i).getCost() + "\t\t" + productosArr.get(i).getPrice() + "\t\t" + meingredientes[j].getName() + "\t\t" + meingredientes[j].getQuantity() + "\t\t" + meingredientes[j].getUnits());
            }
        }
    }

    public static void eliminarProducto() {
        try {
            System.out.println("Escriba el id del Producto que desea eliminar.");
            int eliminar = consola.nextInt();
            String productoEliminado = productosArr.get(eliminar-1).getName();
            productosArr.remove(eliminar - 1);
            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ usuarioLog+":"+" Elimino el producto "+'\u0022'+productoEliminado+'\u0022'+ " con id "+ eliminar+ "\n");
            System.out.println(usuarioLog+":"+" Elimino el producto "+'\u0022'+productoEliminado +'\u0022'+" con id "+ eliminar);
            System.out.println();
        }catch (Exception e) {
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "Productos: Error en la eliminación de producto, el id no existe." + "\n");

        }

    }

    public static void verProducto(){
        try {
            System.out.println("Escriba el id del producto que desea ver:");
            int ver = consola.nextInt();
            System.out.println("id: " +  productosArr.get(ver-1).getId());
            System.out.println("name: " +  productosArr.get(ver-1).getName());
            System.out.println("description: " +  productosArr.get(ver-1).getDescription());
            System.out.println("cost: " +  productosArr.get(ver-1).getCost());
            System.out.println("price: " +  productosArr.get(ver-1).getPrice());
            System.out.println("Ingredientes: ");
            ingredientes[] meingredientes = productosArr.get(ver-1).getIngredients();
            System.out.println("name: " + meingredientes[0].getName());
            System.out.println("quantity: " +meingredientes[0].getQuantity());
            System.out.println("units: " +meingredientes[0].getUnits());
        }catch (Exception e){
        Log.addToEndFile("errors.log.txt", " " + new Date().toString() +"\t---Productos: Error de lectura de mostrar producto, el producto con id ingresado no existe"+ "\n");
    }

    }

    public static void menuClientes() {
        System.out.println("01. Listar Clientes.");
        System.out.println("02. Eliminar Cliente.");
        System.out.println("03. Ver Cliente.");
        System.out.println("04. Regresar al menu principal.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                mostrarCliente();
                break;
            case "2":
                eliminarClienta();
                break;
            case "3":
                verCliente();
                break;
            case "4":
                System.out.println("\n");
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }

    }

    public static void mostrarCliente() {
        System.out.println("ID\t\t name\t\t\t address\t\t\tphone\t\t\tnit*");
        for (int i = 0; i < clientesArr.size(); i++) {

            System.out.println("|" + clientesArr.get(i).getId() + "\t\t" + clientesArr.get(i).getName() + "\t\t" + clientesArr.get(i).getAddress() + "\t\t" + clientesArr.get(i).getPhone() + "\t\t" + clientesArr.get(i).getNit() + "|");
        }
        System.out.println();
    }

    public static void eliminarClienta() {
        try {
            System.out.println("Escriba el id del cliente que desea eliminar.");
            int eliminar = consola.nextInt();
            String clienteEliminado= clientesArr.get(eliminar-1).getName();
            clientesArr.remove(eliminar - 1);
            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ usuarioLog+":"+" Elimino el cliente "+'\u0022'+clienteEliminado+'\u0022'+ " con id "+ eliminar+ "\n");
            System.out.println(usuarioLog+":"+" Elimino el cliente "+'\u0022'+clienteEliminado +'\u0022'+" con id "+eliminar+ "\n");

        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "Clientes: Error en la eliminación de clientes, el id no existe." + "\n");

        }
        }

    public static void verCliente() {
        try {
            System.out.println("Escriba el id del cliente que desea ver:");
            int ver = consola.nextInt();
            System.out.println("id: " + clientesArr.get(ver - 1).getId());
            System.out.println("name: " + clientesArr.get(ver - 1).getName());
            System.out.println("address: " + clientesArr.get(ver - 1).getAddress());
            System.out.println("phone: " + clientesArr.get(ver - 1).getPhone());
            System.out.println("nit: " + clientesArr.get(ver - 1).getNit());
            System.out.println();
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() +"\t---Clientes: Error de lectura de mostrar cliente, el cliente con id ingresado no existe"+ "\n");
        }

    }

    public static void menuFacturas() {
        System.out.println("01. Listar Facturas.");
        System.out.println("02. Eliminar Factura.");
        System.out.println("03. Ver Factura.");
        System.out.println("04. Regresar al menu principal.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                mostrarFacturas();
                break;
            case "2":
                eliminarFacturas();
                break;
            case "3":
                verFactura();
                break;
            case "4":
                System.out.println("\n");
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }

    }

    public static void mostrarFacturas() {
        System.out.println("*ID\t\t Client\t\t date\t\t products:\t\t name\t\t price*");
        for (int i = 0; i < facturasArr.size(); i++) {
            Productos[] misproductos = facturasArr.get(i).getProducts();
            for (int j = 0; j < misproductos.length; j++) {
                System.out.println("|" + facturasArr.get(i).getId() + "\t\t" + facturasArr.get(i).getClient() + "\t\t" + facturasArr.get(i).getDate() + "\t\t" + misproductos[j].getName() + "\t\t" + misproductos[j].getPrice() + "|");
            }
        }
    }

    public static void eliminarFacturas() {
        try {
            System.out.println("Escriba el id de la factura que desea eliminar.");
            int eliminar = consola.nextInt();
            int facturaEliminada= facturasArr.get(eliminar-1).getClient();
            facturasArr.remove(eliminar - 1);
            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ usuarioLog+":"+" Elimino la factura "+'\u0022'+facturaEliminada+'\u0022'+ " con id "+ eliminar+ "\n");
            System.out.println(usuarioLog+":"+" Elimino la factura "+'\u0022'+facturaEliminada +'\u0022'+" con id "+ eliminar);
            System.out.println();
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "Facturas: Error en la eliminación de facturas, el id no existe." + "\n");

        }

    }

    public static void verFactura() {
        try{
            System.out.println("Escriba el id de la factura que desea ver:");
            int ver = consola.nextInt();
            System.out.println("id: " + facturasArr.get(ver - 1).getId());
            System.out.println("name: " + facturasArr.get(ver - 1).getClient());
            System.out.println("description: " + facturasArr.get(ver - 1).getDate());
            System.out.println("Products: ");
            Productos[] misproductos = facturasArr.get(ver-1).getProducts();
            System.out.println("name: " + misproductos[0].getName());
            System.out.println("price: " + misproductos[0].getPrice());
        }catch (Exception e){
            Log.addToEndFile("errors.log.txt", " " + new Date().toString() +"\t---Facturas: Error de lectura de mostrar cliente, la factura con id ingresado no existe"+ "\n");
        }
    }

    public static void menuGuardarCambios() {
        System.out.println("01. JSON.");
        System.out.println("02. Binario.");
        System.out.println("03. Regresar al menu principal.");
        String menu_opciones = "";
        menu_opciones = consola.nextLine();

        switch (menu_opciones) {
            case "1":
                try{
                    Gson gsonR = new Gson();
                    String gsonRestau = gsonR.toJson(restauranteArr);
                    Files.writeOnFile("config.json", gsonRestau, false);

                    Gson gsonU = new Gson();
                    String gsonUsrs = gsonU.toJson(usuariosArr);
                    Files.writeOnFile("users.json", gsonUsrs, false);

                    Gson gsonP = new Gson();
                    String gsonPrcts = gsonP.toJson(productosArr);
                    Files.writeOnFile("products.json", gsonPrcts, false);

                    Gson gsonC = new Gson();
                    String gsonClts = gsonC.toJson(clientesArr);
                    Files.writeOnFile("clients.json", gsonClts, false);

                    Gson gsonF = new Gson();
                    String gsonFcts = gsonF.toJson(facturasArr);
                    Files.writeOnFile("invoices.json", gsonFcts, false);


                    
                }catch (Exception e){
                    System.out.println(e.getMessage() + "Error al Serializar");
                    
                }
                System.out.println("Serializado Exitosamente!!");

                break;
            case "2":
                try {
                    Gson gsonR = new Gson();
                    String gsonRestau = gsonR.toJson(restauranteArr);
                    Files.writeOnFile("config.json", gsonRestau, false);

                    Files.serialize("usuarios.ipcrm", usuariosArr);
                    Object conteUsrs = Files.deserialize("usuarios.ipcrm");
                    //System.out.println(conteUsrs);

                    Files.serialize("products.ipcrm", productosArr);
                    Object conteProdcts = Files.deserialize("products.ipcrm");
                    //System.out.println(conteProdcts);

                    Files.serialize("clients.ipcrm", clientesArr);
                    Object conteClts = Files.deserialize("clients.ipcrm");
                    //System.out.println(conteClts);

                    Files.serialize("invoices.ipcrm", facturasArr);
                    Object conteInvs = Files.deserialize("invoices.ipcrm");
                    //System.out.println(conteInvs);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "Error al Serializar");
                }
                System.out.println("Serializado Exitosamente!!");
                break;
            case "3":
                System.out.println("\n");
                break;
            default:
                System.out.println("Opción no valida\n");
                break;
        }
    }
//---------------------------------------------------------------------

    public static  void EditarRestaurante(){

    }
}





