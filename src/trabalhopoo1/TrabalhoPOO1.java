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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import util.Reader;

/**
 *
 * @author Daniel Tadeu Donateli
 */
public class TrabalhoPOO1 {
    public static List<String> listaInsumosFaltando;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Carro> carros = lerPedidos("./carros.txt");
        
        Insumo insumos = lerInsumos("insumos.txt");
        
        Carro falha = produzir(insumos, carros);
        int num_dias = 0;
        do{
            num_dias++;
            falha = produzir(insumos, carros);
        } while(falha == null);
        
        int num_turbo = qtdCarrosTurbo(carros);
        
        //Respostas do Trabalho.
        System.out.println("1) " + nomeCarrosRepetidos(carros));
        System.out.println("2) " + qtdCarrosMenorQue100Cavalos(carros));
        System.out.println("3) Não turbo: " + (carros.size() - num_turbo) + " Turbo: " + num_turbo);
        System.out.println("4) " + mediaCilindrada(carros) + " cilindradas");
        System.out.println("5) Compacto: " + qtdCompacto(carros) + ", Sedan: " + qtdSedan(carros) + " e SUV: " + qtdSUV(carros));
        System.out.println("6) O estoque suportou " + num_dias + " dias");
        System.out.println("7) " + falha.getCodigo() + " - " + falha.getCor() + " - " + getInsumosFaltando(listaInsumosFaltando));
                      
    }
    
    /**
     * Retorna uma String formatada contendo os carros repetidos numa lista de 
     * objetos Carro.
     * 
     * @param carros lista de carros.
     */
    private static String nomeCarrosRepetidos(List<Carro> carros) {
        List<Carro> repetidos = carros.stream()
            .filter(e -> Collections.frequency(carros, e) > 1)
            .distinct()
            .collect(Collectors.toList());
        
        if(repetidos.isEmpty()) return "Nenhum foi pedido mais de uma vez.";
        
        Iterator<Carro> itr = repetidos.iterator();
        String resultado = itr.next().getNome();
        while(itr.hasNext()) {
            resultado += ", " + itr.next().getNome();
        }
        
        resultado += ".";
        
        return resultado;
    }
    
    /**
     * Retorna uma String formatada de uma lista de insumos.
     * 
     * @param insumos_faltando lista de Strings com os nomes dos insumos.
     */
    private static String getInsumosFaltando(List<String> insumos_faltando) {
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
    
    /**
     * Retorna a quantidade de Carro do tipo SUV em uma lista de Carro.
     * @param carros lista de carros.
     */
    private static int qtdSUV(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.SUV) qtd++;
        }
        return qtd;
    }
    
    /**
     * Retorna a quantidade de Carro do tipo Compacto em uma lista de Carro.
     * @param carros lista de carros.
     */
    private static int qtdCompacto(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.COMPACTO) qtd++;
        }
        return qtd;
    }
    
    /**
     * Retorna a quantidade de Carro do tipo Sedan em uma lista de Carro.
     * @param carros lista de carros.
     */
    private static int qtdSedan(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getTipo() == CarroType.SEDAN) qtd++;
        }
        return qtd;
    }
    
    /**
     * Retorna a média de cilindradas em uma lista de Carro.
     * @param carros lista de carros.
     */
    private static double mediaCilindrada(List<Carro> carros) {
        int soma = 0;
        for(Carro carro : carros) {
            soma += carro.getMotor().getCilindrada();
        }
        return (soma / carros.size());
    }
    
    /**
     * Retorna a quantidade de carros turbo em uma lista de Carro.
     * @param carros lista de carros.
     */
    private static int qtdCarrosTurbo(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getMotor().isTurbo()) qtd++;
        }
        return qtd;
    }
    
    /**
     * Retorna a quantidade de carros com menos que 100 cavalos de potência em 
     * uma lista de Carro.
     * @param carros lista de carros.
     */
    private static int qtdCarrosMenorQue100Cavalos(List<Carro> carros) {
        int qtd = 0;
        for(Carro carro : carros) {
            if(carro.getMotor().getCavalos() < 100) qtd++;
        }
        return qtd;
    }
    
    /**
     * Este método tenta produzir uma lista de Carro.
     * <p>
     * Se os insumos não forem suficientes para produzir a lista, altera o 
     * valor da variável estática listaInsumosFaltando e retorna o carro em
     * que faltaram os insumos. Caso contrário, retorna null.
     * </p>
     */
    private static Carro produzir(Insumo insumos, List<Carro> carros) {
        Carro erro = null;
        try{
            for(Carro carro : carros) {
                erro = carro;
                insumos.consume(carro.getInsumos());
            }
            erro = null;
        } catch(NotEnoughResourcesException e) {
            listaInsumosFaltando = e.listaInsumosFaltando;
        }
        
        
        return erro;
    }
    
    /**
     * Lê o arquivo de insumos e retorna o estoque de insumos ou retorna null 
     * caso ocorra algum erro.
     * @param filePath caminho para o arquivo de insumos.
     */
    private static Insumo lerInsumos(String filePath) {
        try {
            List<String> lines = Reader.readFile(filePath);           
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
            System.exit(1);
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    /**
     * Lê o arquivo de carros e retorna uma lista de Carro.
     * @param filePath caminho para o arquivo de carros.
     */
    private static List<Carro> lerPedidos(String filePath) {
        List<String> pedidos = Reader.readFile(filePath);
        ArrayList<Carro> carros = new ArrayList();
        pedidos.forEach(pedido -> {
            carros.add(gerarCarro(pedido));
        });
        return carros
               .stream()
               .filter(x -> x != null)
               .collect(Collectors.toList());
    }
    
    /**
     * Retorna um Carro a partir de uma string com o código e cor do carro.
     * @param pedido String quem contém o código e cor do carro.
     */
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
