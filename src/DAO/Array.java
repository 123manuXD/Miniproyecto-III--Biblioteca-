/*
 Archivo: Array.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
  Creado Unicamente con la intencion de convertir las listas en arreglos bidimensionales de tipo String, para poder
  desplegar los objetos  en la interfaz grafica del programa.
 */


package DAO;
import modelo.*;
import java.io.Serializable;
import java.math.*;
import java.util.*;
import java.text.*;

public class Array implements Serializable{
    public static final long serialVersionUID = 1L;

    public static <K extends Listable> String[][] getArray(ArrayList<K> lista){
        if(lista.isEmpty())
            return null;

        int numeroFilas = lista.size();
        int numeroColumnas = lista.get(0).getTotalDatos();
        String[][] arreglo = new String[numeroFilas][numeroColumnas];

        for(int fila=0; fila < numeroFilas; fila++)
            for(int columna=0; columna < numeroColumnas; columna++)
                arreglo[fila][columna] = lista.get(fila).getDato(columna);

        return arreglo;
    }
    
}
