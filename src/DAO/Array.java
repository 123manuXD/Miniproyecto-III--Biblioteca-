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

    public static <Kon extends Listable> String[][] getArray(ArrayList<Kon> lista){
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

    public static String[][] getArrayRecursos(Biblioteca biblioteca, HashMap<Integer, String[]> listaRecursos ){
        if(listaRecursos.isEmpty())
            return null;
        
        int numeroFilas = listaRecursos.size();
        int numeroColumnas = 6;
        String[][] arreglo = new String[numeroFilas][numeroColumnas];
        int contadorFila = 0;
        for(Map.Entry<Integer, String[]> pareja : listaRecursos.entrySet()){
            Integer iDrecurso = pareja.getKey();
            arreglo[contadorFila][0] = String.valueOf(iDrecurso);
            arreglo[contadorFila][1] = String.valueOf(biblioteca.getRecurso().getElemento(iDrecurso).getTitulo());
            arreglo[contadorFila][2] = pareja.getValue()[0];
            arreglo[contadorFila][3] = pareja.getValue()[1];
            arreglo[contadorFila][4] = pareja.getValue()[2];
            contadorFila++;
        }
        return arreglo;
    }
    
}
