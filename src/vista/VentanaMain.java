/*
 Archivo: VentanaMain.java
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
import javax.swing.tree.FixedHeightLayoutCache;


public class VentanaMain extends JFrame implements ActionListener{

    private String[] opcionesApartado = {"Selecione el Apartado","Usuarios", "Recursos", "Autores", "Genero|literario", "Prestamo"};
    private JComboBox<String> dropApartado = new JComboBox<>(opcionesApartado);
    Integer apartadoForm = 0;
    private JTable DatosEnTabla = new JTable();
    private JScrollPane Paneltable = new JScrollPane();
    private JPanel jpLista, jpconTablas, jpInformacion, jpPrincipal, jprplace, jpuser, jprecur, jpautor, jpgnrlite, jpPrestamo;
    //botones CRUD
    private JButton btnagregar, btnlimpiar, btneditar, btneliminar;
  
    //botones cambio de paneles
    private JButton btnusario, btnrecurso, btngnrliterario, btnautor, btnprestamo;
    private Decolib im1, im2, im3, im4, im5, im6, im7, imlist, imr1, imr2;

    //  ------------ PARA EL USUARIO ------------------ 
    private JLabel lblUsarioCod, lblUsarioNombre, lblUsarioTipo;
    private JTextField fildUsarioCod, fildUsarioNombre;
    private String[] tipoUsuario = {"Seleccionar","Estudiante","Profesor","Administrador"};
    private JComboBox<String> dropUsarioTipo = new JComboBox<>(tipoUsuario);
    //validar cada campo con un numero
    private String stringtipousario;
 
    //  ------------ PARA EL RECURSO ------------------ 
    private JLabel lblcodRecurso, lbltituloRecurso, lblRecDate, lblRectipo, lblRecAutor, lblRecGenlt, lblRecAutordato, lblRecGenDato;
    private JTextField fildRecursoCod, fildRecursoTitle, fildRecursoDate, fildRecusoAutor, fildRecursoGnlt, fildRecUV, fildRecGV;
   
    private String[] tipoRecurso = {"Seleccionar","Libro","Revista","Articulo","Comic","Manga"};
    private JComboBox<String> dropRecursoTipo = new JComboBox<>(tipoRecurso);

    //  ------------ PARA EL AUTOR ------------------ 
    private JLabel lblcodAutor, lblAutorname, lblRelevancia;
    private JTextField fildAutorcod, fildAutorname, fildAutorRele;
 
    //  ------------ PARA EL GENERO LITERARIO ------------------ 
    private JLabel lblcodGen, lblGenname;
    private JTextField filedcodg, fieldnameg;

    // ------------ PARA EL PRESTAMO ------------------ 
    private JLabel lblCodPres , lblIdUsuarioPres, lblNombreCPres, lblRecursos, lblCantidad ,lblEstado;
    private JTextField fildPresCod, fildPresIdUs, fildPresNomUs, fildPresCantidad, fildPresEstado;
    private JButton recursosver;

    private String[] estadoPrestamo = {"Seleccionar","Abierto","Parialemente Cerrado","Cerrado"};
    private JComboBox<String> dropEstado = new JComboBox<>(estadoPrestamo);
    
    
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
        Font nuevaTipografia3 = new Font("Courier New", Font.BOLD, 47);
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
        btnagregar.setBounds((int)629.5, (int)449.5,232, 67);
        btnagregar.setOpaque(true);
        btnagregar.setContentAreaFilled(false);
        btnagregar.setLayout(null);
        jpPrincipal.add(btnagregar);

        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds((int)887.5, (int)449.5,232, 67);
        btneliminar.setOpaque(true);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setLayout(null);
        jpPrincipal.add(btneliminar);

        btnlimpiar = new JButton("Limpiar");
        btnlimpiar.setBounds((int)629.5, (int)533.5,232, 67);
        btnlimpiar.setOpaque(true);
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setLayout(null);
        jpPrincipal.add(btnlimpiar);

        btneditar = new JButton("Editar");
        btneditar.setBounds((int)887.5, (int)533.5,232, 67); //añadi 40 espacio en y 
        btneditar.setOpaque(true);
        btneditar.setContentAreaFilled(false);
        btneditar.setLayout(null);
        jpPrincipal.add(btneditar);

        
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
        jpInformacion.setBounds((int)605.5, (int)38.5, 541, 410); //138.5
        jpInformacion.setBackground(new Color(0, 0, 0,0));
        jpPrincipal.add(jpInformacion);

        btnusario = new JButton("Usuario");
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

        btnprestamo = new JButton("Pre");
        btnprestamo.setBounds(443, 11, 88, 29);
        btnprestamo.setOpaque(true);
        btnprestamo.setContentAreaFilled(false);
        btnprestamo.setLayout(null);
        btnprestamo.setBorderPainted(false);
        btnprestamo.setFont(nuevaTipografia3);
        btnprestamo.setForeground(new Color (0,0,0,0));
        jpInformacion.add(btnprestamo);

        btnusario.addActionListener(this);
        btnrecurso.addActionListener(this);
        btnautor.addActionListener(this);
        btngnrliterario.addActionListener(this);
        btnprestamo.addActionListener(this);

        /* 
         * Voy a crear un apartado donde creare un panel base para poder remplazar, en otros subpaneles
         * dependientdo de las necesidades del boton que se presiono, ese metodo se implementara luego 
        */

        jprplace = new JPanel();
        jprplace.setBounds(7, 59, 523, 338); //172
        jprplace.setLayout(null);
        jprplace.setBackground(colorfondo);
        jpInformacion.add(jprplace);

        // Panel para añadir todo lo correspondiente a el usario
        jpuser = new JPanel();
        jpuser.setBounds(0, 0, 523, 338 );
        jpuser.setLayout(null);
        jpuser.setBackground(colorfondo);

        lblUsarioCod = new JLabel("ID Usuario:");
        lblUsarioCod.setBounds((int)29.5, (int)13.5, 185, 30);
        lblUsarioCod.setFont(nuevaTipografia);
        lblUsarioCod.setForeground(colorletras);

        lblUsarioNombre = new JLabel("Nombre|Apellido");
        lblUsarioNombre.setBounds((int)29.5, (int)54.5, 185, 30);
        lblUsarioNombre.setFont(nuevaTipografia);
        lblUsarioNombre.setForeground(colorletras);

        lblUsarioTipo = new JLabel("Tipo Usuario:");
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
        jprecur.setBounds(0, 0, 523, 338);
        jprecur.setLayout(null);
        jprecur.setBackground(colorfondo);

        lblcodRecurso = new JLabel("ID recurso:");
        lblcodRecurso.setBounds((int)29.5, (int)13.5, 185, 30);
        lblcodRecurso.setFont(nuevaTipografia);
        lblcodRecurso.setForeground(colorletras);

        lbltituloRecurso = new JLabel("Titulo:");
        lbltituloRecurso.setBounds((int)29.5, (int)54.5, 185, 30);
        lbltituloRecurso.setFont(nuevaTipografia);
        lbltituloRecurso.setForeground(colorletras);

        lblRecDate = new JLabel("Fecha Registro");
        lblRecDate.setBounds((int)29.5, (int)95.5, 185, 30);
        lblRecDate.setFont(nuevaTipografia);
        lblRecDate.setForeground(colorletras);

        lblRectipo = new JLabel("Tipo Recurso:");
        lblRectipo.setBounds((int)29.5, (int)136.5, 185, 30);
        lblRectipo.setFont(nuevaTipografia);
        lblRectipo.setForeground(colorletras);

        lblRecAutor = new JLabel("ID Autor:");
        lblRecAutor.setBounds((int)29.5, (int)177.5, 185, 30);
        lblRecAutor.setFont(nuevaTipografia);
        lblRecAutor.setForeground(colorletras);

        lblRecGenlt = new JLabel("ID genero Lit:");
        lblRecGenlt.setBounds((int)29.5, (int)218.5, 185, 30);
        lblRecGenlt.setFont(nuevaTipografia);
        lblRecGenlt.setForeground(colorletras);

        lblRecAutordato = new JLabel("Autor:");
        lblRecAutordato.setBounds((int)29.5, (int)259.5, 185, 30);
        lblRecAutordato.setFont(nuevaTipografia);
        lblRecAutordato.setForeground(colorletras);

        lblRecGenDato = new JLabel("Gnero|Literario");
        lblRecGenDato.setBounds((int)29.5, (int)300.5, 185, 30);
        lblRecGenDato.setFont(nuevaTipografia);
        lblRecGenDato.setForeground(colorletras);

        fildRecursoCod = new JTextField();
        fildRecursoCod.setBounds((int)225.5, (int)13.5, 265, 30);
        fildRecursoCod.setFont(nuevaTipografia);
        fildRecursoCod.setForeground(colorletras);
        fildRecursoCod.setBackground(colorfondo);
        fildRecursoCod.setEditable(false);

        fildRecursoTitle = new JTextField();
        fildRecursoTitle.setBounds((int)225.5, (int)54.5, 265, 30);
        fildRecursoTitle.setFont(nuevaTipografia);
        fildRecursoTitle.setForeground(colorletras);
        fildRecursoTitle.setBackground(colorfondo);

        fildRecursoDate = new JTextField();
        fildRecursoDate.setBounds((int)225.5, (int)95.5, 265, 30);
        fildRecursoDate.setFont(nuevaTipografia);
        fildRecursoDate.setForeground(colorletras);
        fildRecursoDate.setBackground(colorfondo);
        fildRecursoDate.setEditable(false);

        dropRecursoTipo.setBounds((int)225.5, (int)136.5,265,30);
        dropRecursoTipo.setOpaque(true);
        dropRecursoTipo.setFont(nuevaTipografia);
        dropRecursoTipo.setForeground(colorletras);
        dropRecursoTipo.setBackground(colorfondo);

        fildRecusoAutor = new JTextField();
        fildRecusoAutor.setBounds((int)225.5, (int)177.5,265,30);
        fildRecusoAutor.setFont(nuevaTipografia);
        fildRecusoAutor.setForeground(colorletras);
        fildRecusoAutor.setBackground(colorfondo);

        fildRecursoGnlt = new JTextField();
        fildRecursoGnlt.setBounds((int)225.5, (int)218.5,265,30);
        fildRecursoGnlt.setFont(nuevaTipografia);
        fildRecursoGnlt.setForeground(colorletras);
        fildRecursoGnlt.setBackground(colorfondo);

        fildRecUV = new JTextField();
        fildRecUV.setBounds((int)225.5, (int)259.5 ,265,30);
        fildRecUV.setFont(nuevaTipografia);
        fildRecUV.setForeground(colorletras);
        fildRecUV.setBackground(colorfondo);
        fildRecUV.setEditable(false);

        fildRecGV = new JTextField();
        fildRecGV.setBounds((int)225.5, (int)300.5 ,265,30);
        fildRecGV.setFont(nuevaTipografia);
        fildRecGV.setForeground(colorletras);
        fildRecGV.setBackground(colorfondo);
        fildRecGV.setEditable(false);

        jprecur.add(lblcodRecurso);
        jprecur.add(lbltituloRecurso);
        jprecur.add(lblRecDate);
        jprecur.add(lblRectipo);
        jprecur.add(lblRecAutor);
        jprecur.add(lblRecGenlt);
        jprecur.add(lblRecAutordato);
        jprecur.add(lblRecGenDato);
        jprecur.add(fildRecursoCod);
        jprecur.add(fildRecursoTitle);
        jprecur.add(fildRecursoDate);
        jprecur.add(dropRecursoTipo);
        jprecur.add(fildRecusoAutor);
        jprecur.add(fildRecursoGnlt);
        jprecur.add(fildRecUV);
        jprecur.add(fildRecGV);

        // Panel para añadir todo lo correspondiente a el autor
        jpautor = new JPanel();
        jpautor.setBounds(0, 0, 523, 338);
        jpautor.setLayout(null);
        jpautor.setBackground(colorfondo);

        lblcodAutor = new JLabel("ID autor:");
        lblcodAutor.setBounds((int)29.5, (int)13.5, 185, 30);
        lblcodAutor.setFont(nuevaTipografia);
        lblcodAutor.setForeground(colorletras);

        lblAutorname = new JLabel("Nombre|Apellido");
        lblAutorname.setBounds((int)29.5, (int)54.5, 185, 30);
        lblAutorname.setFont(nuevaTipografia);
        lblAutorname.setForeground(colorletras);

        lblRelevancia = new JLabel("Relevancia:");
        lblRelevancia.setBounds((int)29.5, (int)95.5, 185, 30);
        lblRelevancia.setFont(nuevaTipografia);
        lblRelevancia.setForeground(colorletras);

        fildAutorcod = new JTextField();
        fildAutorcod.setBounds((int)225.5, (int)13.5, 265, 30);
        fildAutorcod.setFont(nuevaTipografia);
        fildAutorcod.setForeground(colorletras);
        fildAutorcod.setBackground(colorfondo);
        fildAutorcod.setEditable(false);

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
        jpgnrlite.setBounds(0, 0, 523, 338);
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

        // Panel para añadir todos los elementos del prestamo
        jpPrestamo = new JPanel();
        jpPrestamo.setBounds(0, 0, 523, 338);
        jpPrestamo.setLayout(null);
        jpPrestamo.setBackground(new Color(232, 246, 239));

        lblCodPres = new JLabel("ID Prestamo:");
        lblCodPres.setBounds((int)29.5, (int)13.5, 185, 30);
        lblCodPres.setFont(nuevaTipografia);
        lblCodPres.setForeground(colorletras);

        lblIdUsuarioPres = new JLabel("ID Usuario:");
        lblIdUsuarioPres.setBounds((int)29.5, (int)54.5, 185, 30);
        lblIdUsuarioPres.setFont(nuevaTipografia);
        lblIdUsuarioPres.setForeground(colorletras);

        lblNombreCPres = new JLabel("Nombre|User:");
        lblNombreCPres.setBounds((int)29.5, (int)95.5, 185, 30);
        lblNombreCPres.setFont(nuevaTipografia);
        lblNombreCPres.setForeground(colorletras);

        lblRecursos = new JLabel("Recursos|D|");
        lblRecursos.setBounds((int)29.5, (int)136.5, 185, 30);
        lblRecursos.setFont(nuevaTipografia);
        lblRecursos.setForeground(colorletras);

        lblCantidad = new JLabel("N° Recursos:");
        lblCantidad.setBounds((int)29.5, (int)177.5, 185, 30);
        lblCantidad.setFont(nuevaTipografia);
        lblCantidad.setForeground(colorletras);

        lblEstado = new JLabel("|R| Estado:");
        lblEstado.setBounds((int)29.5, (int)218.5, 185, 30);
        lblEstado.setFont(nuevaTipografia);
        lblEstado.setForeground(colorletras);

        fildPresCod = new JTextField();
        fildPresCod.setBounds((int)225.5, (int)13.5, 265, 30);
        fildPresCod.setFont(nuevaTipografia);
        fildPresCod.setForeground(colorletras);
        fildPresCod.setBackground(colorfondo);
        fildPresCod.setEditable(false);

        fildPresIdUs = new JTextField();
        fildPresIdUs.setBounds((int)225.5, (int)54.5, 265, 30);
        fildPresIdUs.setFont(nuevaTipografia);
        fildPresIdUs.setForeground(colorletras);
        fildPresIdUs.setBackground(colorfondo);

        fildPresNomUs = new JTextField();
        fildPresNomUs.setBounds((int)225.5, (int)95.5, 265, 30);
        fildPresNomUs.setFont(nuevaTipografia);
        fildPresNomUs.setForeground(colorletras);
        fildPresNomUs.setBackground(colorfondo);
        fildPresNomUs.setEditable(false);
        
        recursosver = new JButton("Listar Productos");
        recursosver.setBounds((int)225.5, (int)136.5,265,30);
        recursosver.setOpaque(true);
        recursosver.setBackground(colorfondo);
        recursosver.setFont(nuevaTipografia);
        recursosver.setForeground(colorletras);
        
        fildPresCantidad = new JTextField();
        fildPresCantidad.setBounds((int)225.5, (int)177.5,265,30);
        fildPresCantidad.setFont(nuevaTipografia);
        fildPresCantidad.setForeground(colorletras);
        fildPresCantidad.setBackground(colorfondo);

        dropEstado.setBounds((int)225.5, (int)218.5,265,30);
        dropEstado.setFont(nuevaTipografia);
        dropEstado.setForeground(colorletras);
        dropEstado.setBackground(colorfondo);
        

        jpPrestamo.add(lblCodPres);
        jpPrestamo.add(lblIdUsuarioPres);
        jpPrestamo.add(lblNombreCPres);
        jpPrestamo.add(lblRecursos);
        jpPrestamo.add(lblCantidad);
        jpPrestamo.add(lblEstado);
        jpPrestamo.add(fildPresCod);
        jpPrestamo.add(fildPresIdUs);
        jpPrestamo.add(fildPresNomUs);
        jpPrestamo.add(recursosver);
        jpPrestamo.add(fildPresCantidad);
        jpPrestamo.add(dropEstado);


        //Fondo panel informacion
        imr1 = new Decolib("/img/panelDatos.png");
        imr1.setBounds(0, 0, 541, 410);
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
        stringtipousario = dropUsarioTipo.getSelectedItem().toString();
        if(event.getSource() == btnusario){
            System.out.println("Botn de usario");
            mostralpanel(jpuser);
        }else if (event.getSource() == btnautor){
            System.out.println("Botn de autor");
            mostralpanel(jpautor);
        }else if (event.getSource() == btnrecurso){
            System.out.println("Botn de recurso");
            mostralpanel(jprecur);
        }else if (event.getSource() == btngnrliterario){
            System.out.println("Botn de genero literario");
            mostralpanel(jpgnrlite);
        } else if (event.getSource() == btnprestamo){
            System.out.println("boton de Prestamo");
            mostralpanel(jpPrestamo);
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
        btnprestamo.addActionListener(listenControles);
        recursosver.addActionListener(listenControles);
        
    }

    public void addFocusListener(FocusListener listener){
        fildRecusoAutor.addFocusListener(listener);
        fildRecursoGnlt.addFocusListener(listener);
        fildPresIdUs.addFocusListener(listener);
    }

    private void mostralpanel(JPanel show){
        jprplace.removeAll();
        jprplace.add(show);
        jprplace.revalidate();
        jprplace.repaint();
    }
    /*------------ Para Recursos (Getters) -------------------*/
    public JTextField getFildRecursoCod() {
        return fildRecursoCod;
    }

    public JTextField getFildRecursoTitle() {
        return fildRecursoTitle;
    }

    public JTextField getFildRecursoDate() {
        return fildRecursoDate;
    }

    public JTextField getFildRecusoAutor() {
        return fildRecusoAutor;
    }

    public JTextField getFildRecursoGnlt() {
        return fildRecursoGnlt;
    }

    public JTextField getFildRecAV() {
        return fildRecUV;
    }

    public JTextField getFildRecGV() {
        return fildRecGV;
    }

    public JComboBox<String> getDropRecursoTipo() {
        return dropRecursoTipo;
    }

    public void setDropRecursoTipo(JComboBox<String> dropRecursoTipo) {
        this.dropRecursoTipo = dropRecursoTipo;
    }
    /*------------ Para Usuarios (Getters and Setters) -------------------*/

    public JTextField getFildUsarioCod() {
        return fildUsarioCod;
    }

    public JTextField getFildUsarioNombre() {
        return fildUsarioNombre;
    }

    public String getStringtipousario() {
        return stringtipousario;
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

    /*------------ PARA Prestamo Getters) -------------------*/
    
    public JTextField getFildPresCod() {
        return fildPresCod;
    }

    public JTextField getFildPresIdUs() {
        return fildPresIdUs;
    }

    public JTextField getFildPresNomUs() {
        return fildPresNomUs;
    }

    public JTextField getFildPresCantidad() {
        return fildPresCantidad;
    }

    public JComboBox<String> getDropEstado() {
        return dropEstado;
    }


    public JButton getRecursosver() {
        return recursosver;
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

}