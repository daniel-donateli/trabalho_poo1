/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.util.List;

/**
 *
 * @author Daniel Tadeu Donateli
 */
public class NotEnoughResourcesException extends Exception{
    public final List<String> listaInsumosFaltando;
      
    public NotEnoughResourcesException(List<String> listaInsumos) {
        super();
        this.listaInsumosFaltando = listaInsumos;      
    }
}
