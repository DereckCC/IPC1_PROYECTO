package com.G7;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class ProductoCRUD extends JFrame implements ActionListener, MouseListener {
    int Contador = 0;
    String barra[];
    public   DefaultTableModel tabla;
    JFrame infProducto;
    JTable tablaProducto;
    JScrollPane sp;
    JButton b1,b2,b3,b4,b5;
    String select ="";
    editarProducto editarProducto=new editarProducto();
    VerProducto seeProducto = new VerProducto();
    public ProductoCRUD(){

        infProducto =new JFrame("Informacion productos.");
        infProducto.setBounds(700, 400, 800, 370);
        infProducto.setLayout(null);
        infProducto.getContentPane().setBackground(new Color(44, 44, 84));
        infProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infProducto.setResizable(false);
        infProducto.setVisible(true);

        tabla = new DefaultTableModel();
        tablaProducto = new JTable(tabla);
        tabla.addColumn("Id");
        tabla.addColumn("Name");
        tabla.addColumn("description");
        tabla.addColumn("cost");
        tabla.addColumn("price");
        tabla.addColumn("name");
        tabla.addColumn("quantity");
        tabla.addColumn("units");

        for (int i = 0; i < Main.productosArr.size(); i++) {

            ingredientes[] meingredientes = Main.productosArr.get(i).getIngredients();
            for (int j = 0; j < meingredientes.length; j++) {
                barra = new String[8];
                barra[0] = String.valueOf(Main.productosArr.get(i).getId());
                barra[1] = Main.productosArr.get(i).getName();
                barra[2] = Main.productosArr.get(i).getDescription();
                barra[3] = String.valueOf(Main.productosArr.get(i).getCost());
                barra[4] = String.valueOf(Main.productosArr.get(i).getPrice());
                barra[5] = meingredientes[j].getName();
                barra[6] = String.valueOf(meingredientes[j].getQuantity());
                barra[7] = meingredientes[j].getUnits();
                tabla.addRow(barra);
                Contador++;
            }
        }

        tablaProducto.setBounds(25,25,725,200);
        tablaProducto.setModel(tabla);
        tablaProducto.addMouseListener(this);

        sp = new JScrollPane(tablaProducto);
        sp.setBounds(25,25,725,200);
        infProducto.add(sp);
        sp.setVisible(true);

        b1 = new JButton("Editar");
        b1.setBounds(265,240,230,30);
        b1.setVisible(true);
        b1.addActionListener(this);
        infProducto.add(b1);

        b2 = new JButton("Agregar");
        b2.setBounds(25,240,230,30);
        b2.setVisible(true);
        b2.addActionListener(this);
        infProducto.add(b2);

        b3 = new JButton("Eliminar");
        b3.setBounds(510,240,230,30);
        b3.setVisible(true);
        b3.addActionListener(this);
        infProducto.add(b3);

        b5 = new JButton("Visualizar");
        b5.setBounds(125,280,230,30);
        b5.setVisible(true);
        b5.addActionListener(this);
        infProducto.add(b5);

        b4 = new JButton("Regresar");
        b4.setBounds(365,280,230,30);
        b4.setVisible(true);
        b4.addActionListener(this);
        infProducto.add(b4);
    }


    public void borrarProducto(String index) {
        int valor= Integer.parseInt(index);
        for (int i = 0; i < Main.productosArr.size(); i++) {
            if (Main.productosArr.get(i).getId() == valor) {
                Main.productosArr.remove(i);
            }
        }
        Log.addToEndFile("log.log.txt", " " + new Date().toString() + "\t---" +Login.user + ": Elimino al producto con id: " + valor + "\n");
        ProductoCRUD productoCRUD=new ProductoCRUD();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2){
            AgregarProducto agregarProducto=new AgregarProducto();
            infProducto.dispose();
        }
        if (e.getSource() == b1){
            if (!select.equals("")) {
                editarProducto.editarProducto("actualizar", select);
                infProducto.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para editar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " No se seleccionó ningún registro a editar." + "\n");
            }
        }
        if (e.getSource() == b3){
            if (!select.equals("")) {
                int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar el producto con id: "+select+" ?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    borrarProducto(select);
                    infProducto.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para eliminar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " No se seleccionó ningún registro a eliminar." + "\n");
            }
        }
        if(e.getSource() == b4){
            infProducto.dispose();
            MenuCRUD nuevo = new MenuCRUD();
        }
        if (e.getSource() == b5){
            if (!select.equals("")) {
                seeProducto.VerProducto("visualizar", select);
                infProducto.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para visualizar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "PRODUCTOS:" + " No se seleccionó ningún registro a visualizar." + "\n");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String row = String.valueOf(tablaProducto.getValueAt(tablaProducto.getSelectedRow(),0));
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
