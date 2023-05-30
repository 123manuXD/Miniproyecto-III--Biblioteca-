/*
 Archivo: ControladorVentana.java
 Proyecto III - Biblioteca univalle
 28 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 

  Esta es la clase que se encargara de controlar todo el programa, los botones de la vista, desde esta clase
  se conectan todas las capas de la logica a la vista.

  -Relacion de vista Ventana Main.
  -Relacion modelo (logica) Biblioteca(conoce y administra elementos del sistema)
 
 */

package controlador;

import DAO.*;
import modelo.*;
import vista.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;

public class ControladorVentana {
    private String apartadobox;
    private VentanaMain ventanaMain;
    private JTable datosTable = new JTable();
    private JScrollPane paneltabla = new JScrollPane();
    String  rutaArchivoBin = "./src/Archivos/biblioteca.bin";
    private Biblioteca biblioteca;
    private Integer serialGenero;

    public ControladorVentana(VentanaMain ventanaMain){
        this.ventanaMain = ventanaMain;

        this.biblioteca = Managerecords.leerArchivoBin(rutaArchivoBin);
        if(biblioteca == null)
        biblioteca = new Biblioteca("Biblioteca Universidad del Valle");

        serialGenero = biblioteca.getCodSerialgrlt();

        ventanaMain.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.setCodSerialgrlt(serialGenero);
                Managerecords.guardarArchivoBin(biblioteca, rutaArchivoBin);
                System.exit(0);
            }
        });

        ventanaMain.setVisible(true);
        apartadobox = (String)ventanaMain.getApartado().getSelectedItem();
        
    }
}
