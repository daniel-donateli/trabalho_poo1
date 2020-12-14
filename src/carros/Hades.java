package carros;

import insumos.Insumo;

/**
 * @author Daniel Tadeu Donateli
 */
public class Hades extends Carro{
    public static Insumo insumos = new Insumo(100, 200, 400, 400, 100, 50, 50);
    
    public Hades(String cor) {
        super("Hades", "Hades", cor, CarroType.SUV, true, 2000, 200);
    }

    @Override
    public Insumo getInsumos() {
        return Hades.insumos;
    }
    
}
