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
public class ZapatoNoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>ZapatoNoEncontradoException</code>
     * without detail message.
     */
    public ZapatoNoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>ZapatoNoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ZapatoNoEncontradoException(String msg) {
        super(msg);
    }
}
