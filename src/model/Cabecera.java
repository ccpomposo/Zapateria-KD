/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Cabecera {
    private String id;
    private String movimiento;
    private String pago;
    private String cliente;
    private String detalle;
    private String total;
    private String fecha;

    public Cabecera() {
    }

    public Cabecera(String id, String movimiento, String pago, String cliente, String detalle, String total, String fecha) {
        this.id = id;
        this.movimiento = movimiento;
        this.pago = pago;
        this.cliente = cliente;
        this.detalle = detalle;
        this.total = total;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
