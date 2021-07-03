package com.G7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AgregarFactura extends JFrame implements ActionListener{
    JFrame ventana;
    JButton b1, b2;
    JLabel titulo, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    String date,name;
    Double precio;
    Productos[] products;
    int identificador,idCliente;


    public AgregarFactura(){
        ventana = new JFrame("Agregar Factura");
        ventana.setBounds(700, 400, 500, 450);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo = new JLabel("Agregar Factura");
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
                boolean flag3=false;
                boolean flag4=false;
                try {
                    identificador=Integer.parseInt(t1.getText().trim());
                    idCliente=Integer.parseInt(t2.getText().trim());
                    precio=Double.parseDouble(t5.getText().trim());
                    flag=false;
                }catch (Exception ae){
                    flag=true;
                }
                if (flag){
                    JOptionPane.showMessageDialog(this, "La casilla de ID factura,ID cliente y precio solo aceptan números. ");
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " La casilla ID factura,ID cliente y precio solo acepta números." + "\n");
                }else {
                    date=t3.getText().trim();
                    name=t4.getText().trim();
                    int usuarioRepetido=0 ;
                    if (name.equals("")  || date.equals("")|| t5.getText().trim().equals("")||t1.getText().trim().equals("")||t2.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                        Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " Uno o varios campos del registro están vacios." + "\n");

                    }else{
                        for(int i=0 ;i<Main.facturasArr.size(); i++){
                            if (identificador==Main.facturasArr.get(i).getId()) {
                                flag2 = true;
                                usuarioRepetido = Main.facturasArr.get(i).getId();
                                break;
                            }
                        }
                        if (flag2) {
                            Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " La factura con id " + usuarioRepetido + " ya existe,se omitió el registro." + "\n");
                            JOptionPane.showMessageDialog(this, "La facturas con id "+usuarioRepetido+" ya esta registrado, intente con otro ID de factura.");

                        }else {
                                for (int i=0;i<Main.productosArr.size();i++){
                                    if (name.equals(Main.productosArr.get(i).getName())&&precio==Main.productosArr.get(i).getPrice()){
                                        for (int j=0;j<Main.clientesArr.size();j++){
                                            if (idCliente==Main.clientesArr.get(j).getId()){
                                                    ingredientes[] nuevo3= new ingredientes[1];
                                                    Productos productos=new Productos(0,name,"",0,precio, nuevo3);
                                                    Productos[] nuevo2= new Productos[1];
                                                    nuevo2[0]=productos;
                                                    Facturas nuevo = new Facturas(identificador,idCliente, date,nuevo2);
                                                    Main.facturasArr.add(nuevo);
                                                    ventana.dispose();
                                                    Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user+ ": Ha Creado al Producto  " +name+" por medio de interfaz gráfica"+ "\n");
                                                    JOptionPane.showMessageDialog(this, "La factura con id "+identificador+" ha sido agregado.");
                                                    FacturasCRUD facturasCRUD= new FacturasCRUD();

                                                    flag4=false;
                                            }else {
                                                flag4=true;
                                                continue;
                                            }

                                        } flag3=false;
                                    }else{
                                        flag3=true;
                                        continue;
                                    }
                                }
                            if (flag4){
                                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " La factura con id " + usuarioRepetido + " no puede ser agregada porque no existe el cliente." + "\n");
                                JOptionPane.showMessageDialog(this, "La factura no puede ser agregada porque no existe el cliente.");
                            }
                            if (flag3){
                                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " La factura con id " + usuarioRepetido + " no puede ser agregada porque no coincide con los valores de los productos." + "\n");
                                JOptionPane.showMessageDialog(this, "La factura no puede ser agregada porque no coincide con los valores de los productos.");
                            }
                        }
                    }
                }

            }catch (Exception a){
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURAS:" + " Error en registrar nuevas facturas, campos incompletos" + "\n");
            }
        }
        if(e.getSource() == b2){
            ventana.dispose();
            FacturasCRUD facturasCRUD=new FacturasCRUD();
        }
    }
}
