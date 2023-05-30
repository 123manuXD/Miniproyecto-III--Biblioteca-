/*
 Archivo: AutoresDAOimp.java
 Proyecto III - Biblioteca univalle
 30 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de definir la lógica del Data Access Object 
  para los objetos de tipo genero literario.
 */

package DAO;

import modelo.*;
import java.io.Serializable;
import java.util.*;

public class AutoresDAOimp implements AutoresDAO, Serializable{
    public static final long serialVersionUID = 1L;
    private HashMap<Integer, Autores> mapa;

    public AutoresDAOimp(){
        this.mapa = new HashMap<>();
    }

    @Override
    public boolean añadir(Autores kon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'añadir'");
    }

    @Override
    public boolean elementoPresente(Integer identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementoPresente'");
    }

    @Override
    public Autores getElemento(Integer identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElemento'");
    }

    @Override
    public String[][] getListables() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListables'");
    }

    @Override
    public boolean actualizar(Integer identificador, Autores kon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(Integer identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
