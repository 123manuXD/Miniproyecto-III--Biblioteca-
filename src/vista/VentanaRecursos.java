/*
 Archivo: VentanaRerecurso.java
 Proyecto III - Biblioteca univalle
 21 de mayo de 2023

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */


package vista;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.tree.FixedHeightLayoutCache;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class VentanaRecursos extends JFrame {
    private JPanel jpanelDatos, jpanelcontenTable;
    private JPanel jpanelTabla = new JPanel();
    private Decolib im1, im2, im3, imb1, imb2, imb3;
    private JLabel lblfechaRe, lblfechaPodev, lblIdRecurso, lblRecurso, lblFechadev, txtfechahora;
    private JTextField fildPrestamoIDRecurso, fildPrestamoRecurso, fildPrestamoDev, fildPrestadoPdev, fildPrestamoReg;
    private JButton btnadd, btnclean, btndelete;
    private JTable tablaDatosPrestamo = new JTable();
    private JScrollPane panelTabla = new JScrollPane();
    private LocalDateTime fechaPrestamo;


    public VentanaRecursos(){
        iniciarComponentes();
        im1 = new Decolib("/img/vista2/fondoV2.png");
        im1.setBounds(0,0,1196,486);
        add(im1);
    }

    private void iniciarComponentes(){
        //Config JFRAME
        setSize(1196, 486);
        setLocationRelativeTo(null);
        setResizable(false);

        
        /*-------------------- FUENTES Y COLORES ---------------------------------- */
        Font nuevaTipografia1 = new Font("Courier New", Font.BOLD, 25);
        Color colorletrasfont = new Color(74,39,23);
        Color colorfondo2 = new Color(232, 246, 239);
        Color traspartente = new Color(0,0,0,0);


        /*-------------------- PANEL DE DATOS ---------------------------------- */
        jpanelDatos = new JPanel();
        jpanelDatos.setLayout(null);
        jpanelDatos.setBounds(26,20,572,346);
        jpanelDatos.setBackground(traspartente);
        add(jpanelDatos);

        lblIdRecurso = new JLabel("|Id| Recurso");
        lblIdRecurso.setBounds((int)24.5,(int)108.5,206,33);
        lblIdRecurso.setFont(nuevaTipografia1);
        lblIdRecurso.setForeground(colorletrasfont);

        lblRecurso = new JLabel("|T| Recurso");
        lblRecurso.setBounds((int)24.5,(int)154.5, 206, 33);
        lblRecurso.setFont(nuevaTipografia1);
        lblRecurso.setForeground(colorletrasfont);

        lblfechaRe = new JLabel("|F|Registro");
        lblfechaRe.setBounds((int)24.5,(int)197.5, 206, 33);
        lblfechaRe.setFont(nuevaTipografia1);
        lblfechaRe.setForeground(colorletrasfont);

        lblfechaPodev = new JLabel("Debe|regresar");
        lblfechaPodev.setBounds((int)24.5,(int)243.5, 206, 33);
        lblfechaPodev.setFont(nuevaTipografia1);
        lblfechaPodev.setForeground(colorletrasfont);

        lblFechadev = new JLabel("|F|Regresado");
        lblFechadev.setBounds((int)24.5,(int)289.5, 206, 33);
        lblFechadev.setFont(nuevaTipografia1);
        lblFechadev.setForeground(colorletrasfont);

        txtfechahora = new JLabel();
        txtfechahora.setBounds(381,67,200,25);
        txtfechahora.setBackground(colorfondo2);
        txtfechahora.setFont(nuevaTipografia1);
        txtfechahora.setForeground(colorletrasfont);
        txtfechahora.setText(String.valueOf(LocalDate.now()));

        fildPrestamoIDRecurso = new JTextField();
        fildPrestamoIDRecurso.setBounds((int)243.5,(int)108.5,296,33);
        fildPrestamoIDRecurso.setFont(nuevaTipografia1);
        fildPrestamoIDRecurso.setForeground(colorletrasfont);
        fildPrestamoIDRecurso.setBackground(colorfondo2);
        

        fildPrestamoRecurso = new JTextField();
        fildPrestamoRecurso.setBounds((int)243.5,(int)154.5,296,33);
        fildPrestamoRecurso.setFont(nuevaTipografia1);
        fildPrestamoRecurso.setForeground(colorletrasfont);
        fildPrestamoRecurso.setBackground(colorfondo2);
        fildPrestamoRecurso.setEditable(false);

        fildPrestamoReg = new JTextField();
        fildPrestamoReg.setBounds((int)243.5,(int)197.5,296,33);
        fildPrestamoReg.setFont(nuevaTipografia1);
        fildPrestamoReg.setForeground(colorletrasfont);
        fildPrestamoReg.setBackground(colorfondo2);

        fildPrestadoPdev = new JTextField();
        fildPrestadoPdev.setBounds((int)243.5,(int)243.5,296,33);
        fildPrestadoPdev.setFont(nuevaTipografia1);
        fildPrestadoPdev.setForeground(colorletrasfont);
        fildPrestadoPdev.setBackground(colorfondo2);

        fildPrestamoDev = new JTextField();
        fildPrestamoDev.setBounds((int)243.5,(int)289.5,296,33);
        fildPrestamoDev.setFont(nuevaTipografia1);
        fildPrestamoDev.setForeground(colorletrasfont);
        fildPrestamoDev.setBackground(colorfondo2);

        jpanelDatos.add(lblIdRecurso);
        jpanelDatos.add(lblRecurso);
        jpanelDatos.add(lblfechaRe);
        jpanelDatos.add(lblfechaPodev);
        jpanelDatos.add(lblFechadev);
        jpanelDatos.add(txtfechahora);
        jpanelDatos.add(fildPrestamoIDRecurso);
        jpanelDatos.add(fildPrestamoRecurso);
        jpanelDatos.add(fildPrestamoReg);
        jpanelDatos.add(fildPrestadoPdev);
        jpanelDatos.add(fildPrestamoDev);

        im2 = new Decolib("/img/vista2/panel1.png");
        im2.setBounds(0,0,572,346);
        jpanelDatos.add(im2);

        /*-------------------- PANEL DE TABLAS ---------------------------------- */

        jpanelcontenTable = new JPanel();
        jpanelcontenTable .setLayout(null);
        jpanelcontenTable .setBounds(624,4,545,432);
        jpanelcontenTable .setBackground(traspartente);
        add(jpanelcontenTable);

        jpanelTabla.setBounds(10,63,519,352);
        jpanelTabla.setBackground(colorfondo2);
        jpanelcontenTable.add(jpanelTabla);

        im3 = new Decolib("/img/vista2/panel2.png");
        im3.setBounds(0,0,572,432);
        jpanelcontenTable.add(im3);

        /*-------------------- BOTONES --------------------------- */

        btnadd = new JButton("Add");
        btnadd.setBounds(26,373,232,67);  //389
        btnadd.setOpaque(true);
        btnadd.setContentAreaFilled(false);
        btnadd.setBorderPainted(false);
        btnadd.setLayout(null);
        add(btnadd);

        btnclean = new JButton("Clear");
        btnclean.setBounds(272,373,76,67);
        btnclean.setOpaque(true);
        btnclean.setBorderPainted(false);
        btnclean.setContentAreaFilled(false);
        btnclean.setLayout(null);
        add(btnclean);

        btndelete = new JButton("Delete");
        btndelete.setBounds(365,373,232,67);
        btndelete.setOpaque(true);
        btndelete.setBorderPainted(false);
        btndelete.setContentAreaFilled(false);
        btndelete.setLayout(null);
        add(btndelete);

        imb1 = new Decolib("/img/botones/btnagregar.png");
        imb1.setBounds(0,0,232,67);
        btnadd.add(imb1);

        imb2 = new Decolib("/img/botones/btnclear.png");
        imb2.setBounds(0,0,76,67);
        btnclean.add(imb2);

        imb3 = new Decolib("/img/botones/btneliminar.png");
        imb3.setBounds(0,0,232,67);
        btndelete.add(imb3);
    }

    public void mostrarventana(){
        setTitle("|BIBLIOTECA| Apartado de recursos a prestar");
        setVisible(true);
    }

    public void addListener(ActionListener listenControles){
        btnadd.addActionListener(listenControles);
        btnclean.addActionListener(listenControles);
        btndelete.addActionListener(listenControles);
        
    }

    public void addFocusListener(FocusListener listener){
        fildPrestamoRecurso.addFocusListener(listener);
    }

    /*------------ JTextFidls (Getters) -------------------*/
    public JTextField getFildPrestamoIDRecurso() {
        return fildPrestamoIDRecurso;
    }
    public JTextField getFildPrestamoRecurso() {
        return fildPrestamoRecurso;
    }
    public JTextField getFildRegistroPrestamo() {
        return fildPrestamoReg;
    }
    public JTextField getFildPordevolver() {
        return fildPrestadoPdev;
    }
    public JTextField getFildRegresado() {
        return fildPrestamoDev;
    }

    /*------------ Panel y tabla (Getters and Sett) -------------------*/

    public JTable getTablaDatosPrestamo() {
        return tablaDatosPrestamo;
    }
    public void setTablaDatosPrestamo(JTable tablaDatosPrestamo) {
        this.tablaDatosPrestamo = tablaDatosPrestamo;
    }
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }
    public void setPanelTabla(JScrollPane panelTabla) {
        this.panelTabla = panelTabla;
        jpanelTabla.add(panelTabla);
    }
    public JPanel getJpanelTabla() {
        return jpanelTabla;
    }
}
