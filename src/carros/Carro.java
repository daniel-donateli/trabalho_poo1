package carros;

import insumos.Insumo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Daniel Tadeu Donateli
 */
public abstract class Carro {
    private final String codigo;
    private final String nome;
    private final String cor;
    private final CarroType tipo;
    private final Motor motor;
    
    Carro(String codigo, String nome, String cor, CarroType tipo, boolean turbo
         , int cilindrada, int cavalos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cor = cor;
        this.tipo = tipo;
        this.motor = new Motor(turbo, cilindrada, cavalos);
    }
    
    @Override
    public String toString() {
        return 
        "Código: " + this.getCodigo() + "  Nome: " + this.getNome() + "  Cor: " 
        + this.getCor() + "  Tipo: " + this.getTipo() + "  "+ this.getMotor();
    }

    public abstract Insumo getInsumos();
    
    /**
     * @return o código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return a cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @return o tipo
     */
    public CarroType getTipo() {
        return tipo;
    }

    /**
     * @return o motor
     */
    public String getMotor() {
        return motor.toString();
    }
    
    
}
