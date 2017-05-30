
package stockw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;


public class Prenda extends Coleccion {
    private String tipo;
    private String referencia;
    private int unidades;
    private float precio;

    public Prenda() {
    }

    public Prenda(String tipo, String referencia,int unidades, float precio) {
        this.tipo = tipo;
        this.referencia = referencia;
        this.unidades = unidades;
        this.precio = precio;
    }

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Prenda{" + "tipo=" + tipo + ", referencia=" + referencia + ", unidades=" + unidades + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.tipo);
        hash = 73 * hash + Objects.hashCode(this.referencia);
        hash = 73 * hash + this.unidades;
        hash = 73 * hash + Float.floatToIntBits(this.precio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prenda other = (Prenda) obj;
        if (this.unidades != other.unidades) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }
    
//    public void escribirTexto(String nombreFichero){
//         File fich;
//         PrintWriter f = null;
//        try{
//            fich = new File (nombreFichero);
//            f= new PrintWriter(fich);
//            for(int i=0;i<tipo.length();i++){
//              f.println(super.referencia.get(i)+ "," +super.tipo.get(i)+","+ super.talla.get(i)+ ","+Integer.parseInt(super.unidades.get(i).toString())+ ","+Float.parseFloat(super.precio.get(i).toString()));  
//          
//            }
//           
//        }catch (FileNotFoundException ex){
//            System.out.println("Error 4 " + ex.getMessage());  
//        }catch(IndexOutOfBoundsException ex){
//            System.out.println("Error 5: "+ ex.getMessage());
//        }
//        finally{
//            f.close();
//        }      
//}
    
    
    
}
