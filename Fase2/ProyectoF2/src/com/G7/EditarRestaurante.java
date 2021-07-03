package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EditarRestaurante extends JFrame implements ActionListener {
    JFrame ventana;
    JButton agregar,regresar;
    JLabel nombre,direccion,telefono;
    JTextField nombreTextField,direccionTextField,telefonoTextField;
    String nombreGuardado,direccionGuardado;
    int phone;

    public EditarRestaurante(){

        ventana =new JFrame("Editar Restaurante");
        ventana.setBounds(700, 300, 600, 300);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        nombre= new JLabel("Restaurante: ");
        nombre.setFont(new Font("arial", Font.ITALIC, 15));
        nombre.setBounds(25, 40, 100, 30);
        nombre.setVisible(true);
        ventana.add(nombre);

        direccion= new JLabel("Dirección: ");
        direccion.setFont(new Font("arial", Font.ITALIC, 15));
        direccion.setBounds(25, 85, 100, 30);
        direccion.setVisible(true);
        ventana.add(direccion);

        telefono= new JLabel("Teléfono: ");
        telefono.setFont(new Font("arial", Font.ITALIC, 15));
        telefono.setBounds(25, 125, 100, 30);
        telefono.setVisible(true);
        ventana.add(telefono);

        nombreTextField=new JTextField();
        nombreTextField.setBounds(150,40,400,30);
        nombreTextField.setVisible(true);
        ventana.add(nombreTextField);

        direccionTextField=new JTextField();
        direccionTextField.setBounds(150,80,400,30);
        direccionTextField.setVisible(true);
        ventana.add(direccionTextField);

        telefonoTextField=new JTextField();
        telefonoTextField.setBounds(150,120,400,30);
        telefonoTextField.setVisible(true);
        ventana.add(telefonoTextField);

        agregar = new JButton("Editar");
        agregar.setBounds(180,170,200,30);
        agregar.setVisible(true);
        agregar.addActionListener(this);
        ventana.add(agregar);

        regresar = new JButton("Regresar");
        regresar.setBounds(20,200,140,30);
        regresar.setVisible(true);
        regresar.addActionListener(this);
        ventana.add(regresar);

        nombreTextField.setText(Main.restauranteArr.get(0).getName());
        direccionTextField.setText(Main.restauranteArr.get(0).getAddress());
        telefonoTextField.setText(String.valueOf(Main.restauranteArr.get(0).getPhone()));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == regresar){
            ventana.dispose();
            InfRestaurante infRestaurante=new InfRestaurante();
        }
        if(e.getSource() == agregar){
            nombreGuardado=nombreTextField.getText().trim();
            direccionGuardado= direccionTextField.getText().trim();
            try {
                phone=Integer.parseInt(telefonoTextField.getText().trim());
                boolean flag=false;
                String usuarioRepetido="" ;

                if (nombreGuardado.equals("")  || direccionGuardado.equals("")||telefonoTextField.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "RESTAURANTE:" + " Uno o varios campos del registro están vacios." + "\n");

                }else{
                        Main.restauranteArr.get(0).setName(nombreGuardado);
                        Main.restauranteArr.get(0).setAddress(direccionGuardado);
                        Main.restauranteArr.get(0).setPhone(phone);
                        JOptionPane.showMessageDialog(this, "El Restaurante "+'\u0022'+ nombreGuardado+'\u0022'+" ha sido editado.");
                        ventana.dispose();
                        InfRestaurante infRestaurante=new InfRestaurante();
                        Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user+ ": Ha editado el restaurante: " +nombreGuardado+   "\n");

                }
            }catch (Exception a){
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " Error en editar usuarios, campos incompletos" + "\n");

            }
        }

    }
}
