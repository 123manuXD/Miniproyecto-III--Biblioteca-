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
        if(mapa.containsKey(kon.getCodigoAutor()))
            return false;
        
        mapa.put(kon.getCodigoAutor(), kon);
        return true;
    }

    @Override
    public boolean elementoPresente(Integer identificador) {
        if(mapa.containsKey(identificador))
            return true;
        return false;
    }

    @Override
    public Autores getElemento(Integer identificador) {
        if(mapa.containsKey(identificador))
            return mapa.get(identificador);
        return null;
    }

    @Override
    public String[][] getListables() {
        ArrayList<Autores> lista = new ArrayList<>();

        if(!mapa.isEmpty())
            for(Map.Entry<Integer, Autores> pareja: mapa.entrySet())
                lista.add(pareja.getValue());
        
        return Array.getArray(null);
    }

    @Override
    public boolean actualizar(Integer identificador, Autores kon) {
        if(identificador.equals(kon.getCodigoAutor())){
            mapa.replace(identificador, kon);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer identificador) {
        if(mapa.containsKey(identificador)){
            mapa.remove(identificador);
            return true;
        }
        return false;
    }
}
