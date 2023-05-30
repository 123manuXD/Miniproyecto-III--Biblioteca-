/*
 Archivo: Managerecords.java
 Proyecto III - Biblioteca univalle
 28 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */


package modelo;

import java.io.*;
import java.time.*;

public class Managerecords {
    public Managerecords() { 
    }

    public static Biblioteca leerArchivoBin (String rutaArchivo){
        ObjectInputStream objInputStream = null;
        Biblioteca biblioteca = null;

        try{
            objInputStream = new ObjectInputStream(new FileInputStream(rutaArchivo));
            biblioteca = (Biblioteca) objInputStream.readObject();
            System.out.println("¡Archivo binario leído!");

        } catch(FileNotFoundException exception) {
            System.out.println("El archivo binario aun no ha sido creado. No se preocupe, el archivo se generará automaticamente al cerrar la aplicación");

        } catch(IOException exception){
            System.out.println("Error leyendo el archivo binario.");
            System.out.println("Error leyendo el archivo binario. " + exception.getMessage());

        } catch(ClassNotFoundException exception) {
            System.out.println("Conflicto entre clases.");
            System.out.println("Conflicto entre clases." + exception.getMessage());

        } finally {
            if(objInputStream != null)
                try {
                    objInputStream.close();
                } catch (IOException exception) {
                    System.out.println("Error cerrando el archivo objInputStream.");
                    System.out.println("Error cerrando el archivo objInputStream" + exception.getMessage());
                }
        }
        return biblioteca;
    }

    public static boolean guardarArchivoBin (Biblioteca biblioteca, String rutaArchivo){
        boolean operacionRealizada = false;
        ObjectOutputStream objOutputStream = null;

        try{
            objOutputStream = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
            objOutputStream.writeObject(biblioteca);
            System.out.println("¡Archivo binario guardado!");
            operacionRealizada = true;

        } catch(FileNotFoundException exception){ 
            System.out.println("Hay un problema con la ruta donde se guardará el archivo binario. Por favor verificar la ruta.");
            // System.out.println("Hay un problema con la ruta donde se guardará el archivo binario. Por favor verificar la ruta." + exception.getMessage());

        } catch(IOException exception){
            System.out.println("Error guardando el archivo binario.");
            // System.out.println("Error guardando el archivo binario. " + exception.getMessage() + exception.getStackTrace());

        } finally {
            if(objOutputStream != null){
                try {
                    objOutputStream.close();
                } catch (IOException exception) {
                    System.out.println("Error cerrando el archivo objOutputStream.");
                    // System.out.println("Error cerrando el archivo objOutputStream" + exception.getMessage());
                }
            }
        }
        return operacionRealizada;

    }
}
