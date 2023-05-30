
/*
 Archivo: app.java
 Proyecto III - Biblioteca univalle
 21 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */

import controlador.ControladorVentana;
import vista.VentanaMain;

 public class App {
    public static void main(String args[]){
        VentanaMain ventanaMain = new VentanaMain();
        ControladorVentana actualizarVentanaMain = new ControladorVentana(ventanaMain);

    }
}