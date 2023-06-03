/*
 Archivo: Recurso.java
 Proyecto III - Biblioteca univalle
 02 de Junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435)
 */

package modelo;
import java.io.Serializable;
import java.util.*;
import java.time.*;
import java.math.*;

public class Recurso implements Listable, Serializable{
    public static final long serialVersionUID = 1L;
    public static final int datosTotales = 8;
    private Integer codigo;
    private String titulo;
    private LocalDate fechaRegistro; 
    private String tipoRecurso;
    private Integer autorRecurso;
    private Integer generoRecurso;
    private String autorRecursoS;
    private String generoRecursoS;
    
    public Recurso(Integer codigo, String titulo, LocalDate fechaRegistro, String tipoRecurso, Integer autorRecurso, String autorRecursoS , Integer generoRecurso, String generoRecursoS ){
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaRegistro = fechaRegistro;
        this.tipoRecurso = tipoRecurso;
        this.autorRecurso = autorRecurso;
        this.autorRecursoS = autorRecursoS;
        this.generoRecurso = generoRecurso;
        this.generoRecursoS = generoRecursoS;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    
    public String getTipoRecurso() {
        return tipoRecurso;
    }

    
    public Integer getAutorRecurso() {
        return autorRecurso;
    }


    public Integer getGeneroRecurso() {
        return generoRecurso;
    }

    public String getAutorRecursoS() {
        return autorRecursoS;
    }

    public String getGeneroRecursoS() {
        return generoRecursoS;
    }

    public int getTotalDatos() {
        return datosTotales;
    }
    
    public String getDato(int pkDato) {
        switch(pkDato){
            case 0:
                return String.valueOf(codigo);
            case 1:
                return String.valueOf(titulo);
            case 2:
                return String.valueOf(fechaRegistro);
            case 3:
                return String.valueOf(tipoRecurso);
            case 4:
                return String.valueOf(autorRecurso);
            case 5:
                return String.valueOf(generoRecurso);
            case 6:
                return String.valueOf(autorRecursoS);
            case 7:
                return String.valueOf(generoRecursoS);
            default:
                return "";
        }
    }
    


    

    
    
    
}
