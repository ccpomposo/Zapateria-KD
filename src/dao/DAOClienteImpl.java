/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.ClienteNoEncontradoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author Usuario
 */
public class DAOClienteImpl implements DAOCliente {

    @Override
    public Cliente buscar(String id) throws ClienteNoEncontradoException {
        DataSource ds = new DataSourceOracle();
        String consulta = String.format("SELECT * FROM Cliente WHERE Clie_Id = %s", id);
        ResultSet rs = (ResultSet) ds.ejecutarConsulta(consulta);
        Cliente cliente = null;
        try {
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getNString(1));
                cliente.setPaterno(rs.getNString(2));
                cliente.setMaterno(rs.getNString(3));
                cliente.setNombre(rs.getNString(4));
                cliente.setDireccion(rs.getNString(5));
                cliente.setTelefono(rs.getNString(6));
                cliente.setCorreo(rs.getNString(7));
                cliente.setActivo(rs.getNString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cliente == null) {
            ds.cerrarConexion();
            throw new ClienteNoEncontradoException();
        }
        ds.cerrarConexion();
        return cliente;
    }

    @Override
    public ArrayList<Cliente> buscar(Cliente cliente) throws ClienteNoEncontradoException {
        ArrayList<Cliente> resultado = new ArrayList();
        if (cliente.getId() != null) {
            resultado.add(this.buscar(cliente.getId()));
            return resultado;
        } else {
            String consulta = String.format("SELECT * FROM Cliente WHERE Clie_Paterno LIKE '%s%s%s' OR Clie_Materno LIKE '%s%s%s'", 
                    "%",cliente.getPaterno(),"%", "%",cliente.getMaterno(),"%");
            DataSource ds = new DataSourceOracle();
            ResultSet rs = (ResultSet) ds.ejecutarConsulta(consulta);
            try {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getNString(1));
                    c.setPaterno(rs.getNString(2));
                    c.setMaterno(rs.getNString(3));
                    c.setNombre(rs.getNString(4));
                    c.setDireccion(rs.getNString(5));
                    c.setTelefono(rs.getNString(6));
                    c.setCorreo(rs.getNString(7));
                    c.setActivo(rs.getNString(8));
                    resultado.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            ds.cerrarConexion();
            if (resultado.isEmpty()) {
                throw new ClienteNoEncontradoException();
            } else {
                return resultado;
            }
        }
    }

    @Override
    public int eliminar(Cliente cliente) throws ClienteNoEncontradoException {
        String consulta = String.format("UPDATE Cliente SET Clie_Activo = 0 WHERE Clie_Id = %s", cliente.getId());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        if (r <= 0) {
            throw new ClienteNoEncontradoException();
        }
        return r;
    }

    @Override
    public int actualizar(Cliente cliente) throws ClienteNoEncontradoException {
        String consulta = String.format("UPDATE CLIENTE SET Clie_Paterno = '%s', Clie_Materno = '%s', Clie_Nombre = '%s', Clie_Direccion = '%s', Clie_Telefono = '%s', Clie_Email = '%s' WHERE Clie_Id = %s", 
                cliente.getPaterno(), cliente.getMaterno(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(),
                cliente.getCorreo(), cliente.getId());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        if (r <= 0) {
            throw new ClienteNoEncontradoException();
        }
        return r;
    }

    @Override
    public int insertar(Cliente cliente) {
        String consulta = String.format("INSERT INTO Cliente VALUES (SEQ_ID_CLIENTE.NEXTVAL,'%s','%s','%s','%s','%s','%s',1)", cliente.getPaterno(),
                cliente.getMaterno(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        return r;
    }

}
