/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.CabeceraNoEncontradaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cabecera;

/**
 *
 * @author Usuario
 */
public class DAOCabeceraImpl implements DAOCabecera{

    @Override
    public ArrayList<Cabecera> buscar(String id) throws CabeceraNoEncontradaException {
        String consulta = String.format("SELECT * FROM Cabecera WHERE Cabe_Id = %s", id);
        ArrayList<Cabecera> r = new ArrayList();
        DataSource ds = new DataSourceOracle();
        ResultSet rs = (ResultSet)ds.ejecutarConsulta(consulta);
        Cabecera c = null;
        try {
            while(rs.next()){
                c = new Cabecera();
                c.setId(rs.getNString(1));
                c.setMovimiento(rs.getNString(2));
                c.setPago(rs.getNString(3));
                c.setCliente(rs.getNString(4));
                c.setDetalle(rs.getNString(5));
                c.setTotal(rs.getNString(6));
                c.setFecha(rs.getNString(7));
                r.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.cerrarConexion();
        if(r.isEmpty()){
            throw new CabeceraNoEncontradaException();
        }
        return r;
    }

    @Override
    public int insertar(Cabecera cabecera) {
        String consulta = String.format("INSERT INTO Cabecera VALUES(%s,(SELECT Tipo_Id FROM TIPODEMOVIMIENTO WHERE Tipo_Nombre = '%s'),(SELECT Form_Id FROM FORMADEPAGO WHERE Form_Nombre = '%s'),%s,%s,%s,TO_DATE('%s','dd/mm/YYYY'))",
                cabecera.getId(),cabecera.getMovimiento(),cabecera.getPago(),cabecera.getCliente(),cabecera.getDetalle(),cabecera.getTotal(),cabecera.getFecha());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        return r;
    }

    @Override
    public int eliminar(Cabecera cabecera) throws CabeceraNoEncontradaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Cabecera cabecera) throws CabeceraNoEncontradaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
