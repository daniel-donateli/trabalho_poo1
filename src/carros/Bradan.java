package carros;

import insumos.Insumo;

/**
 * @author Daniel Tadeu Donateli
 */
public class Bradan extends Carro{
    public static Insumo insumos = new Insumo(0, 0, 400, 60, 0, 60, 50);
    
    public Bradan(String cor) {
        super("BRSedan", "Bradan", cor, CarroType.SEDAN, false, 1000, 65);
    }

    @Override
    public Insumo getInsumos() {
        return Bradan.insumos;
    }
    
}
