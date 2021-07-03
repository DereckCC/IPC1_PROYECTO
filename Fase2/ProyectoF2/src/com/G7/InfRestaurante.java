package com.G7;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class InfRestaurante extends JFrame implements ActionListener {
  public   DefaultTableModel tabla;
  JFrame InfRestaurante;
  JTable tablaRestaurante;
  JScrollPane sp;
  JButton b1,b2;
    public InfRestaurante(){
        InfRestaurante =new JFrame("Informacion Restaurante.");
        InfRestaurante.setBounds(700, 400, 600, 350);
        InfRestaurante.setLayout(null);
        InfRestaurante.getContentPane().setBackground(new Color(44, 44, 84));
        InfRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InfRestaurante.setResizable(false);
        InfRestaurante.setVisible(true);

        tabla = new DefaultTableModel();
        tablaRestaurante = new JTable(tabla);
        tabla.addColumn("name");
        tabla.addColumn("address");
        tabla.addColumn("phone");
        tabla.addColumn("load");
        for (int i = 0; i < Main.restauranteArr.size(); i++) {
            if(Main.restauranteArr.get(i) != null){
                tabla.addRow(Main.restauranteArr.get(i).toArreglo());
            }
        }

        tablaRestaurante.setBounds(25,25,525,200);
        tablaRestaurante.setModel(tabla);

        sp = new JScrollPane(tablaRestaurante);
        sp.setBounds(25,25,525,200);
        InfRestaurante.add(sp);
        sp.setVisible(true);

        b1 = new JButton("Editar");
        b1.setBounds(25,250,250,30);
        b1.setVisible(true);
        b1.addActionListener(this);
        InfRestaurante.add(b1);

        b2 = new JButton("Regresar");
        b2.setBounds(300,250,250,30);
        b2.setVisible(true);
        b2.addActionListener(this);
        InfRestaurante.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2){
            InfRestaurante.dispose();
            MenuCRUD nuevo = new MenuCRUD();
        }
        if(e.getSource() == b1){
            InfRestaurante.dispose();
            EditarRestaurante editarRestaurante=new EditarRestaurante();
        }
    }
}
