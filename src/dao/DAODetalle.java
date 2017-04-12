/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DetalleNoEncontradoException;
import model.Detalle;

/**
 *
 * @author Usuario
 */
public interface DAODetalle {
    public Detalle buscar(String id) throws DetalleNoEncontradoException;
    public int insertar(Detalle detalle);
    public int eliminar(Detalle detalle) throws DetalleNoEncontradoException;
    public int actualizar(Detalle detalle) throws DetalleNoEncontradoException;
    public Detalle getUltimo();
}
