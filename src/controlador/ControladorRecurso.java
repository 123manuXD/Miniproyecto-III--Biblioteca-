/*
 Archivo: ControladorRecurso.java
 Proyecto III - Biblioteca univalle
 02 de junio de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */


package controlador;

import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.security.CodeSigner;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.table.*;


public class ControladorRecurso {
    private String apartadoRecurso;
    private static String recursoEncabezado[] = {"ID recurso", "Titulo", "Fecha Registro","Tipo Recurso","ID Recurso Autor", "ID Recurso Genero", "AUtor", "Genero"};
  

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Recurso")){
                apartadoRecurso = "recursoForm";
                revisarRecursoCampos(null);
            }
        }
    }

    public static void pintar(VentanaMain ventanaMain, Integer codSerialRecurso) {
        ventanaMain.getFildRecursoCod().setText(String.valueOf(codSerialRecurso));
        ventanaMain.getFildRecursoDate().setText(String.valueOf(LocalDate.now()));
    }

    public static void limpiar(VentanaMain ventanaMain, Integer codSerialRecurso){
        ventanaMain.getFildRecursoCod().setText(String.valueOf(codSerialRecurso));
        ventanaMain.getFildRecursoTitle().setText("");
        ventanaMain.getFildRecursoDate().setText(String.valueOf(LocalDate.now()));
        ventanaMain.getDropRecursoTipo().setSelectedItem("Seleccionar");
        ventanaMain.getFildRecusoAutor().setText("");
        ventanaMain.getFildRecursoGnlt().setText("");
        ventanaMain.getFildRecAV().setText("");
        ventanaMain.getFildRecGV().setText("");
    }

    public static String[] getTitleRecurso(){
        return recursoEncabezado;
    }

    public static boolean revisarRecursoCampos(VentanaMain ventanaMain){
        String recursoTitle = ventanaMain.getFildRecursoTitle().getText();
        if(recursoTitle.isEmpty() || recursoTitle.isBlank() || recursoTitle == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese el Titulo del recurso", "Advertencia Titulo Recurso", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String tipoRecurso = ventanaMain.getDropRecursoTipo().getSelectedItem().toString();
        if(tipoRecurso.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese el tipo de recurso, si es libro o revista", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String RecursoAutorID = ventanaMain.getFildRecusoAutor().getText();
        try {
            Integer.valueOf(RecursoAutorID);
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un ID valido de autor sin puntos ni comas" + "\n Ejemplo: 1040780" , "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String nombreAutorRec = ventanaMain.getFildRecAV().getText();
        if(nombreAutorRec.isEmpty() || nombreAutorRec.isBlank()){
            JOptionPane.showMessageDialog(null, "El Autor que ingreso no corresponde a ningun Autor dentro del sistema\n Verifique el Id que ingreso o registe el autor en | Autores | " , "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String RecursoGeneroID = ventanaMain.getFildRecursoGnlt().getText();
        try {
            Integer.valueOf(RecursoGeneroID);
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un ID valido de Genero Literario sin punto ni comas" + "\n Ejemplo: 6500" , "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String generolitRec = ventanaMain.getFildRecGV().getText();
        if(generolitRec.isEmpty() || generolitRec.isBlank()){
            JOptionPane.showMessageDialog(null, "El Genero Literario que ingreso no corresponde a ningun Genero Literaio dentro del sistema\n Verifique el Id que ingreso o el genero Litrario en | Genero | " , "Advertencia", JOptionPane.ERROR_MESSAGE);

        }
        return true;

    }

    public static Recurso crearRecurso(VentanaMain ventanaMain){
        String stringIdRecurso = ventanaMain.getFildRecursoCod().getText();
        Integer idRecurso = Integer.valueOf(stringIdRecurso);
        String tituloRecurso = ventanaMain.getFildRecursoTitle().getText();
        String stringFechaRegistro = ventanaMain.getFildRecursoDate().getText();
        LocalDate fechaRegistro = LocalDate.parse(stringFechaRegistro);
        String tipoRecurso = ventanaMain.getDropRecursoTipo().getSelectedItem().toString();
        String stringIdAutorRec = ventanaMain.getFildRecusoAutor().getText();
        Integer idAutorRec = Integer.valueOf(stringIdAutorRec);
        String autorRec = ventanaMain.getFildRecAV().getText();
        String StringIdGenLt = ventanaMain.getFildRecursoGnlt().getText();
        Integer idGenLtrec = Integer.valueOf(StringIdGenLt);
        String generoLtRec = ventanaMain.getFildRecGV().getText();

        Recurso recurso = new Recurso(idRecurso, tituloRecurso, fechaRegistro, tipoRecurso, idAutorRec, autorRec, idGenLtrec, generoLtRec);
        return recurso;
    }

    public static void crearTabla(DefaultTableModel modelTlabe, VentanaMain ventanaMain){
        String tablaIdRecurso = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),0).toString();
        String tablaTituloRecurso = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),1).toString();
        String tablaFechaRegRec = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),2).toString();
        String tablatipoRecurso = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),3).toString();
        String tablaIdRecAutor = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),4).toString();
        String tablaRecAutor = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),5).toString();
        String tablaIdRecGelt = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),6).toString();
        String tablaRecGenlt = modelTlabe.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),7).toString();
        
        ventanaMain.getFildRecursoCod().setText(tablaIdRecurso);
        ventanaMain.getFildRecursoTitle().setText(tablaTituloRecurso);
        ventanaMain.getFildRecursoDate().setText(tablaFechaRegRec);
        ventanaMain.getDropRecursoTipo().setSelectedItem(tablatipoRecurso);
        ventanaMain.getFildRecusoAutor().setText(tablaIdRecAutor);
        ventanaMain.getFildRecAV().setText(tablaRecAutor);
        ventanaMain.getFildRecursoGnlt().setText(tablaIdRecGelt);
        ventanaMain.getFildRecGV().setText(tablaRecGenlt);
    }
    
}
