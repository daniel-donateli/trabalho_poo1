package exception;

import java.util.List;

/**
 * @author Daniel Tadeu Donateli
 */
public class NotEnoughResourcesException extends Exception{
    public final List<String> listaInsumosFaltando;
      
    public NotEnoughResourcesException(List<String> listaInsumos) {
        super();
        this.listaInsumosFaltando = listaInsumos;      
    }
}
