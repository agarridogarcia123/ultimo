/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockw;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class Coleccion {
     private ArrayList <Prenda> coleccion = new ArrayList<Prenda>();

    
    
    public String dameTipo(){
return(JOptionPane.showInputDialog("Tipo de prenda: "));
}
      public String dameRef(){
return(JOptionPane.showInputDialog("Referencia: "));
}
       


   public int pedirInt(){
    return(Integer.parseInt(JOptionPane.showInputDialog("Dame o número de unidades: ")));
}
public float pedirFloat(){
    return(Float.parseFloat(JOptionPane.showInputDialog("Precio: ")));
 }

public void engadir(){
    coleccion.add(new Prenda(dameTipo(),dameRef(),pedirInt(),pedirFloat()));
}

public void buscarPorTipo(){
    String tipos=JOptionPane.showInputDialog("Nome da prenda que buscas: ").toLowerCase();
            boolean atopado=false;
            for(int i=0;i<coleccion.size();i++){
                if(coleccion.get(i).getTipo().toLowerCase().equals(tipos)){
                atopado=true;
                System.out.println("Prenda dispoñible"+"\nReferencia: "+coleccion.get(i).getReferencia()+" Precio: "+ (coleccion.get(i).getPrecio()));
                }
            }
            if(atopado==false)
                System.out.println("A prenda non esta dispoñible.");
}

public void buscarPorRef(){
    String ref=JOptionPane.showInputDialog("Referencia da prenda que buscas: ").toLowerCase();
            boolean atopado=false;
            for(int i=0;i<coleccion.size();i++){
                if(coleccion.get(i).getReferencia().toLowerCase().equals(ref)){
                atopado=true;
                System.out.println("Prenda dispoñible"+"\nTipo de prenda: "+coleccion.get(i).getTipo().toLowerCase()+" Precio: "+ (coleccion.get(i).getPrecio()));
                }
            }
            if(atopado==false)
                System.out.println("A prenda non esta dispoñible.");
}
public void borrarUnidadesAcero(){
   
    for(int i=0;i<coleccion.size();i++){
        if(coleccion.get(i).getUnidades()==0)
            coleccion.remove(i);
       }
    
}

public void mostrar(){
    for(int i=0; i<coleccion.size();i++)
         System.out.println(coleccion.get(i));
 
}

public void escribirTexto(String nombreFichero){
         File fich;
         PrintWriter f = null;
        try{
            fich = new File (nombreFichero);
            f= new PrintWriter(fich);
            for(int i=0;i<coleccion.size();i++){
              f.println(coleccion.get(i));  
          
            }
           
        }catch (FileNotFoundException ex){
            System.out.println("Error 4 " + ex.getMessage());  
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Error 5: "+ ex.getMessage());
        }
        finally{
            f.close();
        }      
} 
public void leerLineas() throws FileNotFoundException, IOException{
        String s1;
        String s2;
 
        
        BufferedReader br = new BufferedReader (new FileReader ("coleccion.txt"));
 
       
        do{
        s1 = br.readLine();
        if(s1!=null){
            StringTokenizer st = new StringTokenizer(s1,",");
            System.out.println ("En stock:" + s1);
            while (st.hasMoreTokens()){
                coleccion.add(new Prenda(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Float.parseFloat(st.nextToken())));
               
            }
                
        }
        }
        while(s1!=null);

 
}
}
