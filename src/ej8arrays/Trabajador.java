package ej8arrays;

/**
 *
 * @author Bruno
 */
public class Trabajador {

    private final String nombre;
    private final int categoria, importeVentas;

    public Trabajador(String nombre, int categoria, int importeVentas) {
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

    public int getImporteVentas() {
        return importeVentas;
    }

}
