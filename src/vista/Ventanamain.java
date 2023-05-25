package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventanamain extends JFrame implements ActionListener{

    private JPanel jpLista, jpInformacion, jpPrincipal;
    //botones CRUD
    private JButton btnagregar, btnlimpiar, btneditar, btneliminar;
    private Decolib im1, im2, im3, im4, im5, im6, im7, imlist, imr1, imr2, imr3, imr4;

    private String[] opcionesApartado = {"Usuarios", "Recursos", "Autores", "Géneros literarios", "Préstamo"};
    private JComboBox<String> dropApartado = new JComboBox<>(opcionesApartado);

    public Ventanamain (){
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

        //configurar panel tablas
        jpLista = new JPanel();
        jpLista.setLayout(null);
        jpLista.setBounds((int)38.13, (int)118.13, 552 ,494);
        jpLista.setBackground(new Color(0,0,0,0));
        jpPrincipal.add(jpLista);

        imlist = new Decolib("/img/panelLista.png");
        imlist.setBounds(0,0, 552, 494);
        jpLista.add(imlist);

        dropApartado.setBounds((int)185.38, (int)68.34 , (int)338.82, (int)22.52);
        dropApartado.setOpaque(true);
        dropApartado.setBackground(new Color(225,225,225));
        dropApartado.setFont(new Font("arial", Font.ROMAN_BASELINE, 15));
        jpLista.add(dropApartado); 

        jpInformacion = new JPanel();
        jpInformacion.setLayout(null);
        jpInformacion.setBounds((int)605.5, (int)138.5, 541, 248);
        jpInformacion.setBackground(new Color(0, 0, 0,0));
        jpPrincipal.add(jpInformacion);

        imr1 = new Decolib("/img/panelDatos.png");
        imr1.setBounds(0, 0, 541, 248);
        jpInformacion.add(imr1); 

        //Fondo del panel princicipal
        im2 = new Decolib("/img/fondopanelfinal.png");
        im2.setBounds(0,0, 1196, 636);
        jpPrincipal.add(im2);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}