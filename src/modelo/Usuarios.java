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

public class Usuarios implements Serializable{
    public static final long serialVersionUID = 1L;
    private static final int datosTotales = 3;
    private Integer codigo;
    private String tipoUsuario;
    private String nombre;

    public Usuarios (Integer codigo, String tipoUsuario, String nombre){
        this.codigo = codigo;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
    }
    // Getter
    public Integer getCodigoUsuario(){
        return codigo;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    }

    public String getNombreUsuario(){
        return nombre;
    }

    public int getDatosTotales(){
        return datosTotales;
    }
    // Setter
    public void setCodigoUsuario(Integer codigo) {
        this.codigo = codigo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getDato (int pkdato){
        switch(pkdato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(tipoUsuario);
            case 2:
                return String.valueOf(nombre);
            default:
                return "";
        }
    }
}
