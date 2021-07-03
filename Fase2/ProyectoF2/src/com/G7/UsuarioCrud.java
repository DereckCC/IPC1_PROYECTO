package com.G7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class UsuarioCrud extends JFrame implements ActionListener, MouseListener {
    public   DefaultTableModel tabla;
    JFrame ventana;
    JLabel titulo;
    JTable tablaUsuario;
    JScrollPane scroll;
    JButton regresar, editar,eliminar,agregar,visualizar;
    String select = "";
    EditarUsuarios editUsuarios= new EditarUsuarios();
    VerUsuario seeUsuario = new VerUsuario();

    public UsuarioCrud(){

        ventana =new JFrame("CRUD Usuarios");
        ventana.setBounds(700, 400, 600, 390);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo= new JLabel("CRUD Usuarios");
        titulo.setFont(new Font("arial", Font.BOLD, 20));
        titulo.setBounds(80, 10, 400, 30);
        titulo.setVisible(true);
        ventana.add(titulo);

        tabla = new DefaultTableModel();
        tablaUsuario = new JTable(tabla);
        tabla.addColumn("Nombre de usuario");
        for (int i = 0; i < Main.usuariosArr.size(); i++) {
            if(Main.usuariosArr.get(i) != null){
                tabla.addRow(Main.usuariosArr.get(i).toArreglo());
            }
        }
        tablaUsuario.setBounds(25,55,525,200);
        tablaUsuario.setModel(tabla);
        tablaUsuario.addMouseListener(this);
        ventana.add(tablaUsuario);

        scroll = new JScrollPane(tablaUsuario);
        scroll.setBounds(25,55,525,200);
        ventana.add(scroll);
        scroll.setVisible(true);

        agregar = new JButton("Agregar");
        agregar.setBounds(25,260,166,30);
        agregar.setVisible(true);
        agregar.addActionListener(this);
        ventana.add(agregar);

        editar = new JButton("Editar");
        editar.setBounds(200,260,166,30);
        editar.setVisible(true);
        editar.addActionListener(this);
        ventana.add(editar);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(375,260,166,30);
        eliminar.setVisible(true);
        eliminar.addActionListener(this);
        ventana.add(eliminar);

        visualizar = new JButton("Visualizar");
        visualizar.setBounds(75,300,166,30);
        visualizar.setVisible(true);
        visualizar.addActionListener(this);
        ventana.add(visualizar);

        regresar = new JButton("Regresar");
        regresar.setBounds(250,300,200,30);
        regresar.setVisible(true);
        regresar.addActionListener(this);
        ventana.add(regresar);

    }

    public void borrarUsuario(String index) {
        for (int i = 0; i < Main.usuariosArr.size(); i++) {
            if (Main.usuariosArr.get(i).getUsername() == index) {
                Main.usuariosArr.remove(i);
            }
        }
        Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user + ": Elimino al usuario: " + index + "\n");
        UsuarioCrud usuarioCrud= new UsuarioCrud();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregar){
            AgregarUsuarios agregarUsuarios= new AgregarUsuarios();
            ventana.dispose();
        }
        if (e.getSource() == visualizar){
            if (!select.equals("")) {
                seeUsuario.VerUsuario("visualizar", select);
                ventana.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para visualizar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " No se seleccionó ningún registro a visualizar." + "\n");
            }
        }
        if (e.getSource() == editar){
            //ventana.dispose();
            if (!select.equals("")) {
                editUsuarios.EditarUsuarios("actualizar", select);
                ventana.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para editar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " No se seleccionó ningún registro a editar." + "\n");
            }
        }
        if (e.getSource() == eliminar){
            if (!select.equals("")) {
                int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario: "+select+" ?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    borrarUsuario(select);
                    ventana.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para eliminar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " No se seleccionó ningún registro a eliminar." + "\n");
            }
        }
        if(e.getSource() == regresar){
            ventana.dispose();
            MenuCRUD nuevo = new MenuCRUD();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String row = String.valueOf(tablaUsuario.getValueAt(tablaUsuario.getSelectedRow(),0));
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
