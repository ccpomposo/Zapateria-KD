/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.ZapatoNoEncontradoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Zapato;

/**
 *
 * @author Usuario
 */
public class DAOZapatoImpl implements DAOZapato{

    @Override
    public Zapato buscar(String id) throws ZapatoNoEncontradoException {
        DataSource ds = new DataSourceOracle();
        String consultaZapato = String.format("SELECT * FROM Zapato WHERE Zapa_Modelo = %s AND Zapa_Activo = 1", id);
        ResultSet rsZapato = (ResultSet) ds.ejecutarConsulta(consultaZapato);
        Zapato zapato = null;
        ArrayList<String> tallas = null;
        try {
            while (rsZapato.next()) {
                zapato = new Zapato();
                tallas = new ArrayList();
                zapato.setModelo(rsZapato.getNString(1));
                zapato.setColor(rsZapato.getNString(2));
                zapato.setTacon(rsZapato.getNString(3));
                zapato.setPrecio(rsZapato.getNString(4));
                String consultaCategoria = String.format("SELECT * FROM Categoria WHERE Cate_Id = %s", rsZapato.getString(5));
                ResultSet rsCategoria = (ResultSet)ds.ejecutarConsulta(consultaCategoria);
                while (rsCategoria.next()){
                    zapato.setCategoria(rsCategoria.getNString(2));
                }
                String consultaTallas = String.format("SELECT * FROM Tallas WHERE Zapa_Id = %s", zapato.getModelo());
                ResultSet rsTallas = (ResultSet)ds.ejecutarConsulta(consultaTallas);
                while(rsTallas.next()) {
                    tallas.add(rsTallas.getString(2));
                }
                zapato.setTallas(tallas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (zapato == null) {
            ds.cerrarConexion();
            throw new ZapatoNoEncontradoException();
        }
        ds.cerrarConexion();
        return zapato;
    }

    @Override
    public ArrayList<Zapato> buscar(Zapato zapato) throws ZapatoNoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Zapato zapato) throws ZapatoNoEncontradoException {
        String consulta = String.format("UPDATE Zapato SET Zapa_Activo = 0 WHERE Zapa_Modelo = %s", zapato.getModelo());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        if (r <= 0) {
            throw new ZapatoNoEncontradoException();
        }
        return r;
    }

    @Override
    public int actualizar(Zapato zapato) throws ZapatoNoEncontradoException {
        String consulta = String.format("UPDATE Zapato SET Zapa_Color = '%s', Zapa_Tacon = %s, "
                + "Zapa_Precio = %s, Cate_Id = (SELECT Cate_Id FROM Categoria WHERE Cate_Nombre = '%s')"
                + "WHERE Zapa_Modelo = %s", zapato.getColor(), zapato.getTacon(),zapato.getPrecio(),
                zapato.getCategoria(), zapato.getModelo());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ds.cerrarConexion();
        if (r <= 0) {
            throw new ZapatoNoEncontradoException();
        }
        return r;
    }

    @Override
    public int insertar(Zapato zapato) {
        String consulta = String.format("INSERT INTO Zapato VALUES(SEQ_ID_ZAPATO.NEXTVAL,"
                + "'%s',%s,%s,(SELECT Cate_Id FROM Categoria WHERE Cate_Nombre = '%s'),1)",
                zapato.getColor(), zapato.getTacon(), zapato.getPrecio(), zapato.getCategoria());
        DataSource ds = new DataSourceOracle();
        int r = ds.ejecutarActualizacion(consulta);
        ArrayList<String> tallas = zapato.getTallas();
        ResultSet rs = (ResultSet)ds.ejecutarConsulta("SELECT * FROM Zapato WHERE Zapa_Modelo = (SELECT MAX(Zapa_Modelo) FROM Zapato)");
        Zapato nZapato = null;
        try {
            while(rs.next()){
                nZapato = new Zapato();
                nZapato.setModelo(rs.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOZapatoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String talla : tallas) {
            String consultaT = String.format("INSERT INTO Tallas VALUES(%s,%s)",nZapato.getModelo(), talla);
            ds.ejecutarActualizacion(consultaT);
        }
        ds.cerrarConexion();
        return r;
    }
    
}
