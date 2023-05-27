/*
 Archivo: ComunDAO.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de declarar los metodos basicos usados por un sistema DAO
  Donde Identificacion se va a tomar como una llave primaria basica para los demás DAO.
 */

package DAO;

public interface ComunDAO <KON> {
    public abstract boolean añadir(KON kon);
    public abstract boolean elementoPresente(Integer identificacion);
    public abstract KON getElemento(Integer identificacion);
    public abstract String[][] getListables();
    public abstract boolean actualizar(Integer identificacion, KON kon);
    public abstract boolean eliminar(Integer identificacion);
}