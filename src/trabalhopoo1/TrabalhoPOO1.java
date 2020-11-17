/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo1;

import carros.*;
import exception.NotEnoughResourcesException;
import insumos.Insumo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.Reader;

/**
 *
 * @author Daniel Tadeu Donateli
 */
public class TrabalhoPOO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Carro> carros = lerPedidos("./carros.txt");
        carros.forEach(carro -> {
            System.out.println(carro);
        });
        
        Insumo insumos = lerInsumos("insumos.txt");
        System.out.println("\n" + insumos);
        
        carros.forEach((carro) -> {
            try {
                insumos.consume(carro.getInsumos());
            } catch(NotEnoughResourcesException e) {
                System.out.println("Não possível construir o carro: " + carro.getCodigo());
            }
        });
        
        System.out.println("\n" + insumos);
        
        /*
        Respostas do Trabalho.
        System.out.println("1) Não implementado ainda");
        System.out.println("2) Não implementado ainda");
        System.out.println("3) Não implementado ainda");
        System.out.println("4) Não implementado ainda");
        System.out.println("5) Não implementado ainda");
        System.out.println("6) Não implementado ainda");
        System.out.println("7) Não implementado ainda");
         */               
    }
    
    private static Insumo lerInsumos(String fileName) {
        try {
            List<String> lines = Reader.readFile(fileName);           
            List<String> list = lines
                                .stream()
                                .map(x -> x.split("\\s+")[1])
                                .collect(Collectors.toList());
            
            int madeira = Integer.parseInt(list.get(0));
            int aco = Integer.parseInt(list.get(1));
            int ferro = Integer.parseInt(list.get(2));
            int aluminio = Integer.parseInt(list.get(3));
            int ouro = Integer.parseInt(list.get(4));
            int cobre = Integer.parseInt(list.get(5));
            int chumbo = Integer.parseInt(list.get(6));
            return new Insumo(madeira, aco, ferro, aluminio, ouro, cobre, chumbo);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Arquivo de insumos contém dados inválidos");
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static List<Carro> lerPedidos(String fileName) {
        List<String> pedidos = Reader.readFile(fileName);
        ArrayList<Carro> carros = new ArrayList();
        pedidos.forEach(pedido -> {
            carros.add(gerarCarro(pedido));
        });
        return carros.stream().filter(x -> x != null).collect(Collectors.toList());
    }
    
    private static Carro gerarCarro(String pedido) {
        String arr[] = pedido.split("\\s+");
        
        switch(arr[0]) {
            case "BR1.0":
                return new Brazuca(arr[1]);
            case "BRSedan":
                return new Bradan(arr[1]);
            case "BRSedanTurbo":
                return new BradanTurbo(arr[1]);
            case "TitaHatch":
                return new Netuno(arr[1]);
            case "TitaSedan":
                return new Gaia(arr[1]);
            case "Posseidon":
                return new Posseidon(arr[1]);
            case "Hades":
                return new Hades(arr[1]);
            case "Zeus":
                return new Zeus(arr[1]);
            default:
                return null;
        }
    }
}
