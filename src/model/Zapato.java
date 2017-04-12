/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Zapato {
    private String modelo;
    private ArrayList tallas;
    private String color;
    private String tacon;
    private String precio;
    private String categoria;
    private String descripcion;

    public Zapato() {
    }

    public Zapato(String modelo, ArrayList tallas, String color, String tacon, String precio, String categoria, String descripcion) {
        this.modelo = modelo;
        this.tallas = tallas;
        this.color = color;
        this.tacon = tacon;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ArrayList getTallas() {
        return tallas;
    }

    public void setTallas(ArrayList tallas) {
        this.tallas = tallas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTacon() {
        return tacon;
    }

    public void setTacon(String tacon) {
        this.tacon = tacon;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
