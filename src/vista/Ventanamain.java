package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventanamain extends JFrame implements ActionListener{

    private JPanel jpLista, jpInformacion, jpPrincipal;
    //botones CRUD
    private JButton btnagregar, btnlimpiar, btneditar, btneliminar;
    private Decolib im1, im2, im3, im4, im5, im6, im7;

    private String[] opcionesApartado = {"Usuarios", "Recursos", "Autores", "Generos literarios", "Prestamo"};
    private JComboBox<String> dropApartado = new JComboBox<>(opcionesApartado);

    public Ventanamain (){
        iniciarComponentes();
        im1 = new Decolib("/img/Fondo.png");
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
        
        im3 = new Decolib("/img/Apartado.png");
        im3.setBounds((int)606.5, (int)56.5, 277, 57);
        jpPrincipal.add(im3);

        dropApartado.setBounds((int)886.5, (int)56.5, 257, 57);
        dropApartado.setOpaque(true);
        dropApartado.setBackground(new Color(225,225,225));
        dropApartado.setFont(new Font("arial", Font.ROMAN_BASELINE, 25));
        jpPrincipal.add(dropApartado);

        btnagregar = new JButton("");
        btnagregar.setBounds(584, 420, 113, 109);
        btnagregar.setOpaque(true);
        btnagregar.setContentAreaFilled(false);
        btnagregar.setLayout(null);
        jpPrincipal.add(btnagregar);

        btnlimpiar = new JButton("");
        btnlimpiar.setBounds((int)733.56, 420, 113, 109);
        btnlimpiar.setOpaque(true);
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setLayout(null);
        jpPrincipal.add(btnlimpiar);

        btneliminar = new JButton();
        btneliminar.setBounds((int)888.41, 420, 113, 109);
        btneliminar.setOpaque(true);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setLayout(null);
        jpPrincipal.add(btneliminar);

        btneditar = new JButton();
        btneditar.setBounds((int)1040.22, 420, 113, 109);
        btneditar.setOpaque(true);
        btneditar.setContentAreaFilled(false);
        btneditar.setLayout(null);
        jpPrincipal.add(btneditar);
        

        im4 = new Decolib("/img/btnadd.png");
        im4.setBounds(0,0, 113, 109);
        btnagregar.add(im4);

        im5 = new Decolib("/img/btnlimpiar.png");
        im5.setBounds(0,0, 113, 109);
        btnlimpiar.add(im5);

        im6 = new Decolib("/img/btnEliminar.png");
        im6.setBounds(0,0, 113, 109);
        btneliminar.add(im6);

        im7 = new Decolib("/img/btneditar.png");
        im7.setBounds(0,0, 113, 109);    
        btneditar.add(im7);

        //configurar panel tablas
        jpLista = new JPanel();
        jpLista.setLayout(null);
        jpLista.setBounds((int)50.03, (int)137.53, (int)518.75 ,(int)464.42);
        jpLista.setBackground(new Color(252, 248, 232));
        jpPrincipal.add(jpLista);

        jpInformacion = new JPanel();
        jpInformacion.setLayout(null);
        jpInformacion.setBounds((int)605.5, (int)138.5, 541, 248);
        jpInformacion.setBackground(new Color(252, 248, 232));
        jpPrincipal.add(jpInformacion);

        //Fondo del panel princicipal
        im2 = new Decolib("/img/Fondopanel2.png");
        im2.setBounds(0,0, 1196, 636);
        jpPrincipal.add(im2);

        


        //confiugar panel datos
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}