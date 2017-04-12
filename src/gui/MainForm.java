/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author j4v13
 */
public class MainForm extends JFrame {
    
    private JPanel pnlCentral;
    
    public MainForm() {
        super("Vendedora por catalogo");
        super.setLayout(new BorderLayout());
        super.setSize(680, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlCentral = new NuevoPedidoPanel(MainForm.this);        
        
        super.add(crearMenu(), BorderLayout.NORTH);
        super.add(pnlCentral, BorderLayout.CENTER);
        
        super.setVisible(true);
    }
    
    private JMenuBar crearMenu(){
        JMenuBar mainMenu = new JMenuBar();  
        
        JMenu mmCatalogo = new JMenu("Catalogo");
        JMenuItem mnNuevoPedido = new JMenuItem("Nuevo pedido");
        JMenuItem mnActualizarPedido = new JMenuItem("Actualizar pedido");
        JMenuItem mnSalir = new JMenuItem("Salir");   
        
        JMenu mmEdicion = new JMenu("Edicion");
        JMenuItem mnAgregarCliente = new JMenuItem("Agregar cliente");     
        JMenuItem mnActualizarCliente = new JMenuItem("Actualizar cliente");  
        JMenuItem mnEliminarCliente = new JMenuItem("Dar de baja cliente");  
        JMenuItem mnAgregarCalzado = new JMenuItem("Agregar calzado");     
        JMenuItem mnActualizarCalzado = new JMenuItem("Actualizar calzado");  
        JMenuItem mnEliminarCalzado = new JMenuItem("Dar de baja calzado");
        
        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem mnAcercaDe =  new JMenuItem("Acerca de");
        
        mmCatalogo.add(mnNuevoPedido);
        mmCatalogo.add(mnActualizarPedido);
        mmEdicion.addSeparator();
        mmCatalogo.add(mnSalir);
        
        mmEdicion.add(mnAgregarCliente);
        mmEdicion.add(mnActualizarCliente);
        mmEdicion.add(mnEliminarCliente);
        mmEdicion.addSeparator();
        mmEdicion.add(mnAgregarCalzado);
        mmEdicion.add(mnActualizarCalzado);
        mmEdicion.add(mnEliminarCalzado);
        
        mmAyuda.add(mnAcercaDe);
        
        mnNuevoPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new NuevoPedidoPanel(MainForm.this));
            }
        });
        
        mnActualizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new ActualizarPedidoPanel());
            }
        });
        
        mnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MainForm.this.dispose();
            }
        });
        
        mnAgregarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new AgregarClientePanel());
            }
        });
        
        mnActualizarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new ActualizarClientePanel());
            }
        });
        
        mnEliminarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new EliminarClientePanel());
            }
        });
        
        mnAgregarCalzado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new AgregarCalzadoPanel());
            }
        });
        
        mnActualizarCalzado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new ActualizarCalzadoPanel());
            }
        });
        
        mnEliminarCalzado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setPnlCentral(new EliminarCalzadoPanel());
            }
        });
        
        mnAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){                
                JOptionPane.showMessageDialog(MainForm.this, "Developed by @ccpomposo & JavierAvendanoJmz.",
                        "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });  
                
        mainMenu.add(mmCatalogo); 
        mainMenu.add(mmEdicion);
        mainMenu.add(mmAyuda);  
        
        return mainMenu;                
    }
    
    public void setPnlCentral(JPanel panel) {
        super.remove(pnlCentral);
        this.pnlCentral = null;
        this.pnlCentral = panel;
        super.add(pnlCentral, BorderLayout.CENTER);
        super.setVisible(true);
    }
}

class Test {
    public static void main(String[] args) {
        new MainForm();
    }
}