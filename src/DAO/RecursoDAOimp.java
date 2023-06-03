/*
 Archivo: RecursoDAOimp.java
 Proyecto III - Biblioteca univalle
 02 de junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de definir la lógica del Data Access Object 
  para los objetos de tipo Recurso.
 */

package DAO;

import modelo.*;
import java.util.*;
import java.io.Serializable;

public class RecursoDAOimp implements RecursoDAO, Serializable {
    public static final long serialVersionUID = 1L;
    private HashMap<Integer, Recurso> mapa;

    public RecursoDAOimp(){
        this.mapa = new HashMap<>();
    }

    @Override
    public boolean añadir(Recurso kon) {
        if(mapa.containsKey(kon.getCodigo()))
            return false;
        
        mapa.put(kon.getCodigo(), kon);
        return true;
    }

    @Override
    public boolean elementoPresente(Integer identificador) {
        if(mapa.containsKey(identificador))
            return true;
        return false;
    }

    @Override
    public Recurso getElemento(Integer identificador) {
        if(mapa.containsKey(identificador))
            return mapa.get(identificador);
        return null;
    }

    @Override
    public String[][] getListables() {
        ArrayList<Recurso> lista = new ArrayList<>();

        if(!mapa.isEmpty())
            for(Map.Entry<Integer, Recurso> pareja: mapa.entrySet())
                lista.add(pareja.getValue());
        
        return Array.getArray(null);
    }

    @Override
    public boolean actualizar(Integer identificador, Recurso kon) {
        if(identificador.equals(kon.getCodigo())){
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
