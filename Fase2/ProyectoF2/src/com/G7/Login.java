package com.G7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class Login extends JFrame implements ActionListener{

    public static String user;
    JFrame Ventana;
    String  psw, hola, adios;
    JLabel l1, l2, l3,l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    public Login(){
    Ventana =new JFrame("Inicio de sesión");
    Ventana.setBounds(700, 400, 500, 250);
    Ventana.setLayout(null);
    Ventana.getContentPane().setBackground(new Color(44, 44, 84));
    Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Ventana.setResizable(false);
    Ventana.setVisible(true);

    l1 = new JLabel("Bienvenido al inicio de sesión");
    l1.setFont(new Font("arial", Font.BOLD, 20));
    l1.setBounds(100, 10, 400, 30);
    l1.setVisible(true);
    Ventana.add(l1);

    l2 = new JLabel("Usuario:");
    l2.setFont(new Font("arial", Font.ITALIC, 15));
    l2.setBounds(25,50 , 400, 50);
    l2.setVisible(true);
    Ventana.add(l2);

    l3 = new JLabel("Contraseña:");
    l3.setFont(new Font("arial", Font.ITALIC, 15));
    l3.setBounds(25,100 , 400, 50);
    l3.setVisible(true);
    Ventana.add(l3);

    t1 = new JTextField();
    t1.setBounds(125, 60, 300, 30);
    t1.setVisible(true);
    Ventana.add(t1);

    t2 = new JPasswordField();
    t2.setBounds(125,110,300,30);
    t2.setVisible(true);
    Ventana.add(t2);

    b1 = new JButton("Inciciar Sesión");
    b1.setBounds(200,150,150,30);
    b1.setVisible(true);
    Ventana.add(b1);
        b1.addActionListener(this);

    repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {


                System.out.println("Tocaste el boton de Incio de Sesión");
                user = t1.getText();
                psw = t2.getText();
                System.out.println("EL USUARIO QUE INGRESO FUE : " + user);
                System.out.println("LA CONTRASEÑA ES : " + psw);
                boolean flag=false;
                if (t1.getText().equals("")  || t2.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                }else{
                    for (int i = 0; i < Main.usuariosArr.size(); i++) {

                        hola = Main.usuariosArr.get(i).getUsername();
                        adios = Main.usuariosArr.get(i).getPassword();
                        if (t1.getText().equals(hola) && t2.getText().equals(adios)) {
                            Ventana.dispose();
                            JOptionPane.showMessageDialog(this, "Bienvenido.");
                            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ user+":"+" Inicio de Sesión exitoso"+ "\n");
                            MenuCRUD nuevo = new MenuCRUD();
                            flag=true;
                        }
                    }
                        if(!flag){
                            Log.addToEndFile("log.log.txt", " " + new Date().toString() +"\t---"+ user+":"+" Inicio de Sesión fallido"+ "\n");
                            Log.addToEndFile("errors.log.txt", " " + new Date().toString() +"\t---ERROR DE LOGIN: Las credenciales son incorrectas, vuelva a intentarlo"+ "\n");
                            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
                        }
                }
            }catch (Exception a){
                JOptionPane.showMessageDialog(this, "Algo salio mal.");
            }
        }
    }
}
