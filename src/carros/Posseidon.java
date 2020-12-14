package carros;

import insumos.Insumo;

/**
 * @author Daniel Tadeu Donateli
 */
public class Posseidon extends Carro{
    public static Insumo insumos = new Insumo(50, 100, 500, 200, 50, 50, 0);
    
    public Posseidon(String cor) {
        super("Posseidon", "Posseidon", cor, CarroType.SUV, false, 2000, 180);
    }

    @Override
    public Insumo getInsumos() {
        return Posseidon.insumos;
    }
    
}
