/*
 Archivo: Controlergnltr.java
 Proyecto III - Biblioteca univalle
 27 de mayo de 2023

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

import javax.swing.*;
import javax.swing.table.*;

public class ControladorGenero {
    private String apartadoGenero;
    private static String generoliterarioEncabezado[] = {"ID genero literario", "Nombre genero literario"};
    
    
    public static void pintar(VentanaMain ventanaMain, Integer codSerialgrlt) {
        ventanaMain.getFiledcodg().setText(String.valueOf(codSerialgrlt));
    }


    public static void limpiar(VentanaMain ventanaMain, Integer codSerialgrlt){
        //Este metodo dejara los valores default() del codigo generado a difault
        ventanaMain.getFiledcodg().setText(String.valueOf(codSerialgrlt));
        ventanaMain.getFieldnameg().setText("");
    }

    public static String[] getTitleGenero() {
        return generoliterarioEncabezado;
    }

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Genero")){
                apartadoGenero = "generoform";
                revisarGeneroCampos(null);
            }
        }
    }

    public static boolean revisarGeneroCampos(VentanaMain ventanaMain){
        String generoLiterariochk = ventanaMain.getFieldnameg().getText();
        if(generoLiterariochk.isEmpty() || generoLiterariochk.isBlank() || generoLiterariochk == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un genero Literario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static Generoliterario crearGeneroliterario (VentanaMain ventanaMain){
        String stringIDGenero = ventanaMain.getFiledcodg().getText();
        Integer idGenero = Integer.valueOf(stringIDGenero);
        String generoLiterariox = ventanaMain.getFieldnameg().getText();

        Generoliterario generoLiterario =  new Generoliterario(idGenero, generoLiterariox);
        return generoLiterario;

    }

    public static void crearTabla(DefaultTableModel modtable, VentanaMain ventanamain){
        //Metodo usado para crear una tabla y traer los valores de la vista para ponerlo
        String tablaIdGenero = modtable.getValueAt(ventanamain.getDatosEnTabla().getSelectedRow(),0).toString();
        String tablageneroLiteario = modtable.getValueAt(ventanamain.getDatosEnTabla().getSelectedRow(),1).toString();

        ventanamain.getFiledcodg().setText(tablaIdGenero);
        ventanamain.getFieldnameg().setText(tablageneroLiteario);

    }
}



