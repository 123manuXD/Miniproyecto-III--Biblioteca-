/*
 Archivo: ComunDAO.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de declarar los metodos basicos usados por un sistema DAO
  Donde identificador se va a tomar como una llave primaria basica para los demás DAO.
 */

package DAO;

public interface ComunDAO <KON> {
    public abstract boolean añadir(KON kon);
    public abstract boolean elementoPresente(Integer identificador);
    public abstract KON getElemento(Integer identificador);
    public abstract String[][] getListables();
    public abstract boolean actualizar(Integer identificador, KON kon);
    public abstract boolean eliminar(Integer identificador);
}