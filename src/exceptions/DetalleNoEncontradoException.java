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
public class DetalleNoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>DetalleNoEncontradoException</code>
     * without detail message.
     */
    public DetalleNoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>DetalleNoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DetalleNoEncontradoException(String msg) {
        super(msg);
    }
}
