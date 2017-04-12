/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DetalleNoEncontradoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Detalle;

/**
 *
 * @author Usuario
 */
public class DAODetalleImpl implements DAODetalle{

    @Override
    public Detalle buscar(String id) throws DetalleNoEncontradoException {
        String consulta = String.format("SELECT * FROM Detalle WHERE Deta_Id = %s", id);
        DataSource ds = new DataSourceOracle();
        ResultSet rs = (ResultSet)ds.ejecutarConsulta(consulta);
        Detalle d = null;
        try {
            while(rs.next()) {
                d = new Detalle();
                d.setId(rs.getNString(1));
                d.setZapato(rs.getNString(2));
                d.setCantidad(rs.getNString(3));
                d.setImporte(rs.getNString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetalleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.cerrarConexion();
        if (d == null) {
            throw new DetalleNoEncontradoException();
        }
        return d;
    }

    @Override
    public int insertar(Detalle detalle) {
        String consulta = String.format("INSERT INTO Detalle VALUES(SEQ_ID_DETALLE.NEXTVAL,%s,%s,%s)",
                detalle.getZapato(),detalle.getCantidad(),detalle.getImporte());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        return r;
    }

    @Override
    public int eliminar(Detalle detalle) throws DetalleNoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Detalle detalle) throws DetalleNoEncontradoException {
        String consulta = String.format("UPDATE Detalle SET Deta_Zapato = %s, Deta_Cantidad = %s, Deta_Importe = %s WHERE Deta_Id = %s",
                detalle.getZapato(), detalle.getCantidad(), detalle.getImporte(), detalle.getId());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        if(r <= 0){
            throw new DetalleNoEncontradoException();
        }
        return r;
    }

    @Override
    public Detalle getUltimo() {
        String consulta = "SELECT * FROM Detalle WHERE Deta_Id = (Select MAX(Deta_Id) FROM Detalle)";
        DataSource ds = new DataSourceOracle();
        ResultSet rs = (ResultSet)ds.ejecutarConsulta(consulta);
        Detalle deta = null;
        try {
            while(rs.next()) {
                deta = new Detalle();
                deta.setId(rs.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetalleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deta;
    }
    
}
