package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VerUsuario extends JFrame implements ActionListener {

    JFrame ventana;
    JButton agregar,regresar;
    JLabel titulo,nombre,passwordJlabel;
    JTextField nombreTextField;
    JPasswordField passwordTextField;
    String usuario,password;
    String typeMain;
    String indexMain;


    public void VerUsuario(String type, String index){
        ventana =new JFrame("Visualizar Usuarios");
        ventana.setBounds(700, 400, 500, 300);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo= new JLabel("Visualizar Usuario");
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

        regresar = new JButton("Regresar");
        regresar.setBounds(190,200,140,30);
        regresar.setVisible(true);
        regresar.addActionListener(this);
        ventana.add(regresar);


        typeMain = type;
        indexMain = index;

        if (type == "visualizar") {

            for (int i=0;i<Main.usuariosArr.size();i++){
                if (indexMain.equals(Main.usuariosArr.get(i).getUsername())){
                    nombreTextField.setText(String.valueOf(Main.usuariosArr.get(i).getUsername()));
                    nombreTextField.disable();
                    passwordTextField.setText(Main.usuariosArr.get(i).getPassword());
                    passwordTextField.disable();
                    break;
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == regresar){
            ventana.dispose();
            UsuarioCrud usuarioCrud=new UsuarioCrud();
        }
    }
}

