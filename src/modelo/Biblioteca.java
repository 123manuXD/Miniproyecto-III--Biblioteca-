/*
 Archivo: Biblioteca.java
 Proyecto III - Biblioteca univalle
 28 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 


  Esta clase intentara modelar la biblioteca, este contiene los DAO necesarios para que funcione
  la biblioteca, Usario, Recurso, Autores, genero literario y prestamo
 
 */

package modelo;
import DAO.*;
import java.io.Serializable;

public class Biblioteca implements Serializable{
    public static final long serialVersionUID = 1L;
    public String nombreBiblioteca;
    private GnrliteraDAO generoLiterario;
    private Integer codSerialgrlt = 6500;
    private AutoresDAO autor;
    private Integer codInteger = 1040780;


    public Biblioteca(String nombreBiblioteca){
        this.nombreBiblioteca = nombreBiblioteca;
        this.generoLiterario = new GnrliteraDAOimp();
        this.autor = new AutoresDAOimp();

            
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public GnrliteraDAO getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(GnrliteraDAO generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public AutoresDAO getAutor() {
        return autor;
    }

    public void setAutor(AutoresDAO autor) {
        this.autor = autor;
    }

    public Integer getCodSerialgrlt() {
        return codSerialgrlt;
    }

    public Integer getCodSerialAutor() {
        return codInteger;
    }


    public void setCodSerialgrlt(Integer codSerialgrlt) {
        this.codSerialgrlt = codSerialgrlt;
    }

    public void setCodSerialAutor(Integer codSerialAutor) {
        this.codInteger = codSerialAutor;
    }

    public void sumarcodserialgrlt(){
        codSerialgrlt++;
    }

    public void sumarcodserialAutor(){
        codInteger++;
    }
    
}
