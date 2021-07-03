package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VerFactura extends JFrame implements ActionListener {
    JFrame ventana;
    JButton b2;
    JLabel titulo, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    String typeMain, name, description, nameIngredient, units;
    int indexMain, identificador, quantity;
    Double precio;
    Productos[] nuevo2;


    public void VerFactura(String type, String index) {
        ventana = new JFrame("Visualizar Factura");
        ventana.setBounds(700, 400, 500, 450);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo = new JLabel("Visualizar Factura");
        titulo.setFont(new Font("arial", Font.BOLD, 20));
        titulo.setBounds(180, 10, 400, 30);
        titulo.setVisible(true);
        ventana.add(titulo);

        l1 = new JLabel("Id: ");
        l1.setFont(new Font("arial", Font.ITALIC, 15));
        l1.setBounds(40, 60, 400, 30);
        l1.setVisible(true);
        ventana.add(l1);

        l2 = new JLabel("ID Cliente: ");
        l2.setFont(new Font("arial", Font.ITALIC, 15));
        l2.setBounds(40, 120, 400, 30);
        l2.setVisible(true);
        ventana.add(l2);

        l3 = new JLabel("Fecha: ");
        l3.setFont(new Font("arial", Font.ITALIC, 15));
        l3.setBounds(40, 180, 400, 30);
        l3.setVisible(true);
        ventana.add(l3);

        l4 = new JLabel("Nombre: ");
        l4.setFont(new Font("arial", Font.ITALIC, 15));
        l4.setBounds(40, 240, 400, 30);
        l4.setVisible(true);
        ventana.add(l4);


        l5 = new JLabel("Precio: ");
        l5.setFont(new Font("arial", Font.ITALIC, 15));
        l5.setBounds(40, 300, 400, 30);
        l5.setVisible(true);
        ventana.add(l5);

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


        b2 = new JButton("Regresar");
        b2.setBounds(145, 375, 180, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        ventana.add(b2);

        typeMain = type;
        indexMain = Integer.parseInt(index);

        if (type == "visualizar") {

            for (int i = 0; i < Main.facturasArr.size(); i++) {
                if (indexMain == Main.facturasArr.get(i).getId()) {
                    t1.setText(String.valueOf(Main.facturasArr.get(i).getId()));
                    t1.disable();
                    t2.setText(String.valueOf(Main.facturasArr.get(i).getClient()));
                    t2.disable();
                    t3.setText(Main.facturasArr.get(i).getDate());
                    t3.disable();
                    nuevo2 = Main.facturasArr.get(i).getProducts();
                    t4.setText(nuevo2[0].getName());
                    t4.disable();
                    t5.setText(String.valueOf(nuevo2[0].getPrice()));
                    t5.disable();
                    break;
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            ventana.dispose();
            FacturasCRUD facturasCRUD = new FacturasCRUD();
        }
    }
}
