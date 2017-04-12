/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import exceptions.NoInsertadoException;
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
public class NuevoPedidoPanel extends JPanel {
    
    private Controlador controlador;
    private Detalle detalle;
    private JTextField txtZapato;
    private JTextField txtCantidad;
    private JTextField txtImporte;
    private JButton btnCalcular;
    private JButton btnContinuar;

    public NuevoPedidoPanel(MainForm mainForm) {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        
        controlador = new Controlador();        
        txtZapato = new JTextField(20);
        txtCantidad = new JTextField(20);
        txtImporte = new JTextField(20);
        txtImporte.setEditable(false);
        btnCalcular = new JButton("Calcular");
        btnContinuar = new JButton("Aceptar");
        btnContinuar.setEnabled(false);
        
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String i = controlador.calcularImporte(txtZapato.getText(), txtCantidad.getText());
                    txtImporte.setText(i); 
                    
                    detalle = new Detalle();
                    detalle.setZapato(txtZapato.getText());
                    detalle.setCantidad(txtCantidad.getText());
                    detalle.setImporte(i);
                    detalle.setId(controlador.agregarDetalle(detalle));                    
                    btnContinuar.setEnabled(true);
                } catch (ZapatoNoEncontradoException ex) {
                    JOptionPane.showMessageDialog(NuevoPedidoPanel.this, "No se encuentra el modelo", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NoInsertadoException ex) {
                    JOptionPane.showMessageDialog(NuevoPedidoPanel.this, "No se pudo procesar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    mainForm.setPnlCentral(new CabeceraPanel(detalle));
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(NuevoPedidoPanel.this, "Algo salio mal", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Nuevo pedido"));
        
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
        pnlBoton.add(btnCalcular);
        pnlBoton.add(btnContinuar);
        
        super.add(pnlTitulo);
        super.add(pnlZapato);
        super.add(pnlCantidad);
        super.add(pnlImporte);
        super.add(pnlBoton);
    }
    
}
