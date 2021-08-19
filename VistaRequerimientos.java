package vista;

import java.util.ArrayList;
import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class VistaRequerimientos extends JFrame {
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 700, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(7,7,7,7));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelTitulo = new JLabel("Aplicación GUI- Misión TIC 2022");
        labelTitulo.setBounds(30, 20, 150, 25);
        contentPane.add(labelTitulo);
        

        JLabel labelDiseñador = new JLabel("JASSAN ARTETA");
        labelDiseñador.setBounds(30, 32, 150, 25);
        contentPane.add(labelDiseñador);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 450, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("REQUERIMIENTO 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28, 537, 150, 29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("REQUERIMIENTO 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento2();
            }
        });
        btnConsulta2.setBounds(198, 537, 150, 29);
        contentPane.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("REQUERIMIENTO 3 ");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento3();
            }
        });
        btnConsulta3.setBounds(368, 537, 150, 29);
        contentPane.add(btnConsulta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(538, 537, 140, 29);
        contentPane.add(btnLimpiar);

    }
    public static void requerimiento1() {
        try {
            // Su código
            ArrayList<Requerimiento_1Vo> resultado_requerimiento1 = controlador.consultarRequerimiento1();
            //resultado_requerimiento1.forEach(System.out::println);
            String salida = "Salario promedio <500.000\n\nCiudad_Residencia\tSalario_Promedio\n\n";
            for (Requerimiento_1Vo requerimiento_1Vo: resultado_requerimiento1)
            {
                salida += requerimiento_1Vo.getCiudadResidencia();
                salida += "\t";
                salida += requerimiento_1Vo.getPromedio();
                salida += "\n";
            }
            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento2() {
        try {
            // Su código
            ArrayList<Requerimiento_2Vo> resultado_requerimiento2 = controlador.consultarRequerimiento2();
            //resultado_requerimiento2.forEach(System.out::println);
            String salida = "Proyectos comprados en Bogotá\n\nProyecto\tProveedor\n\n";
            for (Requerimiento_2Vo requerimiento_2Vo: resultado_requerimiento2)
            {
                salida += requerimiento_2Vo.getIdProyecto();
                salida += "\t";
                salida += requerimiento_2Vo.getProveedor();
                salida += "\n";
            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void requerimiento3() {
        try {
            // Su código
            ArrayList<Requerimiento_3Vo> resultado_requerimiento3 = controlador.consultarRequerimiento3();
            //resultado_requerimiento3.forEach(System.out::println);
            String salida = "Proyectos 20 a 35/Material\n\nProyecto\tMaterial\n\n";
            for (Requerimiento_3Vo requerimiento_3Vo: resultado_requerimiento3)
            {
                salida += requerimiento_3Vo.getIdProyecto();
                salida += "\t";
                salida += requerimiento_3Vo.getMaterial();
                salida += "\n";
            }
            textArea.setText(salida);
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

}