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
public class NoInsertadoException extends Exception {

    /**
     * Creates a new instance of <code>NoInsertadoException</code> without
     * detail message.
     */
    public NoInsertadoException() {
    }

    /**
     * Constructs an instance of <code>NoInsertadoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoInsertadoException(String msg) {
        super(msg);
    }
}
