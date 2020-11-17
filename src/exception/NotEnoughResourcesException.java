/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Daniel Tadeu Donateli
 */
public class NotEnoughResourcesException extends Exception{
    public NotEnoughResourcesException() { 
       super(); 
    }
    public NotEnoughResourcesException(String msg) {
       super(msg);
    }
    public NotEnoughResourcesException(Throwable cause) {
       super(cause);
    }
    public NotEnoughResourcesException(String msg, Throwable cause) {
       super(msg, cause);
    }
}
