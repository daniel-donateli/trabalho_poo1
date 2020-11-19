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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
        /*carros.forEach(carro -> {
            System.out.println(carro);
        });*/
        
        Insumo insumos = lerInsumos("insumos.txt");
        //System.out.println("\n" + insumos);
        
        Carro falha = produzir(insumos, carros);
        int num_dias = 0;
        do{
            num_dias++;
            falha = produzir(insumos, carros);
        } while(falha == null);
        
        //System.out.println("Produção falhou no carro " + falha.getCodigo() + " de cor " + falha.getCor());
        //System.out.println("Produção durou " + num_dias + " dias");
        
        int num_turbo = numCarrosTurbo(carros);
        
        //Respostas do Trabalho.
        System.out.println("1) " + nomeCarrosRepetidos(carros));
        System.out.println("2) " + numCarrosMenorQue100Cavalos(carros));
        System.out.println("3) Não turbo: " + (carros.size() - num_turbo) + " Turbo: " + num_turbo);
        System.out.println("4) " + mediaCilindrada(carros) + " cilindradas");
        System.out.println("5) Compacto: " + qtdCompacto(carros) + ", Sedan: " + qtdSedan(carros) + " e SUV: " + qtdSUV(carros));
        System.out.println("6) O estoque suportou " + num_dias + " dias");
        System.out.println("7) " + falha.getCodigo() + " - " + falha.getCor() + " - " + getInsumosFaltando(insumos, falha));
                      
    }
    
    private static String nomeCarrosRepetidos(List<Carro> carros) {
        List<Carro> repetidos = carros.stream()
            .filter(e -> Collections.frequency(carros, e) > 1)
            .distinct()
            .collect(Collectors.toList());
        
        //System.out.println(repetidos);
        
        if(repetidos.isEmpty()) return "Nenhum foi pedido mais de uma vez.";
        
        Iterator<Carro> itr = repetidos.iterator();
        String resultado = itr.next().getNome();
        while(itr.hasNext()) {
            resultado += ", " + itr.next().getNome();
        }
        
        resultado += ".";
        
        return resultado;
    }
    
    private static String getInsumosFaltando(Insumo insumos, Carro carro) {
        HashMap<String, Integer> estoqueInsumos = insumos.getAllFields();
        HashMap<String, Integer> carroInsumos = carro.getInsumos().getAllFields();
        ArrayList<String> insumos_faltando = new ArrayList<>();
            
        for(Map.Entry<String, Integer> e : estoqueInsumos.entrySet()) {
            if(e.getValue() < carroInsumos.get(e.getKey())) {
                insumos_faltando.add(e.getKey());
            }
       }
       //System.out.println(insumos_faltando);
       
       if(insumos_faltando.size() == 1) {
           return insumos_faltando.get(0);
       }
       
       Iterator itr = insumos_faltando.iterator();
       String resultado = (String) itr.next();
       while(itr.hasNext()) {
           resultado += ", " + (String) itr.next();
       }
       resultado += ".";
       
       return resultado;
    }
    
    private static int qtdSUV(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.SUV) qtd++;
        }
        return qtd;
    }
    
    private static int qtdCompacto(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.COMPACTO) qtd++;
        }
        return qtd;
    }
    
    private static int qtdSedan(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.SEDAN) qtd++;
        }
        return qtd;
    }
    
    private static double mediaCilindrada(List<Carro> carros) {
        int soma = 0;
        for(Carro carro : carros) {
            soma += carro.getMotor().getCilindrada();
        }
        return (soma / carros.size());
    }
    
    private static int numCarrosTurbo(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getMotor().isTurbo()) qtd++;
        }
        return qtd;
    }
    
    private static int numCarrosMenorQue100Cavalos(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getMotor().getCavalos() < 100) qtd++;
        }
        return qtd;
    }
    
    private static Carro produzir(Insumo insumos, List<Carro> carros) {
        Carro erro = null;
        try{
            for(Carro carro : carros) {
                erro = carro;
                //System.out.println(insumos);
                insumos.consume(carro.getInsumos());
            }
            erro = null;
        } catch(NotEnoughResourcesException e) {
        }
        
        
        return erro;
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
