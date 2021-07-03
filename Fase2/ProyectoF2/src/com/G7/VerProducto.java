package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VerProducto extends JFrame implements ActionListener {
    JFrame ventana;
    JButton b1, b2;
    JLabel titulo, l1, l2, l3, l4, l5, titulo2, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    String typeMain, name, description, nameIngredient, units;
    int indexMain, identificador, quantity;
    Double cost, price;
    ingredientes[] nuevo2;

    public void VerProducto(String type, String index) {
        ventana = new JFrame("Visualizar Producto");
        ventana.setBounds(700, 250, 500, 700);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo = new JLabel("Visualizar Producto");
        titulo.setFont(new Font("arial", Font.BOLD, 20));
        titulo.setBounds(180, 10, 400, 30);
        titulo.setVisible(true);
        ventana.add(titulo);

        l1 = new JLabel("Id: ");
        l1.setFont(new Font("arial", Font.ITALIC, 15));
        l1.setBounds(40, 60, 400, 30);
        l1.setVisible(true);
        ventana.add(l1);

        l2 = new JLabel("Nombre: ");
        l2.setFont(new Font("arial", Font.ITALIC, 15));
        l2.setBounds(40, 120, 400, 30);
        l2.setVisible(true);
        ventana.add(l2);

        l3 = new JLabel("Descripción: ");
        l3.setFont(new Font("arial", Font.ITALIC, 15));
        l3.setBounds(40, 180, 400, 30);
        l3.setVisible(true);
        ventana.add(l3);

        l4 = new JLabel("Costo: ");
        l4.setFont(new Font("arial", Font.ITALIC, 15));
        l4.setBounds(40, 240, 400, 30);
        l4.setVisible(true);
        ventana.add(l4);

        l5 = new JLabel("Precio: ");
        l5.setFont(new Font("arial", Font.ITALIC, 15));
        l5.setBounds(40, 300, 400, 30);
        l5.setVisible(true);
        ventana.add(l5);

        titulo2 = new JLabel("Ingrediente");
        titulo2.setFont(new Font("arial", Font.BOLD, 20));
        titulo2.setBounds(180, 360, 400, 30);
        titulo2.setVisible(true);
        ventana.add(titulo2);

        l6 = new JLabel("Nombre: ");
        l6.setFont(new Font("arial", Font.ITALIC, 15));
        l6.setBounds(40, 420, 400, 30);
        l6.setVisible(true);
        ventana.add(l6);

        l7 = new JLabel("Cantidad: ");
        l7.setFont(new Font("arial", Font.ITALIC, 15));
        l7.setBounds(40, 480, 400, 30);
        l7.setVisible(true);
        ventana.add(l7);

        l8 = new JLabel("Unidades: ");
        l8.setFont(new Font("arial", Font.ITALIC, 15));
        l8.setBounds(40, 540, 400, 30);
        l8.setVisible(true);
        ventana.add(l8);


        t1 = new JTextField();
        t1.setBounds(140, 60, 290, 30);
        t1.setVisible(true);
        ventana.add(t1);

        t2 = new JTextField();
        t2.setBounds(140, 120, 290, 30);
        t2.setVisible(true);
        ventana.add(t2);

        t3 = new JTextField();
        t3.setBounds(140, 180, 290, 30);
        t3.setVisible(true);
        ventana.add(t3);

        t4 = new JTextField();
        t4.setBounds(140, 240, 290, 30);
        t4.setVisible(true);
        ventana.add(t4);

        t5 = new JTextField();
        t5.setBounds(140, 300, 290, 30);
        t5.setVisible(true);
        ventana.add(t5);

        t6 = new JTextField();
        t6.setBounds(140, 420, 290, 30);
        t6.setVisible(true);
        ventana.add(t6);

        t7 = new JTextField();
        t7.setBounds(140, 480, 290, 30);
        t7.setVisible(true);
        ventana.add(t7);

        t8 = new JTextField();
        t8.setBounds(140, 540, 290, 30);
        t8.setVisible(true);
        ventana.add(t8);


        b2 = new JButton("Regresar");
        b2.setBounds(180, 600, 180, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        ventana.add(b2);

        typeMain = type;
        indexMain = Integer.parseInt(index);

        if (type == "visualizar") {

            for (int i = 0; i < Main.productosArr.size(); i++) {
                if (indexMain == Main.productosArr.get(i).getId()) {
                    t1.setText(String.valueOf(Main.productosArr.get(i).getId()));
                    t1.disable();
                    t2.setText(Main.productosArr.get(i).getName());
                    t2.disable();
                    t3.setText(Main.productosArr.get(i).getDescription());
                    t3.disable();
                    t4.setText(String.valueOf(Main.productosArr.get(i).getCost()));
                    t4.disable();
                    t5.setText(String.valueOf(Main.productosArr.get(i).getPrice()));
                    t5.disable();
                    nuevo2 = Main.productosArr.get(i).getIngredients();
                    t6.setText(nuevo2[0].getName());
                    t6.disable();
                    t7.setText(String.valueOf(nuevo2[0].getQuantity()));
                    t7.disable();
                    t8.setText(nuevo2[0].getUnits());
                    t8.disable();
                    break;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            ventana.dispose();
            ProductoCRUD productoCRUD = new ProductoCRUD();
        }
    }
}
