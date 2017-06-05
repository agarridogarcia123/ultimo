/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockw;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.write.biff.File;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author chisco
 */
public class VentanaVender extends javax.swing.JFrame {
    
     DefaultTableModel venta= new DefaultTableModel();

    /**
     * Creates new form VentanaVender
     */
    public VentanaVender() {
       initComponents();
       iniciarTabla();
       mostrarstock("");
       setVisible(true);
       this.dispose();
 
    }
  
 void mostrarstock(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Tipo");
    modelo.addColumn("Referencia");
    modelo.addColumn("Talla");
    modelo.addColumn("Unidades");
    modelo.addColumn("Precio");
    tabla.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM prendas";
    }
    else{
        sql="SELECT * FROM prendas WHERE referencia='"+valor+"'";
    }
    
    
    String [] datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=String.valueOf(rs.getInt(4));
                datos[4]=String.valueOf(rs.getFloat(5));
                
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(StockW.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 void filtrarstock(String tipo){
     
     
 
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Tipo");
    modelo.addColumn("Referencia");
    modelo.addColumn("Talla");
    modelo.addColumn("Unidades");
    modelo.addColumn("Precio");
    tabla.setModel(modelo);
    String sql="";
    if(tipo.equals(""))
    {
        sql="SELECT * FROM prendas";
    }
    else{
        sql="SELECT * FROM prendas where tipo like '%"+tipo+"%'";
    }
    
    
    String [] datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=String.valueOf(rs.getInt(4));
                datos[4]=String.valueOf(rs.getFloat(5));
                
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(StockW.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 public void iniciarTabla(){
     venta.addColumn("Tipo");
    venta.addColumn("Referencia");
    venta.addColumn("Talla");
    venta.addColumn("Unidades");
    venta.addColumn("Precio");
    
    tabla2.setModel(venta);
 }
 void mostrarventa(String referencia, int unidades){

    String sql="";
    if(referencia.equals(""))
    {
        sql="SELECT * FROM prendas";
    }
    else{
        sql="SELECT * FROM prendas WHERE referencia='"+referencia+"'";
    }
    
    
    String [] datos = new String [5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=String.valueOf(unidades);
                datos[4]=String.valueOf(rs.getFloat(5));
                
                venta.addRow(datos);
            }
           
            
        } catch (SQLException ex) {
            
            Logger.getLogger(StockW.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 
 
 
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnvender = new javax.swing.JButton();
        btnenviar = new javax.swing.JButton();
        excel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        txttipo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        desde = new javax.swing.JTextField();
        destinatario = new javax.swing.JTextField();
        asunto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StockWarehouse");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boVender.png"))); // NOI18N
        btnvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnvender, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, 149, -1));

        btnenviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOmAIL.png"))); // NOI18N
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 660, 143, -1));

        excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOexcel.png"))); // NOI18N
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        getContentPane().add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 660, 147, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 360, 220));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 340, 220));

        jLabel2.setText("factura:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));
        getContentPane().add(txttipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 196, -1));

        jLabel5.setText("Desde");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restoVentanas.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 850, -1));

        jLabel3.setText("tipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel6.setText("Destinatario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jLabel7.setText("Asunto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        desde.setText("stockwarehouse2017@gmail.com");
        getContentPane().add(desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));
        getContentPane().add(destinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 110, -1));
        getContentPane().add(asunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 100, -1));

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane2.setViewportView(txt);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenderActionPerformed
//botón vender por referencia

        int fila = tabla.getSelectedRow();
        int unidades;
        int unid=Integer.parseInt(JOptionPane.showInputDialog("Inserta cuantas quieres vender"));
       
        String referencia="";
        referencia=(String) tabla.getValueAt(fila, 1);
        unidades=Integer.parseInt(tabla.getValueAt(fila, 3).toString());
        
        if(unid>unidades){
            JOptionPane.showInputDialog("No hay suficiente stock");
        }
        else{
        try {
            
           PreparedStatement pst = cn.prepareStatement("UPDATE prendas SET unidades ==unidades-"+unid+ " where referencia=='"+referencia+"'");
          
           pst.executeUpdate();
            mostrarstock("");
            mostrarventa(referencia,unid);
        }catch (Exception e) {
        }
        }
    }//GEN-LAST:event_btnvenderActionPerformed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
   

    }//GEN-LAST:event_excelActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
      String tipo=txttipo.getText().toLowerCase();
      filtrarstock(tipo);
    }//GEN-LAST:event_buscarActionPerformed

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
    
        JTextField Jpassword = new JPasswordField();//se crea un JPassword
Object[] ob = {Jpassword};                      //se crea un objeto para contener el JPassword
           
//se crea una ventana de dialogo para introducir la contraseña
int result = JOptionPane.showConfirmDialog(null, ob, "Ingrese su contraseña", JOptionPane.OK_CANCEL_OPTION);
//si se presiono aceptar
if (result == JOptionPane.OK_OPTION) {
//crea instancia para enviar email, pasandole los parametros.
    int tabla2;
  // tabla2.getValueAt(tabla2.getSelectedRow(), 0);
                EnviaEmail enviaEmail = new EnviaEmail(desde.getText(), Jpassword.getText(),destinatario.getText(), asunto.getText(),txt.setText(Integer.toString(tabla2.getValueAt(tabla2.getSelectedRow(), 0))));
}//fin si
       
    }//GEN-LAST:event_btnenviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaVender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asunto;
    private javax.swing.JButton btnenviar;
    private javax.swing.JButton btnvender;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField desde;
    private javax.swing.JTextField destinatario;
    private javax.swing.JButton excel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables
  conectar cc= new conectar();
    Connection cn= cc.conexion();
}
