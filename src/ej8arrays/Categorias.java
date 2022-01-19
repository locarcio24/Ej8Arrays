package ej8arrays;

/**
 *
 * @author Bruno
 */
public class Categorias {
    private final String denominacion;
    private final int sueldoBase;

    public Categorias(String denominacion, int sueldoBase) {
        this.denominacion = denominacion;
        this.sueldoBase = sueldoBase;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }
    
}
