/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import exceptions.NoInsertadoException;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Cabecera;
import model.Detalle;

/**
 *
 * @author j4v13
 */
public class CabeceraPanel extends JPanel{

//    private Controlador crontrolador;
    private JComboBox cbxTipoMovimiento;
    private JComboBox cbxFormaPago;
    private JTextField txtCliente;
    private JTextField txtDetalle;
    private JTextField txtTotal;
    private JTextField txtFecha;
    private JButton btnAceptar;
    private Controlador controlador;

    public CabeceraPanel(Detalle detalle) {
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        super.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        
        controlador = new Controlador();  
        String[] movimientos = {"Venta"};
        cbxTipoMovimiento = new JComboBox(movimientos);
        
        String[] pagos = {"Contado", "Credito"};
        cbxFormaPago = new JComboBox(pagos);
        
        txtCliente = new JTextField(20);
        
        txtDetalle = new JTextField(detalle.getId());
        txtDetalle.setEditable(false);

        txtTotal = new JTextField(detalle.getImporte());
        txtTotal.setEditable(false);
        
        LocalDate date = LocalDate.now();
        String fecha = new String();
        if(date.getDayOfMonth()<10)
            fecha+="0";
        fecha+=date.getDayOfMonth()+"/";
        if(date.getMonthValue()<10)
            fecha+="0";
        fecha+=date.getMonthValue()+"/"+date.getYear();
        txtFecha = new JTextField(fecha);
        txtFecha.setEditable(false);
        
        btnAceptar = new JButton("Aceptar");

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Cabecera cabecera = new Cabecera();
                    cabecera.setMovimiento("Venta");
                    cabecera.setPago((String)cbxFormaPago.getSelectedItem());
                    cabecera.setCliente(txtCliente.getText());
                    cabecera.setDetalle(detalle.getId());
                    cabecera.setTotal(detalle.getImporte());
                    cabecera.setFecha(txtFecha.getText());
                    controlador.agregarCabecera(cabecera);
                    JOptionPane.showMessageDialog(CabeceraPanel.this, "Pedido agregado!");
                } catch(NoInsertadoException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(CabeceraPanel.this, "No pudo procesarse el pedido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        pnlTitulo.add(new JLabel("Nuevo pedido"));
        
        JPanel pnlMovimiento = new JPanel();
        pnlMovimiento.setLayout(new FlowLayout());
        pnlMovimiento.add(new JLabel("Tipo de movimiento:"));
        pnlMovimiento.add(cbxTipoMovimiento);
        
        JPanel pnlPago = new JPanel();
        pnlPago.setLayout(new FlowLayout());
        pnlPago.add(new JLabel("Forma de pago:"));
        pnlPago.add(cbxFormaPago);
        
        JPanel pnlCliente = new JPanel();
        pnlCliente.setLayout(new FlowLayout());
        pnlCliente.add(new JLabel("Cliente:"));
        pnlCliente.add(txtCliente);
        
        JPanel pnlDetalle = new JPanel();
        pnlDetalle.setLayout(new FlowLayout());
        pnlDetalle.add(new JLabel("Detalle id:"));        
        pnlDetalle.add(txtDetalle);
        pnlDetalle.add(new JLabel("Total $:"));        
        pnlDetalle.add(txtTotal);
        
        JPanel pnlFecha = new JPanel();
        pnlFecha.setLayout(new FlowLayout());
        pnlFecha.add(new JLabel("Fecha:"));
        pnlFecha.add(txtFecha);
        
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        pnlBoton.add(btnAceptar);
        
        super.add(pnlTitulo);
        super.add(pnlMovimiento);
        super.add(pnlPago);
        super.add(pnlCliente);
        super.add(pnlDetalle);
        super.add(pnlFecha);
        super.add(pnlBoton);
    }
}
