package ej8arrays;

/**
 *
 * @author Bruno
 */
public class Trabajador {

    private final String nombre;
    private int categoria;
    private float importeVentas;

    public Trabajador(String nombre, int categoria, float importeVentas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.importeVentas = importeVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public float getImporteVentas() {
        return importeVentas;
    }
}
