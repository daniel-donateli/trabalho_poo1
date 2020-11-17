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
public class Gaia extends Carro{
    public static Insumo insumos = new Insumo(0, 300, 250, 250, 5, 0, 50);
    
    public Gaia(String cor) {
        super("TitaSedan", "Gaia", cor, CarroType.SEDAN, true, 1500, 170);
    }

    @Override
    public Insumo getInsumos() {
        return Gaia.insumos;
    }
    
}
