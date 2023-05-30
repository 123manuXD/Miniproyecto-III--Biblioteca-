/*
 Archivo: Autores.java
 Proyecto III - Biblioteca univalle
 29 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435)
 */

package modelo;

import java.io.Serializable;
import java.util.*;

public class Autores implements Serializable{
    public static final long serialVersionUID = 1L;
    private static final int datosTotales = 2;
    private Integer codigo;
    private String nombreAutor;
    private String relevancia;

    public Autores (Integer codigo, String nombreAutor, String relevancia){
        this.codigo = codigo;
        this.nombreAutor = nombreAutor;
        this.relevancia = relevancia;
    }
    // Getter
    public Integer getCodigoAutor(){
        return codigo;
    }

    public String getNombreAutor(){
        return nombreAutor;
    }

    public String getRelevancia() {
        return relevancia;
    }

    public int getDatosTotales(){
        return datosTotales;
    }
    // Setter
    public void setCodigoAutor(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setRelevancia(String relevancia) {
        this.relevancia = relevancia;
    }

    public String getDato (int pkdato){
        switch(pkdato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(nombreAutor);
            case 2:
                return String.valueOf(relevancia);
            default:
                return "";
        }
    }
}
