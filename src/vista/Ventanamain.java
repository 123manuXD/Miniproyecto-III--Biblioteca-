package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventanamain extends JFrame implements ActionListener{

    private JPanel jpLista, jpInformacion, jpPrincipal;
    //botones CRUD
    private JButton btnagregar, btnconsultar, btnmodificar, btneliminar;
    private Decolib im1, im2, im3, im4, im5, im6;
    private JLabel apartado;

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
        im2 = new Decolib("/img/Fondopanelp.png");
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