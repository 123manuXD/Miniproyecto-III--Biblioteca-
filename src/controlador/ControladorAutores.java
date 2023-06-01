/*
 Archivo: ControladorAutores.java
 Proyecto III - Biblioteca univalle
 31 de mayo de 2022

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
import javax.swing.*;
import javax.swing.table.*;

public class ControladorAutores {
    private String apartadoAutores;
    private static String autoresEncabezado[] = {"ID Autor", "Nombres | Apellido", "Relevancia"};

    public static void pintar(VentanaMain ventanaMain, Integer codInteger){ 
        ventanaMain.getFildAutorcod().setText(String.valueOf(codInteger));
    }

    public static void limpiar(VentanaMain ventanaMain, Integer codInteger){
        ventanaMain.getFildAutorcod().setText(String.valueOf(codInteger));
        ventanaMain.getFildAutorname().setText("");
        ventanaMain.getFildAutorRele().setText("");
    }

    public static String[] getTitleAutores(){
        return autoresEncabezado;
    }

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Autor")){
                apartadoAutores = "autorform";
                revisarAutoresCampos(null);
                
            }
        }
    }

    public static boolean revisarAutoresCampos(VentanaMain ventanaMain){
        String nombreAutor = ventanaMain.getFildAutorname().getText();
        if(nombreAutor.isEmpty() || nombreAutor.isBlank() || nombreAutor == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese el nombre del autor", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        } 

        String relevanciaAutor = ventanaMain.getFildAutorRele().getText();
        if(relevanciaAutor.isEmpty() || relevanciaAutor.isBlank() || relevanciaAutor == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese la relevancia del autor" + "\n tenga en cuenta ingresar (baja, media, alta)", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        
        return true;
    } 

    public static Autores crearAutores (VentanaMain ventanaMain){
        String stringIdAutores = ventanaMain.getFildAutorcod().getText();
        Integer idAutor = Integer.valueOf(stringIdAutores);
        String autorNames = ventanaMain.getFildAutorname().getText();
        String autorRelevancia = ventanaMain.getFildAutorRele().getText();

        Autores autores = new Autores(idAutor, autorNames, autorRelevancia);
        return autores;
    }

    public static void crearTabla(DefaultTableModel modeloTabla, VentanaMain ventanaMain){
        String tablaIdAutor = modeloTabla.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),0).toString();
        String tablaAutorN = modeloTabla.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),1).toString();
        String tablaAutorR = modeloTabla.getValueAt(ventanaMain.getDatosEnTabla().getSelectedRow(),2).toString();

        ventanaMain.getFildAutorcod().setText(tablaIdAutor);
        ventanaMain.getFildAutorname().setText(tablaAutorN);
        ventanaMain.getFildAutorRele().setText(tablaAutorR);

    }
}
