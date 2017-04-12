/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Usuario
 */
public class CabeceraNoEncontradaException extends Exception {

    /**
     * Creates a new instance of <code>CabeceraNoEncontradaException</code>
     * without detail message.
     */
    public CabeceraNoEncontradaException() {
    }

    /**
     * Constructs an instance of <code>CabeceraNoEncontradaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CabeceraNoEncontradaException(String msg) {
        super(msg);
    }
}
