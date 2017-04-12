/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import exceptions.ClienteNoEncontradoException;
import exceptions.DetalleNoEncontradoException;
import exceptions.NoInsertadoException;
import exceptions.ZapatoNoEncontradoException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Usuario
 */
public class Controlador {
    DAOCliente daoCliente;
    DAOZapato daoZapato;
    DAODetalle daoDetalle;
    DAOCabecera daoCabecera;
    
    public Controlador(){
        this.daoCliente = new DAOClienteImpl();
        this.daoZapato = new DAOZapatoImpl();
        this.daoDetalle = new DAODetalleImpl();
        this.daoCabecera = new DAOCabeceraImpl();
    }
    
    public String calcularImporte(String cantidad, String modelo) throws ZapatoNoEncontradoException {
        Zapato zapato = this.daoZapato.buscar(modelo);
        return String.valueOf((Double.valueOf(cantidad))*Double.valueOf(zapato.getPrecio()));
    }
    
    public String agregarDetalle(Detalle detalle) throws ZapatoNoEncontradoException, NoInsertadoException{
        int r = this.daoDetalle.insertar(detalle);
        Detalle d = this.daoDetalle.getUltimo();
        if(r <= 0){
            throw new NoInsertadoException();
        }
        return d.getId();
    }
    
    public void agregarCabecera(Cabecera cabecera) throws NoInsertadoException{
       cabecera.setId("1");
        int r = this.daoCabecera.insertar(cabecera);
        if( r <= 0) {
            throw new NoInsertadoException();
        }
    }
    
    public void actualizarDetalle(Detalle detalle) throws ZapatoNoEncontradoException, DetalleNoEncontradoException {
        Zapato z = this.buscarZapato(detalle.getZapato());
        this.daoDetalle.actualizar(detalle);
    }
    
    public Zapato buscarZapato(String id) throws ZapatoNoEncontradoException {
        Zapato zapato = this.daoZapato.buscar(id);
        return zapato;
    }
    
    public Cliente buscarCliente(String id) throws ClienteNoEncontradoException{
        return this.daoCliente.buscar(id);
    }
    
    public void agregarCliente(Cliente cliente) throws NoInsertadoException{
        int r = this.daoCliente.insertar(cliente);
        if (r <= 0) {
            throw new NoInsertadoException();
        }
    }
    
    public void actualizarCliente(Cliente cliente) throws ClienteNoEncontradoException {
        this.daoCliente.actualizar(cliente);
    }
    
    public void eliminarCliente(String id) throws ClienteNoEncontradoException {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        this.daoCliente.eliminar(cliente);
    }
    
    public void agregarCalzado(Zapato zapato) throws NoInsertadoException {
        int r = this.daoZapato.insertar(zapato);
        if(r <= 0) {
            throw new NoInsertadoException();
        }
    }
    
    public void actualizarCalzado(Zapato zapato) throws ZapatoNoEncontradoException {
        this.daoZapato.actualizar(zapato);
    }
    
    public void eliminarCalzado(String id) throws ZapatoNoEncontradoException {
        Zapato z = new Zapato();
        z.setModelo(id);
        this.daoZapato.eliminar(z);
    }
}
