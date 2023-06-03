/*
 Archivo: ControladorUsuarios.java
 Proyecto III - Biblioteca univalle
 31 de mayo de 2023

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

public class ControladorUsarios {
    private String apartadoUsario;
    private static String usarioEncabezado[] = {"ID usario" , " Nombre | Apellido", "Tipo Usario"};

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Usuario")){
                apartadoUsario = "usarioform";
                revisarUsarioCampos(null);
            }
        }
    }

    public static void limpiar (VentanaMain ventanaMain){
        ventanaMain.getFildUsarioCod().setText("");
        ventanaMain.getFildUsarioCod().setEditable(true);
        ventanaMain.getFildUsarioNombre().setText("");
        ventanaMain.getFildUsarioNombre().setEditable(true);
        ventanaMain.getDropUsarioTipo().setSelectedItem("Seleccionar");
        
    }

    public static String[] getTitlteUsario(){
        return usarioEncabezado;
    }

    public static boolean revisarUsarioCampos(VentanaMain ventanaMain){
        if(!revisarIdUsuario(ventanaMain)){
            return  false;
        }
        
        String nombreUsario = ventanaMain.getFildUsarioNombre().getText();
        if(nombreUsario.isEmpty() || nombreUsario.isBlank() || nombreUsario == null){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un nombre de Usuario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String tipoUSario = ventanaMain.getDropUsarioTipo().getSelectedItem().toString();
        if(tipoUSario.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese el tipo de Usuario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    
    }

    private static boolean revisarIdUsuario(VentanaMain ventanaMain) {
        String stringIdUsuariov = ventanaMain.getFildUsarioCod().getText();
        try{
            Integer idUsuario = Integer.valueOf(stringIdUsuariov);
            if(idUsuario <=0 || idUsuario <=8)
                throw new NumberFormatException();
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"Por favor ingrese un número de documento válido, sin puntos ni espacios, solo números y no mayor 8\nEjemplo: 11440000", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static Usuarios crearUsuario(VentanaMain ventanaMain){
        String stringIdUsuario = ventanaMain.getFildUsarioCod().getText();
        Integer idUsuario = Integer.valueOf(stringIdUsuario);
        String nombresUsario = ventanaMain.getFildUsarioNombre().getText();
        String tipoUsuario = ventanaMain.getDropUsarioTipo().getSelectedItem().toString();
        

        Usuarios usuario = new Usuarios(idUsuario, nombresUsario, tipoUsuario);
        return usuario;
    }
    
}
