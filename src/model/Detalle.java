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
public class Detalle {
    private String id;
    private String zapato;
    private String cantidad;
    private String importe;

    public Detalle() {
    }

    public Detalle(String id, String zapato, String cantidad, String importe) {
        this.id = id;
        this.zapato = zapato;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZapato() {
        return zapato;
    }

    public void setZapato(String zapato) {
        this.zapato = zapato;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
}
