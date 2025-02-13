package carros;

import insumos.Insumo;
import java.util.Objects;

/**
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
    
    @Override
    public boolean equals(Object obj){
        Carro carro;
        if(!(obj instanceof Carro)) {
            return false;
        } else {
            carro = (Carro) obj;
            return (
                    this.codigo.equals(carro.getCodigo()));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
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
    public Motor getMotor() {
        return motor;
    }
    

}
