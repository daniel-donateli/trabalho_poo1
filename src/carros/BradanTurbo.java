package carros;

import insumos.Insumo;

/**
 * @author Daniel Tadeu Donateli
 */
public class BradanTurbo extends Carro{
    public static Insumo insumos = new Insumo(20, 60, 300, 100, 10, 50, 50);
    
    public BradanTurbo(String cor) {
        super("BRSedanTurbo", "BradanTurbo", cor, CarroType.SEDAN, true, 1000, 
              125);
    }

    @Override
    public Insumo getInsumos() {
        return BradanTurbo.insumos;
    }
    
}
