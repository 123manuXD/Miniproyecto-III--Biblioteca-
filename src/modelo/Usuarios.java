/*
 Archivo: Usuarios.java
 Proyecto III - Biblioteca univalle
 29 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435)
 */

package modelo;

import java.io.Serializable;
import java.util.*;

public class Usuarios implements Listable , Serializable{
    public static final long serialVersionUID = 1L;
    private static final int datosTotales = 3;
    private Integer codigo;
    private String nombre;
    private String tipoUsuario;

    public Usuarios (Integer codigo, String nombre, String tipoUsuario){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        
    }
    // Getter
    public Integer getCodigo(){
        return codigo;
    }

    public String getNombreUsuario(){
        return nombre;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    }


    public int getTotalDatos(){
        return datosTotales;
    }

    // Setter
    public void setCodigoUsuario(Integer codigo) {
        this.codigo = codigo;
    }


    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDato (int pkdato){
        switch(pkdato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(nombre);
            case 2:
                return String.valueOf(tipoUsuario);
            default:
                return "";
        }
    }
    
}
