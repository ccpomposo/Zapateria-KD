/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import exceptions.NoInsertadoException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Zapato;

/**
 *
 * @author j4v13
 */
public class AgregarCalzadoPanel extends JPanel{
    
//    private Controlador crontrolador;    
    private ArrayList<JCheckBox> tallas;
    private JTextField txtColor;
    private JTextField txtTacon;
    private JTextField txtPrecio;
    private JTextField txtCategoria;
    private JTextField txtDescripcion;
    private JButton btnAgregar;
    private Controlador controlador;
    
    public AgregarCalzadoPanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        controlador = new Controlador();
        tallas = new ArrayList();
        for (int i = 0; i < 12; i++) {
            JCheckBox aux = new JCheckBox();
            tallas.add(aux);
        }
        txtColor = new JTextField(20);
        txtTacon = new JTextField(20);
        txtPrecio = new JTextField(20);
        txtCategoria = new JTextField(20);
        txtDescripcion = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Zapato zapato = new Zapato();
                    
                    ArrayList<String> t = new ArrayList();
                    for (int i = 0; i < tallas.size(); i++) {
                        if(tallas.get(i).isSelected())
                            t.add(String.valueOf(i+19));
                    }                    
                    zapato.setTallas(t);
                    System.out.println(t);
                    zapato.setColor(txtColor.getText());
                    zapato.setTacon(txtTacon.getText());                    
                    zapato.setPrecio(txtPrecio.getText());
                    zapato.setCategoria(txtCategoria.getText());
                    zapato.setDescripcion(txtDescripcion.getText());
                    controlador.agregarCalzado(zapato);
                    JOptionPane.showMessageDialog(AgregarCalzadoPanel.this, "Calzado agregado!");
                } catch(NoInsertadoException ex) {
                    JOptionPane.showMessageDialog(AgregarCalzadoPanel.this, "Ocurrio un error al agregar el modelo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Agregar calzado"));
        
        JPanel pnlTalla = new JPanel();
        pnlTalla.setLayout(new FlowLayout());
        pnlTalla.add(new JLabel("Tallas "));
        for (int i = 0; i < tallas.size(); i++) {
            pnlTalla.add(new JLabel((19+i)+":"));
            pnlTalla.add(tallas.get(i));
        }
        
        JPanel pnlColor = new JPanel();
        pnlColor.setLayout(new FlowLayout());
        pnlColor.add(new JLabel("Color:"));
        pnlColor.add(txtColor);
        
        JPanel pnlTacon = new JPanel();
        pnlTacon.setLayout(new FlowLayout());
        pnlTacon.add(new JLabel("Tacon:"));
        pnlTacon.add(txtTacon);
        
        JPanel pnlPrecio = new JPanel();
        pnlPrecio.setLayout(new FlowLayout());
        pnlPrecio.add(new JLabel("Precio:"));
        pnlPrecio.add(txtPrecio);
        
        JPanel pnlCategoria = new JPanel();
        pnlCategoria.setLayout(new FlowLayout());
        pnlCategoria.add(new JLabel("Categoria:"));
        pnlCategoria.add(txtCategoria);
        
        JPanel pnlDescripcion = new JPanel();
        pnlDescripcion.setLayout(new FlowLayout());
        pnlDescripcion.add(new JLabel("Descripcion:"));
        pnlDescripcion.add(txtDescripcion);
        
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        pnlBoton.add(btnAgregar);
        
        super.add(pnlTitulo);
        super.add(pnlTalla);
        super.add(pnlColor);
        super.add(pnlTacon);
        super.add(pnlPrecio);
        super.add(pnlCategoria);
        super.add(pnlDescripcion);
        super.add(pnlBoton);
    }
    
}
