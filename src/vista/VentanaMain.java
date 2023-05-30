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


public class VentanaMain extends JFrame implements ActionListener{

    private JTable DatosEnTabla = new JTable();
    private JScrollPane Paneltable = new JScrollPane();
    private JPanel jpLista, jpconTablas, jpInformacion, jpPrincipal, jprplace, jpuser, jprecur, jpautor, jpgnrlite;
    //botones CRUD
    private JButton btnagregar, btnlimpiar, btneditar, btneliminar, btnusario, btnrecurso, btngnrliterario, btnautor, btnprestamo;
    private Decolib im1, im2, im3, im4, im5, im6, im7, imlist, imr1, imr2;
    
    // Genero literario
    private JLabel lblcodGen, lblGenname;
    private JTextField filedcodg, fieldnameg;

    private String[] opcionesApartado = {"Selecione EL Apartado"," Usuarios", "Recursos", "Autores", "Géneros literarios", "Préstamo"};
    private JComboBox<String> dropApartado = new JComboBox<>(opcionesApartado);

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
        Color colorletras = new Color(74,39,23);

        //Color de fondo
        Color colorfondo = new Color(232, 246, 239);

        //Configurar panel principal 
        jpPrincipal = new JPanel();
        jpPrincipal.setLayout(null);
        jpPrincipal.setBounds((int)41.09, (int)30.53, 1196, 636);
        jpPrincipal.setBackground(new Color(0, 0, 0, 0));
        add(jpPrincipal);
        
        btnagregar = new JButton("");
        btnagregar.setBounds((int)629.5, (int)409.5,232, 67);
        btnagregar.setOpaque(true);
        btnagregar.setContentAreaFilled(false);
        btnagregar.setLayout(null);
        jpPrincipal.add(btnagregar);

        btneliminar = new JButton();
        btneliminar.setBounds((int)887.5, (int)409.5,232, 67);
        btneliminar.setOpaque(true);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setLayout(null);
        jpPrincipal.add(btneliminar);

        btnlimpiar = new JButton("");
        btnlimpiar.setBounds((int)629.5, (int)493.5,232, 67);
        btnlimpiar.setOpaque(true);
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setLayout(null);
        jpPrincipal.add(btnlimpiar);

        btneditar = new JButton();
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
        dropApartado.setBackground(new Color(225,225,225));
        dropApartado.setFont(nuevaTipografia);
        dropApartado.setForeground(colorletras);
        dropApartado.setBackground(colorfondo);
        jpLista.add(dropApartado); 

        jpconTablas = new JPanel();
        jpconTablas.setLayout(null);
        jpconTablas.setBounds(18,121, 512,347);
        jpconTablas.setBackground(new Color(100,0,0));
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

        btnusario = new JButton();
        btnusario.setBounds(7, 11,101, 29);
        btnusario.setOpaque(true);
        btnusario.setContentAreaFilled(false);
        btnusario.setLayout(null);
        btnusario.setBorderPainted(false);
        jpInformacion.add(btnusario);

        btnrecurso = new JButton();
        btnrecurso.setBounds(117, 11,101, 29);
        btnrecurso.setOpaque(true);
        btnrecurso.setContentAreaFilled(false);
        btnrecurso.setLayout(null);
        btnrecurso.setBorderPainted(false);
        jpInformacion.add(btnrecurso);

        btnautor = new JButton();
        btnautor.setBounds(226, 11,101, 29);
        btnautor.setOpaque(true);
        btnautor.setContentAreaFilled(false);
        btnautor.setLayout(null);
        btnautor.setBorderPainted(false);
        jpInformacion.add(btnautor);

        btngnrliterario = new JButton();
        btngnrliterario.setBounds(335, 11,101, 29);
        btngnrliterario.setOpaque(true);
        btngnrliterario.setContentAreaFilled(false);
        btngnrliterario.setLayout(null);
        btngnrliterario.setBorderPainted(false);
        jpInformacion.add(btngnrliterario);

        btnusario.addActionListener(this);
        btnrecurso.addActionListener(this);
        btnautor.addActionListener(this);
        btngnrliterario.addActionListener(this); 

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
        jpuser.setBackground(new Color(150, 0, 0));

        // Panel para añadir todo lo correspondiente al recurso
        jprecur = new JPanel();
        jprecur.setBounds(0, 0, 523, 172);
        jprecur.setLayout(null);
        jprecur.setBackground(new Color(100, 0, 0));

        // Panel para añadir todo lo correspondiente a el autor
        jpautor = new JPanel();
        jpautor.setBounds(0, 0, 523, 172);
        jpautor.setLayout(null);
        jpautor.setBackground(new Color(250, 0, 0));

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
        
    }
     
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
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
        }

    }

    public void addListener(ActionListener botonesCRUD){
        btnagregar.addActionListener(botonesCRUD);
        btneliminar.addActionListener(botonesCRUD);
        btneditar.addActionListener(botonesCRUD);
        btnlimpiar.addActionListener(botonesCRUD);
        dropApartado.addActionListener(botonesCRUD);
        
    }

    private void mostralpanel(JPanel show){
        jprplace.removeAll();
        jprplace.add(show);
        jprplace.revalidate();
        jprplace.repaint();
    }

    public JTextField getFiledcodg() {
        return filedcodg;
    }

    public JTextField getFieldnameg() {
        return fieldnameg;
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