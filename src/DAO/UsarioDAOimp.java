/*
 Archivo: UsuarioDAOimp.java
 Proyecto III - Biblioteca univalle
 31 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de definir la lógica del Data Access Object 
  para los objetos de tipo autor
 */


package DAO;

import modelo.*;
import java.util.*;
import java.io.Serializable;


public class UsarioDAOimp implements UsuarioDAO, Serializable{
    public static final long serialVersionUID = 1L;
    private HashMap<Integer, Usuarios> mapa;

    public UsarioDAOimp(){
        this.mapa = new HashMap<>();
    }

    @Override
    public boolean añadir(Usuarios kon) {
        if(mapa.containsKey(kon.getCodigoUsuario()))
            return false;
        
        mapa.put(kon.getCodigoUsuario(), kon);
        return true;
    }

    @Override
    public boolean elementoPresente(Integer identificador) {
        if(mapa.containsKey(identificador))
            return true;
        return false;
    }

    @Override
    public Usuarios getElemento(Integer identificador) {
        if(mapa.containsKey(identificador))
            return mapa.get(identificador);
        return null;
    }

    @Override
    public String[][] getListables() {
        ArrayList<Usuarios> lista = new ArrayList<>();
        
        if(!mapa.isEmpty())
            for(Map.Entry<Integer, Usuarios> pareja: mapa.entrySet())
                lista.add(pareja.getValue());
                
        return Array.getArray(null);
    }

    @Override
    public boolean actualizar(Integer identificador, Usuarios kon) {
        if(identificador.equals(kon.getCodigoUsuario())){
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

    @Override
    public String[][] getListaTipo(String tipoUser) {
        ArrayList<Usuarios> lista = new ArrayList<>();

        if(!mapa.isEmpty())
            for(Map.Entry<Integer, Usuarios> pareja: mapa.entrySet())
                if(pareja.getValue().getTipoUsuario().equals(tipoUser))
                lista.add(pareja.getValue());

        return Array.getArray(null); 
    }
    
}
