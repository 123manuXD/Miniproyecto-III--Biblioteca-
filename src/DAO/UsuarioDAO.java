/*
 Archivo: GnrliteraDAOimp.java
 Proyecto III - Biblioteca univalle
 31 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de crear una interfaz que implementara UsarioDAOimp.java 
 */

package DAO;

import modelo.*;

public interface UsuarioDAO extends ComunDAO<Usuarios> {
    public abstract String[][] getListaTipo(String tipoUser);
    
}
