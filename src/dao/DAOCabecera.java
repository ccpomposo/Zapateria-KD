/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.CabeceraNoEncontradaException;
import java.util.ArrayList;
import model.Cabecera;

/**
 *
 * @author Usuario
 */
public interface DAOCabecera {
    public ArrayList<Cabecera> buscar(String id) throws CabeceraNoEncontradaException;
    public int insertar(Cabecera cabecera);
    public int eliminar(Cabecera cabecera) throws CabeceraNoEncontradaException;
    public int actualizar(Cabecera cabecera) throws CabeceraNoEncontradaException;
}
