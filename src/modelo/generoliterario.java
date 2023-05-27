/*
 Archivo: Generoliteario.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */

package modelo;

import java.io.Serializable;
import java.util.*;

public abstract class Generoliterario implements Serializable{
    public static final long serialVersionUID = 1L;
    private static final int datosTotales = 2;
    private Integer codigo;
    private String genero;


    public Generoliterario (Integer codigo, String genero){
        this.codigo = codigo;
        this.genero = genero;
    }

    public Integer getcodigogenero(){
        return codigo;
    }

    public String getgeneroliterario(){
        return genero;
    }

    public int getDatosTotales(){
        return datosTotales;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDato (int pkdato){
        switch(pkdato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(genero);
            default:
                return "";
        }
    }

    //BUSCAR COMO FUNCIONA JTABLE

   
}
