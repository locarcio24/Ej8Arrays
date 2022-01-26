package ej8arrays;

import numeros.Numero;
import textos.Texto;

/**
 *
 * @author Bruno
 */
public class Empresa {

    private Trabajador[] trabajadores;
    private final Categorias[] categorias;
    private final Comision[] comisiones;

    /**
     * Inicia las tablas categorias y comisiones para depues poder acceder a los
     * datos
     */
    public Empresa() {
        // Tabla de los tipos de categorias de un trabajador
        categorias = new Categorias[4];
        categorias[0] = new Categorias("Administrativo", 1000);
        categorias[1] = new Categorias("Operador", 1100);
        categorias[2] = new Categorias("Programador", 1500);
        categorias[3] = new Categorias("Analista", 2000);
        // Tabla de la comision dependiendo del importe de ventas
        comisiones = new Comision[5];
        comisiones[0] = new Comision(10000, 0.05f);
        comisiones[1] = new Comision(15000, 0.10f);
        comisiones[2] = new Comision(20000, 0.15f);
        comisiones[3] = new Comision(25000, 0.20f);
        comisiones[4] = new Comision(Float.MAX_VALUE, 0.25f);
    }

    /**
     * Este metodo pide la informacion que se necesita para poder realizar el
     * ejercicio
     *
     * @param nTrabajadores El numero de trabajadores en la empresa
     */
    public void pedirInfo(int nTrabajadores) {
        String nombreTrabj;
        int categoriaTrabj, ventasTrabj;
        trabajadores = new Trabajador[nTrabajadores];
        for (int numTra = 0; numTra < trabajadores.length; numTra++) {
            nombreTrabj = Texto.pedirString("Nombre del trabajador-> ");
            for (int pos = 0; pos < categorias.length; pos++) {
                System.out.println(pos + 1 + ".- " + categorias[pos].getDenominacion());
            }
            categoriaTrabj = Numero.pedirNumero("Introduce la categoria [1-" + categorias.length + "]-> ", 0, categorias.length) - 1;
            ventasTrabj = Numero.pedirNumero("Introduce el importe de ventas-> ", 0);
            trabajadores[numTra] = new Trabajador(nombreTrabj, categoriaTrabj, ventasTrabj);
        }
    }

    /**
     * Este metodo calcula el importe comision sabiendo el importe de ventas y
     * el porcentaje de comsion
     *
     * @param importeVentas El importe de ventas del trabajador
     * @return Devuelve el importe comision
     */
    private float calcularComision(float importeVentas) {
        float comision, prcntComision = 0;
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado) {
            if (importeVentas <= comisiones[pos].getImporte()) {
                prcntComision = comisiones[pos].getComision();
                encontrado = true;
            }
            pos++;
        }
        comision = importeVentas * prcntComision;
        return comision;
    }

    /**
     * Calcula el importe a percibir sabiendo el importe comision y la categoria
     * del trabajador
     *
     * @param importeComision El importe comsion calculado en el metodo
     * <strong>calcularComision()</strong>
     * @param categoria La categoria del trabajador
     * @return Devuelve el importe a percibir
     */
    private float caclularPercibir(float importeComision, int categoria) {
        float importePercibir;
        int sueldoBase;
        sueldoBase = categorias[categoria].getSueldoBase();
        importePercibir = sueldoBase + importeComision;
        return importePercibir;
    }

    /**
     * Llama a todos los metodos para hacer los calculos e imprime por pantalla
     * el resultado obtenido
     */
    public void printInfo() {
        System.out.println("\n\nINFORME DE TRABAJADORES\n-----------------------\nNOMBRE CATEGORIA\t\tIMPORTE VENTAS\t\tIMPORTE COMISION\t\tIMPORTE A PERCIBIR");
        for (Trabajador trabajador : trabajadores) {
            String nombreCategoria;
            float importeComision, importePercibir, importeVentas;
            nombreCategoria = categorias[trabajador.getCategoria()].getDenominacion();
            importeVentas = trabajador.getImporteVentas();
            importeComision = calcularComision(trabajador.getImporteVentas());
            importePercibir = caclularPercibir(importeComision, trabajador.getCategoria());
            System.out.print(nombreCategoria + "\t\t\t" + importeVentas + "€\t\t\t");
            System.out.printf("%.2f€", importeComision);
            System.out.println("\t\t\t\t" + importePercibir + "€");
        }
    }
}
