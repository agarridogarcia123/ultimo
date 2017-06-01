/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockw;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Araceli
 */
public class conectar {
    Connection conectar=null;
    public Connection conexion(){
         try{
          Class.forName("org.sqlite.JDBC");
          Connection con=DriverManager.getConnection("jdbc:sqlite:F:\\Marta\\CD\\Prox3Av\\Stock.sqlite");
          //Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Araceli\\Documents\\NetBeansProjects\\StockW\\Stock.sqlite");
          JOptionPane.showMessageDialog(null,"Conexión establecida");
          return con;
      }  catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          return null;
      }
    }
}
