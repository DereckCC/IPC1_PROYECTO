package com.G7;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class FacturasCRUD  extends JFrame implements ActionListener, MouseListener {

    int Contador = 0;
    String barra[];
    public   DefaultTableModel tabla;
    JFrame infFactura;
    JTable tablaRestaurante;
    JScrollPane sp;
    JLabel titulo;
    JButton b2,b4,b5;
    String select ="";
    VerFactura seeFactura = new VerFactura();

 public FacturasCRUD(){

     infFactura =new JFrame("Informacion Factura.");
     infFactura.setBounds(600, 300, 800, 350);
     infFactura.setLayout(null);
     infFactura.getContentPane().setBackground(new Color(44, 44, 84));
     infFactura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     infFactura.setResizable(false);
     infFactura.setVisible(true);


    /* titulo= new JLabel("Informacion Facturas");
     titulo.setFont(new Font("arial", Font.BOLD, 20));
     titulo.setBounds(450, 250, 400, 30);
     titulo.setVisible(true);
     infFactura.add(titulo);*/


     tabla = new DefaultTableModel();
     tablaRestaurante = new JTable(tabla);
     tabla.addColumn("Id");
     tabla.addColumn("Client");
     tabla.addColumn("Date");
     tabla.addColumn("Name");
     tabla.addColumn("Price");
     for (int i = 0; i < Main.facturasArr.size(); i++) {
         Productos[] misproductos = Main.facturasArr.get(i).getProducts();
         for (int j = 0; j < misproductos.length; j++) {
                 barra = new String[8];
                 barra[0] = String.valueOf(Main.facturasArr.get(i).getId());
                 barra[1] = String.valueOf(Main.facturasArr.get(i).getClient());
                 barra[2] = Main.facturasArr.get(i).getDate();
                 barra[3] = misproductos[j].getName();
                 barra[4] = String.valueOf(misproductos[j].getPrice());
                 tabla.addRow(barra);
                 Contador++;
         }
     }

     tablaRestaurante.setBounds(25,25,725,200);
     tablaRestaurante.addMouseListener(this);
     tablaRestaurante.setModel(tabla);

     sp = new JScrollPane(tablaRestaurante);
     sp.setBounds(25,25,725,200);
     infFactura.add(sp);
     sp.setVisible(true);


     b2 = new JButton("Crear");
     b2.setBounds(25,250,170,30);
     b2.setVisible(true);
     b2.addActionListener(this);
     infFactura.add(b2);

     b5 = new JButton("Visualizar");
     b5.setBounds(395,250,170,30);
     b5.setVisible(true);
     b5.addActionListener(this);
     infFactura.add(b5);


     b4 = new JButton("Regresar");
     b4.setBounds(210,250,170,30);
     b4.setVisible(true);
     b4.addActionListener(this);
     infFactura.add(b4);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2){
            AgregarFactura agregarFactura=new AgregarFactura();
            infFactura.dispose();
        }
        if (e.getSource() == b4) {
            infFactura.dispose();
            MenuCRUD nuevo = new MenuCRUD();
        }
        if (e.getSource() == b5){
            if (!select.equals("")) {
                seeFactura.VerFactura("visualizar", select);
                infFactura.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un registro para visualizar.");
                Log.addToEndFile("errors.log.txt", " " + new Date().toString() + "\t---" + "FACTURA:" + " No se seleccionó ningún registro a visualizar." + "\n");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String row = String.valueOf(tablaRestaurante.getValueAt(tablaRestaurante.getSelectedRow(),0));
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

