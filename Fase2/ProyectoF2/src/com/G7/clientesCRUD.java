package com.G7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class clientesCRUD extends JFrame implements ActionListener, MouseListener {
    public   DefaultTableModel tabla;
    JFrame infClientes;
    JTable tablaClientes;
    JScrollPane sp;
    JButton b1,b2,b3,b4,b5;
    String select ="";
    EditarCliente editCliente=new EditarCliente();
    VerCliente seeCliente = new VerCliente();

    public clientesCRUD(){
        infClientes =new JFrame("Informacion clientes.");
        infClientes.setBounds(700, 400, 600, 400);
        infClientes.setLayout(null);
        infClientes.getContentPane().setBackground(new Color(44, 44, 84));
        infClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infClientes.setResizable(false);
        infClientes.setVisible(true);

        tabla = new DefaultTableModel();
        tablaClientes = new JTable(tabla);
        tabla.addColumn("Id");
        tabla.addColumn("Name");
        tabla.addColumn("Address");
        tabla.addColumn("phone");
        tabla.addColumn("Nit");
        for (int i = 0; i < Main.clientesArr.size(); i++) {

            if(Main.clientesArr.get(i) != null){
                tabla.addRow(Main.clientesArr.get(i).toArreglo());
            }
        }

        tablaClientes.setBounds(25,25,525,200);
        tablaClientes.setModel(tabla);
        tablaClientes.addMouseListener(this);

        sp = new JScrollPane(tablaClientes);
        sp.setBounds(25,25,525,200);
        infClientes.add(sp);
        sp.setVisible(true);

        b1 = new JButton("Editar");
        b1.setBounds(200,260,166,30);
        b1.setVisible(true);
        b1.addActionListener(this);
        infClientes.add(b1);

        b2 = new JButton("Crear");
        b2.setBounds(25,260,166,30);
        b2.setVisible(true);
        b2.addActionListener(this);
        infClientes.add(b2);

        b3 = new JButton("Eliminar");
        b3.setBounds(375,260,166,30);
        b3.setVisible(true);
        b3.addActionListener(this);
        infClientes.add(b3);

        b5 = new JButton("Visualizar");
        b5.setBounds(75,300,166,30);
        b5.setVisible(true);
        b5.addActionListener(this);
        infClientes.add(b5);


        b4 = new JButton("Regresar");
        b4.setBounds(250,300,200,30);
        b4.setVisible(true);
        b4.addActionListener(this);
        infClientes.add(b4);

    }

    public void borrarCliente(String index) {
        int valor= Integer.parseInt(index);
        for (int i = 0; i < Main.clientesArr.size(); i++) {
            if (Main.clientesArr.get(i).getId() == valor) {
                Main.clientesArr.remove(i);
            }
        }
        Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user + ": Elimino al cliente con id: " + valor + "\n");
        clientesCRUD clientesCRUD= new clientesCRUD();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2){
            agregarCliente agreCliente= new agregarCliente();
            infClientes.dispose();
        }
        if (e.getSource() == b1){
            //ventana.dispose();
            if (!select.equals("")) {
                editCliente.EditarCliente("actualizar", select);
                infClientes.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para editar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " No se seleccionó ningún registro a editar." + "\n");
            }
        }
        if (e.getSource() == b3){
            if (!select.equals("")) {
                int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente con id: "+select+" ?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    borrarCliente(select);
                    infClientes.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para eliminar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " No se seleccionó ningún registro a eliminar." + "\n");
            }
        }
        if(e.getSource() == b4){
            infClientes.dispose();
            MenuCRUD nuevo = new MenuCRUD();
        }
        if (e.getSource() == b5){
            if (!select.equals("")) {
                seeCliente.VerCliente("visualizar", select);
                infClientes.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para visualizar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " No se seleccionó ningún registro a visualizar." + "\n");
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String row = String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),0));
        select = row;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
