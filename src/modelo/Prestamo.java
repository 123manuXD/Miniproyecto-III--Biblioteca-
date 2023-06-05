/*
 Archivo: Recurso.java
 Proyecto III - Biblioteca univalle
 03 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435)
 */

 package modelo;

 import java.io.Serializable;
 import java.util.*;
 import java.time.*;
 import java.math.*;


public class Prestamo implements Listable, Serializable{
    public static final long serialVersionUID = 1L;
    public static final int datosTotales = 6;
    private Integer codigo;
    private Integer codigoUsuario;
    private String nombreUsuario;
    private HashMap<Integer, String[]> listaRecursos ;
    private Integer numeroRecursos = 0;
    private String estado;

    public Prestamo (Integer codigo, Integer codigoUsuario, String nombreUsuario, HashMap<Integer, String[]> listaRecursos, Integer numeroRecursos, String estado ){
        this.codigo = codigo;
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.listaRecursos = listaRecursos;
        this.numeroRecursos = numeroRecursos;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public HashMap<Integer, String[]> getListaRecursos() {
        return listaRecursos;
    }

    public Integer getNumeroRecursos() {
        return numeroRecursos;
    }

    public String getEstado() {
        return estado;
    }
    
    public int getTotalDatos() {
        return datosTotales;
    }

    public String getDato(int pkDato) {
        switch(pkDato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(codigoUsuario);
            case 2:
                return String.valueOf(nombreUsuario);
            case 3:
                return String.valueOf(numeroRecursos);
            case 4:
                return String.valueOf(estado);
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", codigoUsuario=" + codigoUsuario + ", nombreUsuario=" + nombreUsuario
                + ", listaRecursos=" + listaRecursos + ", numeroRecursos=" + numeroRecursos + ", estado=" + estado
                + "]";
    }
    
}
