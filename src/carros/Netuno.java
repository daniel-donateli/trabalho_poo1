/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carros;

import insumos.Insumo;

/**
 *
 * @author Daniel Tadeu Donateli
 */
public class Netuno extends Carro{
    public static Insumo insumos = new Insumo(0, 200, 200, 200, 0, 100, 20);
    
    public Netuno(String cor) {
        super("TitaHatch", "Netuno", cor, CarroType.COMPACTO, true, 1400, 160);
    }

    @Override
    public Insumo getInsumos() {
        return Netuno.insumos;
    }
    
}
