/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockw;




import email.EnviaEmail;
import excel.excel2;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JTable;

/**
 *
 * @author Araceli
 * @author Marta
 */
public class VentanaVender extends javax.swing.JFrame {
    
     DefaultTableModel venta= new DefaultTableModel();

   
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
    venta.addColumn("Precio/Unidad");
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txttipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        asunto = new javax.swing.JTextField();
        destinatario = new javax.swing.JTextField();
        desde = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        excel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StockWarehouse");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boVender.png"))); // NOI18N
        btnvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnvender, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 740, 150, 80));

        btnenviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOmAIL.png"))); // NOI18N
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 740, 143, 80));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 360, 220));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 340, 220));

        jLabel2.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Factura:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarletras.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 120, 100));

        jLabel5.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Desde:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));
        getContentPane().add(txttipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 196, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EtTipo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Asunto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));
        getContentPane().add(asunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 230, -1));

        destinatario.setText("ara.agg@gmail.com");
        getContentPane().add(destinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 190, -1));

        desde.setText("stockwarehouse2017@gmail.com");
        getContentPane().add(desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 230, -1));

        jLabel6.setFont(new java.awt.Font("Coolvetica Rg", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Destinatario:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane2.setViewportView(txt);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 650, 340, 60));

        excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BOexcel.png"))); // NOI18N
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        getContentPane().add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 740, 140, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restoVentanas.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenderActionPerformed
     

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

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
      String tipo=txttipo.getText().toLowerCase();
      filtrarstock(tipo);
    }//GEN-LAST:event_buscarActionPerformed

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
  //metodo para gardar a tabla das facturas na BD
        try {
     for(int i=0; i<tabla2.getRowCount();i++){
        PreparedStatement pst = cn.prepareStatement("INSERT INTO ventas(tipo, referencia, talla, unidades, precio) VALUES (?,?,?,?,?)");
            pst.setString(1,tabla2.getValueAt(i,0).toString());
            pst.setString(2,tabla2.getValueAt(i,1).toString());
            pst.setString(3,tabla2.getValueAt(i,2).toString());
            pst.setString(4,tabla2.getValueAt(i,3).toString());
            pst.setString(5,tabla2.getValueAt(i,4).toString());
            pst.executeUpdate();
     }
            } catch (Exception e) {
            System.out.print(e.getMessage());
        }
     
     
    //metodo para enviar email      
    JTextField Jpassword = new JPasswordField();//creamos JPassword
    Object[] ob = {Jpassword}; //obxeto para meter o JPassword
           
    int result = JOptionPane.showConfirmDialog(null, ob, "Ingrese su contraseña", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
     TableModel model = tabla2.getModel(); 
           
    //texto que vai no email
    this.txt.setText("Confirmación de compra: \n" );
  
    for(int fila=0;fila<model.getRowCount();fila++){
    this.txt.append(tabla2.getValueAt(fila,0).toString()+"   Ref:");
    this.txt.append(tabla2.getValueAt(fila,1).toString()+"    Talla:");
    this.txt.append(tabla2.getValueAt(fila,2).toString()+"    Unidades:");
    this.txt.append(tabla2.getValueAt(fila,3).toString()+"    Precio/Unidad:");
    this.txt.append(tabla2.getValueAt(fila,4).toString()+" €  \n");
    }
    this.txt.append(" \n Si no se corresponde con lo que ha pedido por favor póngase en contacto con nosotros, \n Atentamente Stock Warehouse." );
           
     EnviaEmail enviaEmail = new EnviaEmail(desde.getText(), Jpassword.getText(),destinatario.getText(), asunto.getText(),txt.getText());
    }
    }//GEN-LAST:event_btnenviarActionPerformed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        JFileChooser dialog = new JFileChooser();
        int opcion = dialog.showSaveDialog(VentanaVender.this);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            File dir = dialog.getSelectedFile();

            try {
                List<JTable> tb = new ArrayList<JTable>();
                tb.add(tabla2);
                
                excel2 excelExporter = new excel2 (tb, new File(dir.getAbsolutePath() + ".xls"));
                if (excelExporter.export()) {
                    JOptionPane.showMessageDialog(null, "Tablas exportadas!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
       
    }//GEN-LAST:event_excelActionPerformed

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
