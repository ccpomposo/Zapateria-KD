/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import exceptions.DetalleNoEncontradoException;
import exceptions.ZapatoNoEncontradoException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Detalle;

/**
 *
 * @author j4v13
 */
public class ActualizarPedidoPanel extends JPanel{
    
    private JTextField txtId;
    private JTextField txtZapato;
    private JTextField txtCantidad;
    private JTextField txtImporte;
    private JButton btnActualizar;
    private Controlador controlador;

    public ActualizarPedidoPanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        
        controlador = new Controlador();     
        txtId = new JTextField(20);
        txtZapato = new JTextField(20);
        txtCantidad = new JTextField(20);
        txtImporte = new JTextField(20);
        txtImporte.setEditable(false);
        btnActualizar = new JButton("Actualizar");
        
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String i = controlador.calcularImporte(txtZapato.getText(),txtCantidad.getText());
                    txtImporte.setText(i); 
                    
                    Detalle detalle = new Detalle();
                    detalle.setId(txtId.getText());
                    detalle.setZapato(txtZapato.getText());
                    detalle.setCantidad(txtCantidad.getText());
                    detalle.setImporte(String.valueOf(i));
                    controlador.actualizarDetalle(detalle);
                    JOptionPane.showMessageDialog(ActualizarPedidoPanel.this, "Pedido actualizado!");
                } catch (ZapatoNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(ActualizarPedidoPanel.this, "No se encuentra el modelo", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DetalleNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(ActualizarPedidoPanel.this, "El numero de pedido es erróneo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });       
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Actualizar pedido"));
        
        JPanel pnlId = new JPanel();
        pnlId.setLayout(new FlowLayout());
        pnlId.add(new JLabel("Detalle Id:"));
        pnlId.add(txtId);
        
        JPanel pnlZapato = new JPanel();
        pnlZapato.setLayout(new FlowLayout());
        pnlZapato.add(new JLabel("Modelo de zapato:"));
        pnlZapato.add(txtZapato);
        
        JPanel pnlCantidad = new JPanel();
        pnlCantidad.setLayout(new FlowLayout());
        pnlCantidad.add(new JLabel("Cantidad:"));
        pnlCantidad.add(txtCantidad);
        
        JPanel pnlImporte = new JPanel();
        pnlImporte.setLayout(new FlowLayout());
        pnlImporte.add(new JLabel("Importe:"));
        pnlImporte.add(txtImporte);
        
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        pnlBoton.add(btnActualizar);
        
        super.add(pnlTitulo);
        super.add(pnlId);
        super.add(pnlZapato);
        super.add(pnlCantidad);
        super.add(pnlImporte);
        super.add(pnlBoton);
    }
    
}
