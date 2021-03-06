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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Cliente;

/**
 *
 * @author javier
 */
public class AgregarClientePanel extends JPanel {
    
//    private Controlador crontrolador;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JButton btnAgregar;
    private Controlador controlador;
    
    public AgregarClientePanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        
        controlador = new Controlador();
        txtNombre = new JTextField(20);
        txtPaterno = new JTextField(20);
        txtMaterno = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtCorreo = new JTextField(20);
        txtTelefono = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(txtNombre.getText());
                    cliente.setPaterno(txtPaterno.getText());
                    cliente.setMaterno(txtMaterno.getText());
                    cliente.setDireccion(txtDireccion.getText());
                    cliente.setCorreo(txtCorreo.getText());
                    cliente.setTelefono(String.valueOf(Integer.valueOf(txtTelefono.getText())));
                    controlador.agregarCliente(cliente);
                    JOptionPane.showMessageDialog(AgregarClientePanel.this, "Cliente agregado!");
                } catch(NoInsertadoException ex) {
                    JOptionPane.showMessageDialog(AgregarClientePanel.this, "Ocurrio un error al registrar al cliente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Agregar cliente"));
        
        JPanel pnlNombre = new JPanel();
        pnlNombre.setLayout(new FlowLayout());
        pnlNombre.add(new JLabel("Nombre:"));
        pnlNombre.add(txtNombre);
        
        JPanel pnlPaterno = new JPanel();
        pnlPaterno.setLayout(new FlowLayout());
        pnlPaterno.add(new JLabel("A Paterno:"));
        pnlPaterno.add(txtPaterno);
        
        JPanel pnlMaterno = new JPanel();
        pnlMaterno.setLayout(new FlowLayout());
        pnlMaterno.add(new JLabel("A Materno:"));
        pnlMaterno.add(txtMaterno);
        
        JPanel pnlDireccion = new JPanel();
        pnlDireccion.setLayout(new FlowLayout());
        pnlDireccion.add(new JLabel("Direccion:"));
        pnlDireccion.add(txtDireccion);
        
        JPanel pnlCorreo = new JPanel();
        pnlCorreo.setLayout(new FlowLayout());
        pnlCorreo.add(new JLabel("Correo:"));
        pnlCorreo.add(txtCorreo);
        
        JPanel pnlTelefono = new JPanel();
        pnlTelefono.setLayout(new FlowLayout());
        pnlTelefono.add(new JLabel("Telefono:"));
        pnlTelefono.add(txtTelefono);
        
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        pnlBoton.add(btnAgregar);
        
        super.add(pnlTitulo);
        super.add(pnlNombre);
        super.add(pnlPaterno);
        super.add(pnlMaterno);
        super.add(pnlDireccion);
        super.add(pnlCorreo);
        super.add(pnlTelefono);
        super.add(pnlBoton);
    }
    
}
