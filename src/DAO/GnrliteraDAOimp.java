/*
 Archivo: GnrliteraDAOimp.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2022

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

public class GnrliteraDAOimp implements GnrliteraDAO, Serializable{
    public static final long serialVersionUID = 1L;
    private HashMap<Integer, generoliterario> mapa;

    @Override
    public boolean añadir(generoliterario kon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'añadir'");
    }

    @Override
    public boolean elementoPresente(Integer identificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementoPresente'");
    }

    @Override
    public generoliterario getElemento(Integer identificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElemento'");
    }

    @Override
    public String[][] getListables() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListables'");
    }

    @Override
    public boolean actualizar(Integer identificacion, generoliterario kon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(Integer identificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public String[][] getlistarApartado(String apartado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getlistarApartado'");
    }

}