/*
 Archivo: VentanaMain.java
 Proyecto III - Biblioteca univalle
 21 de mayo de 2022

 Autores:
  @author Manuel Felipe Cardoso Forero (2027288)
  @author Juan David Rodriguez Rubio (2025435) 
 
 */


package vista;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.*;
import javax.swing.tree.FixedHeightLayoutCache;


public class VentanaMain extends JFrame implements ActionListener{

    private JTable DatosEnTabla = new JTable();
    private JScrollPane Paneltable = new JScrollPane();
    private JPanel jpLista, jpconTablas, jpInformacion, jpPrincipal, jprplace, jpuser, jprecur, jpautor, jpgnrlite;
    //botones CRUD
    private JButton btnagregar, btnlimpiar, btneditar, btneliminar;
  
    //botones cambio de paneles
    private JButton btnusario, btnrecurso, btngnrliterario, btnautor, btnprestamo;
    private Decolib im1, im2, im3, im4, im5, im6, im7, imlist, imr1, imr2;

    //Usario
    private JLabel lblUsarioCod, lblUsarioNombre, lblUsarioTipo;
    private JTextField fildUsarioCod, fildUsarioNombre;
    private String[] tipoUsuario = {"Seleccione Tipo","Estudiante","Profesor","Administrador"};
    private JComboBox<String> dropUsarioTipo = new JComboBox<>(tipoUsuario);
 
    //Recurso

    //Autores
    private JLabel lblcodAutor, lblAutorname, lblRelevancia;
    private JTextField fildAutorcod, fildAutorname, fildAutorRele;
 
    // Genero literario
    private JLabel lblcodGen, lblGenname;
    private JTextField filedcodg, fieldnameg;

    private String[] opcionesApartado = {"Selecione EL Apartado","Usuarios", "Recursos", "Autores", "Genero literario", "Prestamo"};
    private JComboBox<String> dropApartado = new JComboBox<>(opcionesApartado);

    private Integer apartadoForm = 0;
    

    public VentanaMain (){
        iniciarComponentes();
        im1 = new Decolib("/img/Fondo2.png");
        im1.setBounds(0, 0, 1280, 720 );
        add(im1);

    }

    private void iniciarComponentes(){

        //Config JFRAME
        setTitle("Biblioteca Univalle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //Fuente usada por los txt y los labels
        Font nuevaTipografia = new Font("Courier New", Font.BOLD, 20);
        Font nuevaTipografia2 = new Font("Courier New", Font.BOLD, 55);
        Color colorletras = new Color(74,39,23);

        //Color de fondo
        Color colorfondo = new Color(232, 246, 239);

        //Configurar panel principal 
        jpPrincipal = new JPanel();
        jpPrincipal.setLayout(null);
        jpPrincipal.setBounds((int)41.09, (int)30.53, 1196, 636);
        jpPrincipal.setBackground(new Color(0, 0, 0, 0));
        add(jpPrincipal);
        
        btnagregar = new JButton("Agregar");
        btnagregar.setBounds((int)629.5, (int)409.5,232, 67);
        btnagregar.setOpaque(true);
        btnagregar.setContentAreaFilled(false);
        btnagregar.setLayout(null);
        jpPrincipal.add(btnagregar);

        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds((int)887.5, (int)409.5,232, 67);
        btneliminar.setOpaque(true);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setLayout(null);
        jpPrincipal.add(btneliminar);

        btnlimpiar = new JButton("Limpiar");
        btnlimpiar.setBounds((int)629.5, (int)493.5,232, 67);
        btnlimpiar.setOpaque(true);
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setLayout(null);
        jpPrincipal.add(btnlimpiar);

        btneditar = new JButton("Editar");
        btneditar.setBounds((int)887.5, (int)493.5,232, 67);
        btneditar.setOpaque(true);
        btneditar.setContentAreaFilled(false);
        btneditar.setLayout(null);
        jpPrincipal.add(btneditar);

        btngnrliterario = new JButton();
        btngnrliterario.setOpaque(true);
        btngnrliterario.setContentAreaFilled(false);
        btngnrliterario.setLayout(null);
        

        im4 = new Decolib("/img/botones/btnagregar.png");
        im4.setBounds(0,0,232, 67);
        btnagregar.add(im4);

        im6 = new Decolib("/img/botones/btneliminar.png");
        im6.setBounds(0,0,232, 67);
        btneliminar.add(im6);

        im5 = new Decolib("/img/botones/btnLimpiar.png");
        im5.setBounds(0,0,232, 67);
        btnlimpiar.add(im5);

        im7 = new Decolib("/img/botones/btneditar.png");
        im7.setBounds(0,0,232, 67);    
        btneditar.add(im7);

        //configurar panell para la lista
        jpLista = new JPanel();
        jpLista.setLayout(null);
        jpLista.setBounds((int)38.13, (int)118.13, 552 ,494);
        jpLista.setBackground(new Color(0,0,0,0));
        jpPrincipal.add(jpLista);


        dropApartado.setBounds((int)185.38, (int)68.34 , (int)338.82, (int)22.52);
        dropApartado.setOpaque(true);
        dropApartado.setFont(nuevaTipografia);
        dropApartado.setForeground(colorletras);
        dropApartado.setBackground(colorfondo);
        jpLista.add(dropApartado); 

        jpconTablas = new JPanel();
        //jpconTablas.setLayout(null);
        jpconTablas.setBounds(18,121, 512,347);
        jpconTablas.setBackground(colorfondo);
        jpLista.add(jpconTablas);

        imlist = new Decolib("/img/panelLista.png");
        imlist.setBounds(0,0, 552, 494);
        jpLista.add(imlist);

        //Configuracion para el panel donde se tomara la informacion

        jpInformacion = new JPanel();
        jpInformacion.setLayout(null);
        jpInformacion.setBounds((int)605.5, (int)138.5, 541, 248);
        jpInformacion.setBackground(new Color(0, 0, 0,0));
        jpPrincipal.add(jpInformacion);

        btnusario = new JButton("Usario");
        btnusario.setBounds(7, 11,101, 29);
        btnusario.setOpaque(true);
        btnusario.setContentAreaFilled(false);
        btnusario.setLayout(null);
        btnusario.setBorderPainted(false);
        btnusario.setFont(nuevaTipografia2);
        btnusario.setForeground(new Color(0,0,0,0));
        jpInformacion.add(btnusario);

        btnrecurso = new JButton("Recurso");
        btnrecurso.setBounds(117, 11,101, 29);
        btnrecurso.setOpaque(true);
        btnrecurso.setContentAreaFilled(false);
        btnrecurso.setLayout(null);
        btnrecurso.setFont(nuevaTipografia2);
        btnrecurso.setForeground(new Color(0,0,0,0));
        btnrecurso.setBorderPainted(false);
        jpInformacion.add(btnrecurso);

        btnautor = new JButton("Autor");
        btnautor.setBounds(226, 11,101, 29);
        btnautor.setOpaque(true);
        btnautor.setContentAreaFilled(false);
        btnautor.setFont(nuevaTipografia2);
        btnautor.setForeground(new Color(0,0,0,0));
        btnautor.setLayout(null);
        btnautor.setBorderPainted(false);
        jpInformacion.add(btnautor);

        btngnrliterario = new JButton("Genero");
        btngnrliterario.setBounds(335, 11,101, 29);
        btngnrliterario.setOpaque(true);
        btngnrliterario.setContentAreaFilled(false);
        btngnrliterario.setLayout(null);
        btngnrliterario.setBorderPainted(false);
        btngnrliterario.setFont(nuevaTipografia2);
        btngnrliterario.setForeground(new Color(0,0,0,0));
        jpInformacion.add(btngnrliterario);

        btnusario.addActionListener(this);
        btnrecurso.addActionListener(this);
        btnautor.addActionListener(this);
        btngnrliterario.addActionListener(this);
        dropApartado.addActionListener(this); 

        /* 
         * Voy a crear un apartado donde creare un panel base para poder remplazar, en otros subpaneles
         * dependientdo de las necesidades del boton que se presiono, ese metodo se implementara luego 
        */

        jprplace = new JPanel();
        jprplace.setBounds(7, 59, 523, 172);
        jprplace.setLayout(null);
        jprplace.setBackground(new Color(90, 0, 0));
        jpInformacion.add(jprplace);

        // Panel para añadir todo lo correspondiente a el usario
        jpuser = new JPanel();
        jpuser.setBounds(0, 0, 523, 172);
        jpuser.setLayout(null);
        jpuser.setBackground(colorfondo);

        lblUsarioCod = new JLabel("ID Usuario");
        lblUsarioCod.setBounds((int)29.5, (int)13.5, 185, 30);
        lblUsarioCod.setFont(nuevaTipografia);
        lblUsarioCod.setForeground(colorletras);

        lblUsarioNombre = new JLabel("Nombre|Apellido");
        lblUsarioNombre.setBounds((int)29.5, (int)54.5, 185, 30);
        lblUsarioNombre.setFont(nuevaTipografia);
        lblUsarioNombre.setForeground(colorletras);

        lblUsarioTipo = new JLabel("Tipo Usuario");
        lblUsarioTipo.setBounds((int)29.5, (int)95.5, 185, 30);
        lblUsarioTipo.setFont(nuevaTipografia);
        lblUsarioTipo.setForeground(colorletras);

        fildUsarioCod = new JTextField();
        fildUsarioCod.setBounds((int)225.5, (int)13.5, 265, 30);
        fildUsarioCod.setFont(nuevaTipografia);
        fildUsarioCod.setForeground(colorletras);
        fildUsarioCod.setBackground(colorfondo);

        fildUsarioNombre = new JTextField();
        fildUsarioNombre.setBounds((int)225.5, (int)54.5, 265, 30);
        fildUsarioNombre.setFont(nuevaTipografia);
        fildUsarioNombre.setForeground(colorletras);
        fildUsarioNombre.setBackground(colorfondo);

        dropUsarioTipo.setBounds((int)225.5, (int)95.5, 265, 30);
        dropUsarioTipo.setOpaque(true);
        dropUsarioTipo.setFont(nuevaTipografia);
        dropUsarioTipo.setForeground(colorletras);
        dropUsarioTipo.setBackground(colorfondo);

        jpuser.add(lblUsarioCod);
        jpuser.add(lblUsarioNombre);
        jpuser.add(lblUsarioTipo);
        jpuser.add(fildUsarioCod);
        jpuser.add(fildUsarioNombre);
        jpuser.add(dropUsarioTipo);

        // Panel para añadir todo lo correspondiente al recurso
        jprecur = new JPanel();
        jprecur.setBounds(0, 0, 523, 172);
        jprecur.setLayout(null);
        jprecur.setBackground(new Color(100, 0, 0));

        // Panel para añadir todo lo correspondiente a el autor
        jpautor = new JPanel();
        jpautor.setBounds(0, 0, 523, 172);
        jpautor.setLayout(null);
        jpautor.setBackground(colorfondo);

        lblcodAutor = new JLabel("ID autor");
        lblcodAutor.setBounds((int)29.5, (int)13.5, 185, 30);
        lblcodAutor.setFont(nuevaTipografia);
        lblcodAutor.setForeground(colorletras);

        lblAutorname = new JLabel("Nombre|Apellido");
        lblAutorname.setBounds((int)29.5, (int)54.5, 185, 30);
        lblAutorname.setFont(nuevaTipografia);
        lblAutorname.setForeground(colorletras);

        lblRelevancia = new JLabel("Relevancia");
        lblRelevancia.setBounds((int)29.5, (int)95.5, 185, 30);
        lblRelevancia.setFont(nuevaTipografia);
        lblRelevancia.setForeground(colorletras);

        fildAutorcod = new JTextField();
        fildAutorcod.setBounds((int)225.5, (int)13.5, 265, 30);
        fildAutorcod.setFont(nuevaTipografia);
        fildAutorcod.setForeground(colorletras);
        fildAutorcod.setBackground(colorfondo);

        fildAutorname = new JTextField();
        fildAutorname.setBounds((int)225.5, (int)54.5, 265, 30);
        fildAutorname.setFont(nuevaTipografia);
        fildAutorname.setForeground(colorletras);
        fildAutorname.setBackground(colorfondo);

        fildAutorRele = new JTextField();
        fildAutorRele.setBounds((int)225.5, (int)95.5, 265, 30);
        fildAutorRele.setFont(nuevaTipografia);
        fildAutorRele.setForeground(colorletras);
        fildAutorRele.setBackground(colorfondo);

        jpautor.add(lblcodAutor);
        jpautor.add(lblAutorname);
        jpautor.add(lblRelevancia);
        jpautor.add(fildAutorcod);
        jpautor.add(fildAutorname);
        jpautor.add(fildAutorRele);

        // Panel para añadir todo lo correspondiente a el genero literario
        jpgnrlite = new JPanel();
        jpgnrlite.setBounds(0, 0, 523, 172);
        jpgnrlite.setLayout(null);
        jpgnrlite.setBackground(new Color(232, 246, 239));

        lblcodGen = new JLabel("ID genero lt:");
        lblcodGen.setBounds((int)29.5, (int)13.5, 185, 30);
        lblcodGen.setFont(nuevaTipografia);
        lblcodGen.setForeground(colorletras);

        lblGenname = new JLabel("Gnero Literaio:");
        lblGenname.setBounds((int)29.5, (int)54.5, 185, 30);
        lblGenname.setFont(nuevaTipografia);
        lblGenname.setForeground(colorletras);

        filedcodg = new JTextField();
        filedcodg.setBounds((int)225.5, (int)13.5, 265, 30);
        filedcodg.setFont(nuevaTipografia);
        filedcodg.setForeground(colorletras);
        filedcodg.setBackground(colorfondo);
        filedcodg.setEditable(false);

        fieldnameg = new JTextField();
        fieldnameg.setBounds((int)225.5, (int)54.5, 265, 30);
        fieldnameg.setFont(nuevaTipografia);
        fieldnameg.setForeground(colorletras);
        fieldnameg.setBackground(colorfondo);
        
        jpgnrlite.add(lblcodGen);
        jpgnrlite.add(lblGenname);
        jpgnrlite.add(filedcodg);
        jpgnrlite.add(fieldnameg);

        //Fondo panel informacion
        imr1 = new Decolib("/img/panelDatos.png");
        imr1.setBounds(0, 0, 541, 248);
        jpInformacion.add(imr1);

        //Fondo del panel princicipal
        im2 = new Decolib("/img/fondopanelfinal.png");
        im2.setBounds(0,0, 1196, 636);
        jpPrincipal.add(im2);
        
        /* btnagregar.addActionListener(this);
        btneliminar.addActionListener(this);
        btneditar.addActionListener(this);
        btnlimpiar.addActionListener(this); */
    }
     
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        if(event.getSource() == btnusario){
            System.out.println("Botn de usario");
            mostralpanel(jpuser);
            apartadoForm = 1;
        }else if (event.getSource() == btnautor){
            System.out.println("Botn de autor");
            mostralpanel(jpautor);
            apartadoForm = 2;
        }else if (event.getSource() == btnrecurso){
            System.out.println("Botn de recurso");
            mostralpanel(jprecur);
            apartadoForm = 3;
        }else if (event.getSource() == btngnrliterario){
            System.out.println("Botn de genero literario");
            mostralpanel(jpgnrlite);
            apartadoForm = 4;
        }

    }

    public void addListener(ActionListener listenControles){
        dropApartado.addActionListener(listenControles);
        btnagregar.addActionListener(listenControles);
        btneliminar.addActionListener(listenControles);
        btneditar.addActionListener(listenControles);
        btnlimpiar.addActionListener(listenControles);
        btnusario.addActionListener(listenControles);
        btnrecurso.addActionListener(listenControles);
        btnautor.addActionListener(listenControles);
        btngnrliterario.addActionListener(listenControles);
        dropApartado.addActionListener(listenControles); 
        
    }

    private void mostralpanel(JPanel show){
        jprplace.removeAll();
        jprplace.add(show);
        jprplace.revalidate();
        jprplace.repaint();
    }

    /*------------ PARA Usuarios (Getters and Setters) -------------------*/

    public JLabel getLblUsarioCod() {
        return lblUsarioCod;
    }

    public JLabel getLblUsarioNombre() {
        return lblUsarioNombre;
    }

    public JLabel getLblUsarioTipo() {
        return lblUsarioTipo;
    }

    
    public JTextField getFildUsarioCod() {
        return fildUsarioCod;
    }

    public JTextField getFildUsarioNombre() {
        return fildUsarioNombre;
    }

    public JComboBox<String> getDropUsarioTipo() {
        return dropUsarioTipo;
    }

    public void setDropUsarioTipo(JComboBox<String> dropUsarioTipo) {
        this.dropUsarioTipo = dropUsarioTipo;
    }
    
    /*------------ PARA AUTORES(Getters) -------------------*/

    public JTextField getFildAutorcod() {
        return fildAutorcod;
    }

    public JTextField getFildAutorname() {
        return fildAutorname;
    }

    public JTextField getFildAutorRele() {
        return fildAutorRele;
    }
    
    /*------------ PARA GENERO LITERARIO(Getters) -------------------*/

    public JTextField getFiledcodg() {
        return filedcodg;
    }

    public JTextField getFieldnameg() {
        return fieldnameg;
    }

    /*------------ PARA BOTONES CRUD(Getters) -------------------*/

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public JButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public JButton getBtneditar() {
        return btneditar;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }
    
    /*------------ PARA LOS DEMAS ELEMENTOS  -------------------*/

    public Integer getFormulario(){
        return apartadoForm;
    }
    
    public JTable getDatosEnTabla() {
        return DatosEnTabla;
    }

    public void setDatosEnTabla(JTable datosEnTabla) {
        this.DatosEnTabla = datosEnTabla;
    }

    public JScrollPane getPaneltable() {
        return Paneltable;
    }

    public void setPaneltable(JScrollPane paneltable) {
        this.Paneltable = paneltable;
        jpconTablas.add(paneltable);
    }

    public JPanel getPanelTablas(){
        return jpconTablas;
    }

    public JComboBox<String> getApartado() {
        return dropApartado;
    }

    public void setDropApartado(JComboBox<String> dropApartado) {
        this.dropApartado = dropApartado;
    }

}