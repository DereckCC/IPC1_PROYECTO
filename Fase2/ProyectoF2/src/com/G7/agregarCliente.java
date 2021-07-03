package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class agregarCliente extends JFrame implements ActionListener {

    JFrame ventana;
    JButton b1, b2;
    JLabel titulo, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    String name,addres,nit;
    int identificador,phone;


    public agregarCliente() {
        ventana = new JFrame("Agregar Cliente");
        ventana.setBounds(700, 400, 500, 450);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo = new JLabel("Agregar Cliente");
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

        l3 = new JLabel("Dirección: ");
        l3.setFont(new Font("arial", Font.ITALIC, 15));
        l3.setBounds(40, 180, 400, 30);
        l3.setVisible(true);
        ventana.add(l3);

        l4 = new JLabel("Teléfono: ");
        l4.setFont(new Font("arial", Font.ITALIC, 15));
        l4.setBounds(40, 240, 400, 30);
        l4.setVisible(true);
        ventana.add(l4);


        l5 = new JLabel("Nit: ");
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


        b1 = new JButton("Agregar");
        b1.setBounds(250, 350, 180, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        ventana.add(b1);

        b2 = new JButton("Regresar");
        b2.setBounds(40, 350, 180, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        ventana.add(b2);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try {
                boolean flag=false;
                boolean flag2=false;
                try {
                    identificador=Integer.parseInt(t1.getText().trim());
                    phone=Integer.parseInt(t4.getText().trim());
                    flag=false;
                }catch (Exception ae){
                    flag=true;
                }
                if (flag){
                    JOptionPane.showMessageDialog(this, "La casilla de ID y Teléfono solo aceptan números. ");
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " La casilla de ID y teléfono solo acepta números." + "\n");
                }else {
                    name=t2.getText().trim();
                    addres=t3.getText().trim();
                    nit=t5.getText().trim();
                    int usuarioRepetido=0 ;
                    if (name.equals("")  || addres.equals("")||nit.equals("")||t1.getText().trim().equals("")||t4.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                        Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " Uno o varios campos del registro están vacios." + "\n");

                    }else{
                        for(int i=0 ;i<Main.clientesArr.size(); i++){
                            if (identificador==Main.clientesArr.get(i).getId()) {
                                flag2 = true;
                                usuarioRepetido = Main.clientesArr.get(i).getId();
                                break;
                            }
                        }
                        if (flag2) {
                            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " El cliente con id " + usuarioRepetido + " ya existe,se omitió el registro." + "\n");
                            JOptionPane.showMessageDialog(this, "El cliente con id "+usuarioRepetido+" ya esta registrado, intente con otro ID de cliente.");

                        }else {
                            Clientes nuevo = new Clientes(identificador, name,addres,phone,nit);
                            Main.clientesArr.add(nuevo);
                            ventana.dispose();
                            Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user+ ": Ha Creado al Cliente  " +name+" por medio de interfaz gráfica"+ "\n");
                            JOptionPane.showMessageDialog(this, "El cliente "+name+" ha sido agregado.");
                            clientesCRUD clientesCRUD= new clientesCRUD();
                        }
                    }
                }

            }catch (Exception a){
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "CLIENTES:" + " Error en registrar nuevos clientes, campos incompletos" + "\n");
            }
        }
        if(e.getSource() == b2){
            ventana.dispose();
            clientesCRUD clientesCRUD= new clientesCRUD();
        }
    }
}