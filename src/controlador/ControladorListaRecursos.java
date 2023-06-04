/*
 Archivo: ControladorListaRecursos.java
 Proyecto III - Biblioteca univalle
 03 de junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */


package controlador;
import modelo.*;
import vista.*;

import java.util.*;
import java.math.*;
import javax.swing.*;
import java.text.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.table.*;

public class ControladorListaRecursos {
    private static String listaRecursosEncabezado[] = {"Id recurso","recurso","Fecha de registro","Regresar Recurso","Recurso Regresado"};

    public static void limpiar(VentanaRecursos ventanaRecursos){
        ventanaRecursos.getFildPrestamoIDRecurso().setText("");
        ventanaRecursos.getFildPrestamoRecurso().setText("");
        ventanaRecursos.getFildRegistroPrestamo().setText("");
        ventanaRecursos.getFildPordevolver().setText("");
        ventanaRecursos.getFildRegresado().setText("");
    }

    public static String[] getTitleListaRecursos(){
        return listaRecursosEncabezado;
    }

    public static boolean revisarIdRecurso(VentanaRecursos ventanaRecursos){
        String sTidRecurso = ventanaRecursos.getFildPrestamoIDRecurso().getText();
        try{
            Integer.valueOf(sTidRecurso);

        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Por favor ingrese una identificación de Recurso válida, sin puntos ni espacios, solo números.\nEjemplo: 8767890", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean revisarListacampos(VentanaRecursos ventanaRecursos){
        if(!revisarIdRecurso(ventanaRecursos))
        return false;

        String fechaRegistro = ventanaRecursos.getFildRegistroPrestamo().getText();
        try{
            LocalDate.parse(fechaRegistro);
        }catch(DateTimeParseException exception){
            JOptionPane.showMessageDialog(null,"Por favor ingrese una fecha con el formato AAAA-MM-DD.\n Ejemplo: 1990-01-01", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String stringDevol = ventanaRecursos.getFildPordevolver().getText();
        try{
            LocalDate.parse(stringDevol);
        }catch(DateTimeParseException exception){
            JOptionPane.showMessageDialog(null,"Por favor ingrese una fecha con el formato AAAA-MM-DD.\n Ejemplo: 1990-01-01", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static void crearTabla(DefaultTableModel modelTlabe, VentanaRecursos ventanaRecursos ){
        String tablaIdListaId = modelTlabe.getValueAt(ventanaRecursos.getTablaDatosPrestamo().getSelectedRow(),0).toString();
        String tablaListaRec = modelTlabe.getValueAt(ventanaRecursos.getTablaDatosPrestamo().getSelectedRow(),1).toString();
        String tablaDRegistro = modelTlabe.getValueAt(ventanaRecursos.getTablaDatosPrestamo().getSelectedRow(),2).toString();
        String tablaDPorRegresar = modelTlabe.getValueAt(ventanaRecursos.getTablaDatosPrestamo().getSelectedRow(),3).toString();
        String tablaDRegresado = modelTlabe.getValueAt(ventanaRecursos.getTablaDatosPrestamo().getSelectedRow(),4).toString();

        ventanaRecursos.getFildPrestamoIDRecurso().setText(tablaIdListaId);
        ventanaRecursos.getFildPrestamoRecurso().setText(tablaListaRec);
        ventanaRecursos.getFildRegistroPrestamo().setText(tablaDRegistro);
        ventanaRecursos.getFildPordevolver().setText(tablaDPorRegresar);
        ventanaRecursos.getFildRegresado().setText(tablaDRegresado);
    }
}
