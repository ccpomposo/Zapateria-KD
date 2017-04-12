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
public class Cliente {
    private String id;    
    private String nombre;
    private String paterno;
    private String materno;
    private String direccion;
    private String telefono;
    private String correo;
    private String activo;

    public Cliente() {
    }

    public Cliente(String id, String nombre, String paterno, String materno, String direccion, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
}
