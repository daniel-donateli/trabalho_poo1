package insumos;

import exception.NotEnoughResourcesException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Tadeu Donateli
 */
public class Insumo {
    private int madeira;
    private int aco;
    private int ferro;
    private int aluminio;
    private int ouro;
    private int cobre;
    private int chumbo;
    
    public Insumo(int madeira, int aco, int ferro, int aluminio, int ouro, 
            int cobre, int chumbo) {
        this.madeira = madeira;
        this.aco = aco;
        this.ferro = ferro;
        this.aluminio = aluminio;
        this.ouro = ouro;
        this.cobre = cobre;
        this.chumbo = chumbo;
    }
    
    /**
     * Consume insumos do objeto.
     * @param insumos insumos a serem consumidos.
     * @throws NotEnoughResourcesException Se não houver insumos suficientes.
     */
    public void consume(Insumo insumos) throws NotEnoughResourcesException {
        if(this.canConsume(insumos)) {
            this.setMadeira(this.getMadeira() - insumos.getMadeira());
            this.setAco(this.getAco() - insumos.getAco());
            this.setFerro(this.getFerro() - insumos.getFerro());
            this.setAluminio(this.getAluminio() - insumos.getAluminio());
            this.setOuro(this.getOuro() - insumos.getOuro());
            this.setCobre(this.getCobre() - insumos.getCobre());
            this.setChumbo(this.getChumbo() - insumos.getChumbo());
        } else {
            HashMap<String, Integer> estoqueInsumos = this.getAllFields();
            HashMap<String, Integer> carroInsumos = insumos.getAllFields();
            ArrayList<String> insumos_faltando = new ArrayList<>();
            
            for(Map.Entry<String, Integer> e : estoqueInsumos.entrySet()) {
                if(e.getValue() < carroInsumos.get(e.getKey())) {
                    insumos_faltando.add(e.getKey());
                }
            }
            throw new NotEnoughResourcesException(insumos_faltando);
        }
    }
    
    public boolean canConsume(Insumo insumos) {
        return (
            insumos.getMadeira() <= this.getMadeira() &&
            insumos.getAco() <= this.getAco() &&
            insumos.getFerro() <= this.getFerro() &&
            insumos.getAluminio() <= this.getAluminio() &&
            insumos.getOuro() <= this.getOuro() &&
            insumos.getCobre() <= this.getCobre() &&
            insumos.getChumbo() <= this.getChumbo()
        );
    }
    
    public HashMap<String, Integer> getAllFields() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Madeira", this.getMadeira());
        map.put("Aço", this.getAco());
        map.put("Ferro", this.getFerro());
        map.put("Alumínio", this.getAluminio());
        map.put("Ouro", this.getOuro());
        map.put("Cobre", this.getCobre());
        map.put("Chumbo", this.getChumbo());
        
        return map;
    }
    
    @Override
    public String toString() {
        return 
            "Madeira: " + this.getMadeira() + "\n" +
            "Aço: " + this.getAco() + "\n" +
            "Ferro: " + this.getFerro() + "\n" +
            "Alumínio: " + this.getAluminio() + "\n" +
            "Ouro: " + this.getOuro() + "\n" +
            "Cobre: " + this.getCobre() + "\n" +
            "Chumbo: " + this.getChumbo() + "\n";
    }
    
    // Getters e Setters
    
    /**
     * @return the madeira
     */
    public int getMadeira() {
        return madeira;
    }

    /**
     * @param madeira the madeira to set
     */
    private void setMadeira(int madeira) {
        this.madeira = madeira;
    }

    /**
     * @return the aco
     */
    public int getAco() {
        return aco;
    }

    /**
     * @param aco the aco to set
     */
    private void setAco(int aco) {
        this.aco = aco;
    }

    /**
     * @return the ferro
     */
    public int getFerro() {
        return ferro;
    }

    /**
     * @param ferro the ferro to set
     */
    private void setFerro(int ferro) {
        this.ferro = ferro;
    }

    /**
     * @return the aluminio
     */
    public int getAluminio() {
        return aluminio;
    }

    /**
     * @param aluminio the aluminio to set
     */
    private void setAluminio(int aluminio) {
        this.aluminio = aluminio;
    }

    /**
     * @return the ouro
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * @param ouro the ouro to set
     */
    private void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * @return the cobre
     */
    public int getCobre() {
        return cobre;
    }

    /**
     * @param cobre the cobre to set
     */
    private void setCobre(int cobre) {
        this.cobre = cobre;
    }

    /**
     * @return the chumbo
     */
    public int getChumbo() {
        return chumbo;
    }

    /**
     * @param chumbo the chumbo to set
     */
    private void setChumbo(int chumbo) {
        this.chumbo = chumbo;
    }
}
