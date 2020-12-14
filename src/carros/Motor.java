package carros;

/**
 * @author Daniel Tadeu Donateli
 */
public class Motor {
    private final boolean turbo;
    private final int cilindrada;
    private final int cavalos;
    
    Motor(boolean turbo, int cilindrada, int cavalos) {
        this.turbo = turbo;
        this.cilindrada = cilindrada;
        this.cavalos = cavalos;
    }
    
    @Override
    public String toString() {
        String str = this.isTurbo() ? "S" : "N";
        return "Turbo: " + str + "  Cilindrada: " + this.getCilindrada() + 
        "  Quantidade de Cavalos: " + this.getCavalos();
}

    /**
     * @return the turbo
     */
    public boolean isTurbo() {
        return turbo;
    }

    /**
     * @return the cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * @return the cavalos
     */
    public int getCavalos() {
        return cavalos;
    }
}