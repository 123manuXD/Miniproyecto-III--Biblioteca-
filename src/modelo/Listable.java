/*
 Archivo: Listable.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */

package modelo;

public interface Listable {
        public abstract Integer getIdentificacion();
        public abstract int getTotalDatos();
        public abstract String getDato(int pkDato);
    
}
