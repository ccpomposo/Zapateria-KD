/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import exceptions.ZapatoNoEncontradoException;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author j4v13
 */
public class EliminarCalzadoPanel extends JPanel{
    
    private JTextField txtBuscar;
    private JButton btnEliminar;
    private Controlador controlador;
    
    public EliminarCalzadoPanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        
        controlador = new Controlador();
        txtBuscar = new JTextField(20);
        btnEliminar = new JButton("Eliminar");
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String parametro = txtBuscar.getText();
                    controlador.eliminarCalzado(parametro);
                    JOptionPane.showMessageDialog(EliminarCalzadoPanel.this, "Zapato eliminado!");
                } catch(ZapatoNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(EliminarCalzadoPanel.this, "No se encuentra el modelo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Dar de baja calzado"));
        
        JPanel pnlBusqueda = new JPanel();
        pnlBusqueda.setLayout(new FlowLayout());
        pnlBusqueda.add(new JLabel("Buscar:"));
        pnlBusqueda.add(txtBuscar);
               
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        pnlBoton.add(btnEliminar);
        
        super.add(pnlTitulo);
        super.add(pnlBusqueda);
        super.add(pnlBoton);
    }    
}
