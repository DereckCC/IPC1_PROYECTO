package com.G7;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuCRUD extends JFrame implements ActionListener {
    JFrame menuc;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JLabel l1;

    public MenuCRUD() {
        menuc = new JFrame("Menú");
        menuc.setBounds(700, 400, 600, 300);
        menuc.setLayout(null);
        menuc.getContentPane().setBackground(new Color(44, 44, 84));
        menuc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuc.setResizable(false);
        menuc.setVisible(true);

        l1 = new JLabel("Bienvenido al Menú");
        l1.setFont(new Font("arial", Font.BOLD, 20));
        l1.setBounds(200, 10, 400, 30);
        l1.setVisible(true);
        menuc.add(l1);

        b1 = new JButton("Información del Restaurante");
        b1.setBounds(25, 50, 250, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        menuc.add(b1);

        b2 = new JButton("CRUD Usuarios");
        b2.setBounds(300, 50, 250, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        menuc.add(b2);

        b3 = new JButton("CRUD Clientes");
        b3.setBounds(25, 100, 250, 30);
        b3.setVisible(true);
        b3.addActionListener(this);
        menuc.add(b3);

        b4 = new JButton("CRUD Productos");
        b4.setBounds(300, 100, 250, 30);
        b4.setVisible(true);
        b4.addActionListener(this);
        menuc.add(b4);

        b5 = new JButton("Facturas");
        b5.setBounds(25, 150, 250, 30);
        b5.setVisible(true);
        b5.addActionListener(this);
        menuc.add(b5);

        b6 = new JButton("Serializar Datos");
        b6.setBounds(300, 150, 250, 30);
        b6.setVisible(true);
        b6.addActionListener(this);
        menuc.add(b6);

        b7 = new JButton("Regresar");
        b7.setBounds(25, 200, 250, 30);
        b7.setVisible(true);
        b7.addActionListener(this);
        menuc.add(b7);

        b8 = new JButton("Salir");
        b8.setBounds(300, 200, 250, 30);
        b8.setVisible(true);
        b8.addActionListener(this);
        menuc.add(b8);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            menuc.dispose();
            InfRestaurante nuevo = new InfRestaurante();
        }
        if (e.getSource() == b2) {
            menuc.dispose();
            UsuarioCrud usuarioCrud = new UsuarioCrud();
        }
        if (e.getSource() == b3) {
            menuc.dispose();
            clientesCRUD clientesCRUD = new clientesCRUD();
        }
        if (e.getSource() == b4) {
            menuc.dispose();
            ProductoCRUD productoCRUD = new ProductoCRUD();
        }
        if (e.getSource() == b5) {
            menuc.dispose();
            FacturasCRUD facturasCRUD = new FacturasCRUD();
        }
        if (e.getSource() == b6) {

            Gson gsonR = new Gson();
            String gsonRestau = gsonR.toJson(Main.restauranteArr);
            char[] datos = gsonRestau.toCharArray();
            String contenido = String.valueOf(datos);
            String cont = contenido.replace("[", "");
            String cont2 = cont.substring(0, cont.length() - 1);
            Files.writeOnFile("config.json", cont2, false);


            Gson gsonU = new Gson();
            String gsonUsrs = gsonU.toJson(Main.usuariosArr);
            Files.writeOnFile("users.json", gsonUsrs, false);

            Gson gsonP = new Gson();
            String gsonPrcts = gsonP.toJson(Main.productosArr);
            Files.writeOnFile("products.json", gsonPrcts, false);

            Gson gsonC = new Gson();
            String gsonClts = gsonC.toJson(Main.clientesArr);
            Files.writeOnFile("clients.json", gsonClts, false);

            Gson gsonF = new Gson();
            String gsonFcts = gsonF.toJson(Main.facturasArr);
            Files.writeOnFile("invoices.json", gsonFcts, false);


            JOptionPane.showMessageDialog(this, "Serializado Exitosamente");
        }
        if (e.getSource() == b7) {
            menuc.dispose();
            Login nuevo = new Login();
        }

        if (e.getSource() == b8) {
            System.out.println("Bye Bye :)");
            System.exit(1);
        }
    }
}
