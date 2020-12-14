package carros;

import insumos.Insumo;

/**
 * @author Daniel Tadeu Donateli
 */
public class Zeus extends Carro{
    public static Insumo insumos = new Insumo(300, 800, 0, 600, 200, 0, 0);
    
    public Zeus(String cor) {
        super("Zeus", "Zeus", cor, CarroType.SUV, true, 2500, 280);
    }

    @Override
    public Insumo getInsumos() {
        return Zeus.insumos;
    }

}
