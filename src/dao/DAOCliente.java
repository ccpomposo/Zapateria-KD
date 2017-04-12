/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.ClienteNoEncontradoException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Usuario
 */
public interface DAOCliente {
    public Cliente buscar(String id) throws ClienteNoEncontradoException;
    public ArrayList<Cliente> buscar(Cliente cliente) throws ClienteNoEncontradoException;
    public int eliminar(Cliente cliente) throws ClienteNoEncontradoException;
    public int actualizar(Cliente cliente) throws ClienteNoEncontradoException;
    public int insertar(Cliente cliente);
    
}
