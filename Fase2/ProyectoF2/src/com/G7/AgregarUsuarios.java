package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AgregarUsuarios extends JFrame implements ActionListener {
    JFrame ventana;
    JButton agregar,regresar;
    JLabel titulo,nombre,passwordJlabel;
    JTextField nombreTextField;
    JPasswordField passwordTextField;
    String usuario,password;

    public AgregarUsuarios(){

        ventana =new JFrame("Agregar Usuarios");
        ventana.setBounds(700, 400, 500, 300);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo= new JLabel("Agregar Usuarios");
        titulo.setFont(new Font("arial", Font.BOLD, 20));
        titulo.setBounds(180, 10, 400, 30);
        titulo.setVisible(true);
        ventana.add(titulo);

        nombreTextField= new JTextField();
        nombreTextField.setBounds(140, 60, 290, 30);
        nombreTextField.setVisible(true);
        ventana.add(nombreTextField);

        passwordTextField= new JPasswordField();
        passwordTextField.setBounds(140, 120, 290, 30);
        passwordTextField.setVisible(true);
        ventana.add(passwordTextField);

        nombre= new JLabel("Nombre: ");
        nombre.setFont(new Font("arial", Font.ITALIC, 15));
        nombre.setBounds(40, 60, 400, 30);
        nombre.setVisible(true);
        ventana.add(nombre);

        passwordJlabel= new JLabel("Contraseña: ");
        passwordJlabel.setFont(new Font("arial", Font.ITALIC, 15));
        passwordJlabel.setBounds(40, 120, 400, 30);
        passwordJlabel.setVisible(true);
        ventana.add(passwordJlabel);

        agregar = new JButton("Registrar");
        agregar.setBounds(180,170,200,30);
        agregar.setVisible(true);
        agregar.addActionListener(this);
        ventana.add(agregar);

        regresar = new JButton("Regresar");
        regresar.setBounds(20,200,140,30);
        regresar.setVisible(true);
        regresar.addActionListener(this);
        ventana.add(regresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregar){
            try {

                usuario=nombreTextField.getText().trim();
                password= passwordTextField.getText().trim();
                boolean flag=false;
                String usuarioRepetido="" ;

                if (usuario.equals("")  || password.equals("")){
                    JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " Uno o varios campos del registro están vacios." + "\n");

                }else{
                    for(int i=0 ;i<Main.usuariosArr.size(); i++){
                        if (usuario.equals(Main.usuariosArr.get(i).getUsername())) {
                            flag = true;
                            usuarioRepetido = usuario;
                            break;
                        }
                    }
                    if (flag) {
                        Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " El usuario " + usuarioRepetido + " ya existe,se omitió el registro." + "\n");
                        JOptionPane.showMessageDialog(this, "El usuario "+usuarioRepetido+" ya esta registrado, intente con otro nombre de usuario.");

                    }else {
                        Usuarios nuevo = new Usuarios(usuario, password);
                        Main.usuariosArr.add(nuevo);
                        ventana.dispose();
                        Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user+ ": Ha Creado al usuario " +usuario+" por medio de interfaz gráfica"+ "\n");
                        JOptionPane.showMessageDialog(this, "El usuario "+usuario+" ha sido agregado.");
                        UsuarioCrud usuarioCrud= new UsuarioCrud();
                    }

                }

            }catch (Exception a){
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "USUARIOS:" + " Error en registrar nuevos usuarios, campos incompletos" + "\n");

            }
        }

        if(e.getSource() == regresar){
            ventana.dispose();
            UsuarioCrud usuarioCrud= new UsuarioCrud();
        }

    }
}
