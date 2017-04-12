/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.ZapatoNoEncontradoException;
import java.util.ArrayList;
import model.Zapato;

/**
 *
 * @author Usuario
 */
public interface DAOZapato {
    public Zapato buscar(String id) throws ZapatoNoEncontradoException;
    public ArrayList<Zapato> buscar(Zapato zapato) throws ZapatoNoEncontradoException;
    public int eliminar(Zapato zapato) throws ZapatoNoEncontradoException;
    public int actualizar(Zapato zapato) throws ZapatoNoEncontradoException;
    public int insertar(Zapato zapato);
}
