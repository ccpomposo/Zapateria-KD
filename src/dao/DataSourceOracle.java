/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class DataSourceOracle implements DataSource{
    private Connection conexion;
    private Statement statement;

    public DataSourceOracle() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "visual", "pass");
            this.statement = this.conexion.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    @Override
    public Object ejecutarConsulta(String consulta){
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery(consulta);
            //this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (Object)rs;
    }
    
    @Override
    public int ejecutarActualizacion(String consulta){
        int rs = 0;
        try {
            rs = this.statement.executeUpdate(consulta);
            //this.conexion.close();
            this.conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
