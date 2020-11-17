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
public class Brazuca extends Carro {
    public static Insumo insumos = new Insumo(0, 0, 300, 50, 0, 50, 50);
    
    public Brazuca(String cor) {
        super("BR1.0", "Brazuca", cor, CarroType.COMPACTO, false, 1000, 65);
    }

    @Override
    public Insumo getInsumos() {
        return Brazuca.insumos;
    }
    
}
