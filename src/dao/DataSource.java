/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Usuario
 */
public interface DataSource {
    public Object ejecutarConsulta(String consulta);
    public int ejecutarActualizacion(String consulta);
    public void cerrarConexion();
}
