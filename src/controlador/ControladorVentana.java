/*
 Archivo: ControladorVentana.java
 Proyecto III - Biblioteca univalle
 28 de mayo de 2023

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

import javax.management.ValueExp;
import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.xml.transform.Source;

import java.util.*;
import java.awt.*;

public class ControladorVentana {
    private String apartadoTipo;
    private String gluglu;
    private String apartadoFormulario;
    private VentanaMain ventanaMain;
    private JTable datosTable = new JTable();
    private JScrollPane paneltabla = new JScrollPane();
    String  rutaArchivoBin = "./src/Archivos/biblioteca.bin";
    private Biblioteca biblioteca;
    private Integer serialGenero;
    private Integer serialAutor;
    private Integer serialRecurso;
    

    public ControladorVentana(VentanaMain ventanaMain){
        this.ventanaMain = ventanaMain;
        //this.biblioteca = Managerecords.leerArchivoBin(rutaArchivoBin);
        if(biblioteca == null)
        biblioteca = new Biblioteca("Biblioteca Universidad del Valle");

        serialGenero = biblioteca.getCodSerialgrlt();
        serialAutor = biblioteca.getCodSerialAutor();
        serialRecurso = biblioteca.getCodSerialRecurso();
        gluglu = ventanaMain.getStringtipousario();
        System.out.println(gluglu);

        ventanaMain.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.setCodSerialgrlt(serialGenero);
                Managerecords.guardarArchivoBin(biblioteca, rutaArchivoBin);
                System.exit(0);
            }
        });

        ventanaMain.setVisible(true);
        this.ventanaMain.addListener(new AddListener());
        this.ventanaMain.addFocusListener(new setfocus());
        apartadoTipo = (String)ventanaMain.getApartado().getSelectedItem();
        //pintartabla(apartadoFormulario);
        
    }

    class setfocus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Metodo creado para llenar el Autor y genero Literario del recurso (Dependiendo de los ID)
            if(apartadoFormulario == "recursoform"){
                String stringIdAutor = ventanaMain.getFildRecusoAutor().getText();
                Integer idAutor;
                try{
                    idAutor = Integer.valueOf(stringIdAutor);
                } catch (NumberFormatException exception){
                    return;
                }

                if(biblioteca.getAutor().elementoPresente(idAutor)){
                    Autores autores = biblioteca.getAutor().getElemento(idAutor);
                    ventanaMain.getFildRecAV().setText(autores.getNombreAutor());
                } else {
                    ventanaMain.getFildRecAV().setText("");
                }

                String stringIdGenLt = ventanaMain.getFildRecursoGnlt().getText();
                Integer idGeneroLt;
                try{
                    idGeneroLt = Integer.valueOf(stringIdGenLt);
                } catch (NumberFormatException exception) {
                    return;
                }

                if(biblioteca.getGeneroLiterario().elementoPresente(idGeneroLt)){
                    Generoliterario generoliterario = biblioteca.getGeneroLiterario().getElemento(idGeneroLt);
                    ventanaMain.getFildRecGV().setText(generoliterario.getgeneroliterario());
                } else {
                    ventanaMain.getFildRecGV().setText("");
                }

            }
        }

    }

    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Genero")){
                apartadoFormulario = "generoform";
                ControladorGenero.pintar(ventanaMain, serialGenero);
            } else if (e.getActionCommand().equals("Autor")){
                ControladorAutores.pintar(ventanaMain, serialAutor);
                apartadoFormulario = "autoresform";
            } else if (e.getActionCommand().equals("Usuario")){
                apartadoFormulario = "usuarioform";
            }else if (e.getActionCommand().equals("Recurso")){
                ControladorRecurso.pintar(ventanaMain, serialRecurso);
                apartadoFormulario = "recursoform";
            }

            if(e.getActionCommand().equalsIgnoreCase("Agregar")){
                if(apartadoFormulario == "generoform"){
                    ControladorGenero.pintar(ventanaMain, serialGenero);
                    if(ControladorGenero.revisarGeneroCampos(ventanaMain)){
                        Generoliterario nuevogeneroliterario = ControladorGenero.crearGeneroliterario(ventanaMain);
                        Integer codigoGeneroLiterario = nuevogeneroliterario.getcodigogenero();
                        String nombreGeneroLiterario = nuevogeneroliterario.getgeneroliterario();
                        if(biblioteca.getGeneroLiterario().añadir(nuevogeneroliterario)){
                                JOptionPane.showMessageDialog(null, "" + nombreGeneroLiterario + " Ha sido agregado como nuevo genero literario", "Agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                                serialGenero++;
                        } else {
                                JOptionPane.showMessageDialog(null,"El producto " + codigoGeneroLiterario + " " + nombreGeneroLiterario + " ya se encuentra registrado en el sistema, no lo puede volver a registrar.", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                } else if (apartadoFormulario == "autoresform"){
                    ControladorAutores.pintar(ventanaMain, serialAutor);
                    if(ControladorAutores.revisarAutoresCampos(ventanaMain)){
                        Autores nuevoAutor = ControladorAutores.crearAutores(ventanaMain);
                        Integer codigoAutor = nuevoAutor.getCodigoAutor();
                        String nombreAutor = nuevoAutor.getNombreAutor();
                        if(biblioteca.getAutor().añadir(nuevoAutor)){
                        JOptionPane.showMessageDialog(null, " Nuevo Autor " + "\n Codigo:" +codigoAutor + "\n Nombre|Apellido: " + nombreAutor + " \n Ha sido agregado como nuevo autor", "Agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                            serialAutor++;
                        } else {
                            JOptionPane.showMessageDialog(null, "El Autor" + "/n Codigo:" +codigoAutor + "/n Nombre|Apellido: " + nombreAutor + " Ya se encuetra en el sistema.", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (apartadoFormulario == "usuarioform"){
                    if(ControladorUsarios.revisarUsarioCampos(ventanaMain)){
                        Usuarios nuevoUsuario = ControladorUsarios.crearUsuario(ventanaMain);
                        Integer codigoUsuario = nuevoUsuario.getCodigoUsuario();
                        String nombreUsuario = nuevoUsuario.getNombreUsuario();
                        String tipoUsuario = nuevoUsuario.getTipoUsuario();
                        if(biblioteca.getUsuario().añadir(nuevoUsuario)){
                            JOptionPane.showMessageDialog(null, " EL usuario  " + "\n Codigo: " + codigoUsuario + "\n Nombre|Apellido: " + nombreUsuario + "\n De tipo: " + tipoUsuario + " \n Ha sido agregado como nuevo usuario " ,"Agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, " EL Usuario " + "\n Codigo: " +codigoUsuario + "\n Nombre|Apellido: " + nombreUsuario + " \n Ya se encuetra en el sistema", "Advertencia", JOptionPane.INFORMATION_MESSAGE); 
                        }
                    }
                }else if (apartadoFormulario == "recursoform"){
                    if(ControladorRecurso.revisarRecursoCampos(ventanaMain)){
                        Recurso nuevoRecurso = ControladorRecurso.crearRecurso(ventanaMain);
                        Integer codigoRecurso = nuevoRecurso.getCodigo();
                        String tituloRecurso = nuevoRecurso.getTitulo();
                        String autorRecurso = nuevoRecurso.getAutorRecursoS();
                        String generoRecurso = nuevoRecurso.getGeneroRecursoS();
                        if(biblioteca.getRecurso().añadir(nuevoRecurso)){
                            JOptionPane.showMessageDialog(null, "El recurso " + tituloRecurso + "\n Ha sido agregado como nuevo Recurso \n Codigo:" + codigoRecurso + "\n Autor: " + autorRecurso + "\n Genero Literaio: "+ generoRecurso + "", "Recurso agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El recurso " + tituloRecurso + "\n Ya se encuentra en el sistema \n Codigo:" + codigoRecurso + "\n Autor: " + autorRecurso + "\n Genero Literaio: "+ generoRecurso + "", "Recurso agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                //terminar con metodo
            } else if (e.getActionCommand().equalsIgnoreCase("limpiar")){
                if(apartadoFormulario == "generoform"){
                    ControladorGenero.limpiar(ventanaMain, serialGenero);
                } else if (apartadoFormulario == "autoresform"){
                    ControladorAutores.limpiar(ventanaMain, serialAutor);
                } else if (apartadoFormulario == "usuarioform"){
                    ControladorUsarios.limpiar(ventanaMain);
                } else if (apartadoFormulario == "recursoform"){
                    ControladorRecurso.limpiar(ventanaMain, serialRecurso);
                }
                
                
            } else if(e.getActionCommand().equalsIgnoreCase("Editar")){
                if(apartadoFormulario == "generoform"){
                    if(ControladorGenero.revisarGeneroCampos(ventanaMain)){
                        Generoliterario nuevGeneroliterario = ControladorGenero.crearGeneroliterario(ventanaMain);
                        Integer idGelt = nuevGeneroliterario.getcodigogenero();
                        String nombreGenerolt = nuevGeneroliterario.getgeneroliterario();
                        if(biblioteca.getGeneroLiterario().elementoPresente(idGelt) && biblioteca.getGeneroLiterario().actualizar(idGelt, nuevGeneroliterario)){
                            JOptionPane.showMessageDialog(null, " !Genero Literario Actualizado! " + "\n Codigo: " + idGelt + "\n Genero Literario: " + nombreGenerolt+ "", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El genero Literario " + "\n Codigo: " + idGelt + "\n Genero Literario: " + nombreGenerolt+ "\n No existe, debe registrarlo en el sistema", "Advertencia",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (apartadoFormulario =="autoresform"){
                    if(ControladorAutores.revisarAutoresCampos(ventanaMain)){
                        Autores nuevoauAutor = ControladorAutores.crearAutores(ventanaMain);
                        Integer idAutor = nuevoauAutor.getCodigoAutor();
                        String nombreAutor = nuevoauAutor.getNombreAutor();
                        String relavanciaAutor = nuevoauAutor.getRelevancia();
                        if(biblioteca.getAutor().elementoPresente(idAutor) && biblioteca.getAutor().actualizar(idAutor, nuevoauAutor)){
                            JOptionPane.showMessageDialog(null, " !Autor  Actualizado! " + "\n Codigo: " + idAutor + "\n Autor: " + nombreAutor + "\n Relevancia" + relavanciaAutor, "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Autor " + "\n Codigo: " + idAutor + "\n Autor: " + nombreAutor + "\n Relevancia" + relavanciaAutor + "\n No existe, debe registrarlo en el sistema", "Advertencia",JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                }

            } else if (e.getActionCommand().equalsIgnoreCase("Eliminar")){
                if(apartadoFormulario == "generoform"){
                    String stringcodgenero = ventanaMain.getFiledcodg().getText();
                    Integer idGelt = Integer.valueOf(stringcodgenero);
                    if(biblioteca.getGeneroLiterario().elementoPresente(idGelt)){
                        String nombreGeneroLiterario = biblioteca.getGeneroLiterario().getElemento(idGelt).getgeneroliterario();
                        int seguir = JOptionPane.showConfirmDialog(null , "¿Relamente desea eliminar el genero literario" + idGelt + "" + nombreGeneroLiterario + " ?\n Esta acción es Irreversible", "Eliminar Genero Literario" ,JOptionPane.YES_NO_OPTION);
                        if(seguir == JOptionPane.YES_OPTION && biblioteca.getGeneroLiterario().eliminar(idGelt)){
                            JOptionPane.showMessageDialog(null, "Genero Literario " + "\n Codigo: "+ idGelt + "\n Genero Literario:  " + nombreGeneroLiterario + "\n Fue eliminado con exito", "Eliminacipon",JOptionPane.INFORMATION_MESSAGE);
                            ControladorGenero.limpiar(ventanaMain, serialGenero);
                        } else {
                            JOptionPane.showMessageDialog(null, "El genero literario: " + "\n Codigo: " + idGelt + "\n Genero Literario: " + nombreGeneroLiterario + " No existe en el sistema", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }else if( apartadoFormulario == "autoresform"){
                    String stringCodAutor = ventanaMain.getFildAutorcod().getText();
                    Integer idAutor = Integer.valueOf(stringCodAutor);
                    if(biblioteca.getAutor().elementoPresente(idAutor)){
                        String nombreAutor = biblioteca.getAutor().getElemento(idAutor).getNombreAutor();
                        int seguir = JOptionPane.showConfirmDialog(null , "¿Relamente desea eliminar el Autor " + nombreAutor + "(" + idAutor + " )?\n Esta acción es Irreversible", "Eliminar Autor" ,JOptionPane.YES_NO_OPTION);
                        if(seguir == JOptionPane.YES_OPTION && biblioteca.getAutor().eliminar(idAutor)){
                            JOptionPane.showMessageDialog(null, "El Autor " + "\n Codigo: "+ idAutor + "\n De nombre:  " + nombreAutor + "\n Fue eliminado con exito", "Eliminacipon",JOptionPane.INFORMATION_MESSAGE);
                            ControladorGenero.limpiar(ventanaMain, serialGenero);
                        } else {
                            JOptionPane.showMessageDialog(null, "El Autor"  + nombreAutor + "(" + idAutor +  ") \n No existe en el sistema", "Advertencia", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    
                }
            }
        }
          
    }

    public void pintartabla(String apartadoTipo){
        datosTable = ventanaMain.getDatosEnTabla();
        paneltabla = ventanaMain.getPaneltable();
        paneltabla.removeAll();
        datosTable.removeAll();

        if(apartadoTipo == "Genero literario"){
            String[][] generoLiterarioData = biblioteca.getGeneroLiterario().getListables();
            datosTable = new JTable(ControladorVentana.asignarModelTabla(generoLiterarioData, ControladorGenero.getTitleGenero()));

            ventanaMain.setDatosEnTabla(datosTable);
            paneltabla = new JScrollPane(ventanaMain.getDatosEnTabla());
            ventanaMain.setPaneltable(paneltabla); 

        }

        datosTable.addMouseListener(new test());
    } 
    // CAMBIAR POR EL METODO DE IDENTIFICAR (PARA VER SI FUNCIONA POR LO MENOS LISTAR LA TABLA)
    class test implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel tableModel= (DefaultTableModel)ventanaMain.getDatosEnTabla().getModel();

            if(apartadoTipo == "Genero literario"){
                ControladorGenero.crearTabla(tableModel, ventanaMain);
            }
        
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

    public static TableModel asignarModelTabla (String[][] datos, String[] encabezado){
        TableModel model = new DefaultTableModel(datos, encabezado){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        }; 
        
        return model;

    }
}
