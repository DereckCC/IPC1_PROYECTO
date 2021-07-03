package com.G7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class editarProducto extends JFrame implements ActionListener {
    JFrame ventana;
    JButton b1, b2;
    JLabel titulo, l1, l2, l3, l4, l5,titulo2,l6,l7,l8;
    JTextField t1, t2, t3, t4, t5,t6,t7,t8;
    String typeMain,name,description,nameIngredient,units;
    int indexMain,identificador,quantity;
    Double cost,price;
    ingredientes[] nuevo2;

    public void editarProducto(String type, String index){
        ventana = new JFrame("Editar Producto");
        ventana.setBounds(700, 250, 500, 700);
        ventana.setLayout(null);
        ventana.getContentPane().setBackground(new Color(44, 44, 84));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        titulo = new JLabel("Editar Producto");
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

        l3 = new JLabel("Descripción: ");
        l3.setFont(new Font("arial", Font.ITALIC, 15));
        l3.setBounds(40, 180, 400, 30);
        l3.setVisible(true);
        ventana.add(l3);

        l4 = new JLabel("Costo: ");
        l4.setFont(new Font("arial", Font.ITALIC, 15));
        l4.setBounds(40, 240, 400, 30);
        l4.setVisible(true);
        ventana.add(l4);

        l5 = new JLabel("Precio: ");
        l5.setFont(new Font("arial", Font.ITALIC, 15));
        l5.setBounds(40, 300, 400, 30);
        l5.setVisible(true);
        ventana.add(l5);

        titulo2 = new JLabel("Ingrediente");
        titulo2.setFont(new Font("arial", Font.BOLD, 20));
        titulo2.setBounds(180, 360, 400, 30);
        titulo2.setVisible(true);
        ventana.add(titulo2);

        l6 = new JLabel("Nombre: ");
        l6.setFont(new Font("arial", Font.ITALIC, 15));
        l6.setBounds(40, 420, 400, 30);
        l6.setVisible(true);
        ventana.add(l6);

        l7 = new JLabel("Cantidad: ");
        l7.setFont(new Font("arial", Font.ITALIC, 15));
        l7.setBounds(40, 480, 400, 30);
        l7.setVisible(true);
        ventana.add(l7);

        l8 = new JLabel("Unidades: ");
        l8.setFont(new Font("arial", Font.ITALIC, 15));
        l8.setBounds(40, 540, 400, 30);
        l8.setVisible(true);
        ventana.add(l8);


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

        t6 = new JTextField();
        t6.setBounds(140, 420, 290, 30);
        t6.setVisible(true);
        ventana.add(t6);

        t7 = new JTextField();
        t7.setBounds(140, 480, 290, 30);
        t7.setVisible(true);
        ventana.add(t7);

        t8 = new JTextField();
        t8.setBounds(140, 540, 290, 30);
        t8.setVisible(true);
        ventana.add(t8);

        b1 = new JButton("Editar");
        b1.setBounds(250, 600, 180, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        ventana.add(b1);

        b2 = new JButton("Regresar");
        b2.setBounds(40, 600, 180, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        ventana.add(b2);

        typeMain = type;
        indexMain = Integer.parseInt(index);

        if (type == "actualizar") {

            for (int i=0;i<Main.productosArr.size();i++){
                if (indexMain==Main.productosArr.get(i).getId()){
                    t1.setText(String.valueOf(Main.productosArr.get(i).getId()));
                    t1.disable();
                    t2.setText(Main.productosArr.get(i).getName());
                    t3.setText(Main.productosArr.get(i).getDescription());
                    t4.setText(String.valueOf(Main.productosArr.get(i).getCost()));
                    t5.setText(String.valueOf(Main.productosArr.get(i).getPrice()));
                    nuevo2=Main.productosArr.get(i).getIngredients();
                    t6.setText(nuevo2[0].getName());
                    t7.setText(String.valueOf(nuevo2[0].getQuantity()));
                    t8.setText(nuevo2[0].getUnits());
                    break;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2){
            ventana.dispose();
            ProductoCRUD productoCRUD=new ProductoCRUD();
        }
        if(e.getSource() == b1){
            try {
                boolean flag=false;
                identificador=Integer.parseInt(t1.getText().trim());
                name=t2.getText().trim();
                description=t3.getText().trim();
                nameIngredient=t6.getText().trim();
                units=t8.getText().trim();
                try {
                    cost=Double.parseDouble(t4.getText().trim());
                    price=Double.parseDouble(t5.getText().trim());
                    quantity=Integer.parseInt(t7.getText().trim());
                    flag=false;
                }catch (Exception ae){
                    flag=true;
                }
                if (flag){
                    JOptionPane.showMessageDialog(this, "La casilla de costo,precio y cantidad solo acepta números. ");
                    Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " La casilla de costo,precio y cantidad solo acepta números." + "\n");
                    ventana.dispose();
                    ProductoCRUD productoCRUD=new ProductoCRUD();
                }else {
                    if (name.equals("")  || description.equals("") || t4.getText().trim().equals("") || t5.getText().trim().equals("")||nameIngredient.equals("")||t7.getText().trim().equals("")||units.equals("")){
                        JOptionPane.showMessageDialog(this, "Sus campos estan vacios.");
                        Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " Uno o varios campos del registro están vacios." + "\n");
                    }else{
                        for (int i=0;i<Main.productosArr.size();i++){

                            if(indexMain==Main.productosArr.get(i).getId()){
                                Main.productosArr.get(i).setName(name);
                                Main.productosArr.get(i).setDescription(description);
                                Main.productosArr.get(i).setCost(cost);
                                Main.productosArr.get(i).setPrice(price);
                                ingredientes ingredientes=new ingredientes(nameIngredient,quantity,units);
                                ingredientes[] nuevo2= new ingredientes[1];
                                nuevo2[0]=ingredientes;
                                Main.productosArr.get(i).setIngredients(nuevo2);
                                JOptionPane.showMessageDialog(this, "El producto con id "+ indexMain+" ha sido editado.");
                                ventana.dispose();
                                ProductoCRUD productoCRUD=new ProductoCRUD();
                                Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user+ ": Ha editado al producto con id: " +identificador+   "\n");
                                break;
                            }
                        }
                    }

                }


            }catch (Exception a){
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " Error en editar productos, campos incompletos" + "\n");

            }
        }
    }
}
