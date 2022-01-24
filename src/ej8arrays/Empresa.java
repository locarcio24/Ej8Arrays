package ej8arrays;

import numeros.Numero;
import textos.Texto;

/**
 *
 * @author Bruno
 */
public class Empresa {

    Trabajador[] trabajadores;
    Categorias[] categorias;
    Comision[] comisiones;

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

    public void pedirInfo(int nTrabajadores) {
        String nombreTrabj;
        int categoriaTrabj, ventasTrabj;
        trabajadores = new Trabajador[nTrabajadores];
        for (int nTra = 0; nTra < trabajadores.length; nTra++) {
            nombreTrabj = Texto.pedirString("Nombre del trabajador-> ");
            System.out.println("0.- Administrativo\n1.- Operador\n2.- Programador\n3.- Analista");
            categoriaTrabj = Numero.pedirNumero("Introduce la categoria [0-3]-> ", 0, 3);
            ventasTrabj = Numero.pedirNumero("Introduce el importe de ventas-> ", 0);
            trabajadores[nTra] = new Trabajador(nombreTrabj, categoriaTrabj, ventasTrabj);
        }
    }

    private float calcularComision(int importeVentas) {
        float prcntComision, comision;
        if (importeVentas <= comisiones[0].getImporte()) {
            prcntComision = comisiones[0].getComision();
        } else if (importeVentas <= comisiones[1].getImporte()) {
            prcntComision = comisiones[1].getComision();
        } else if (importeVentas <= comisiones[2].getImporte()) {
            prcntComision = comisiones[2].getComision();
        } else if (importeVentas <= comisiones[3].getImporte()) {
            prcntComision = comisiones[3].getComision();
        } else {
            prcntComision = comisiones[4].getComision();
        }
        comision = importeVentas * prcntComision;
        return comision;
    }

    private float caclularPercibir(float importeComision, int categoria) {
        float importePercibir;
        int sueldoBase;
        sueldoBase = categorias[categoria].getSueldoBase();
        importePercibir = sueldoBase + importeComision;
        return importePercibir;
    }

    public void printInfo() {
        System.out.println("\n\nINFORME DE TRABAJADORES\n-----------------------\nNOMBRE CATEGORIA\t\tIMPORTE VENTAS\t\tIMPORTE COMISION\t\tIMPORTE A PERCIBIR");
        for (Trabajador trabajador : trabajadores) {
            String nombreCategoria;
            int importeVentas;
            float importeComision, importePercibir;
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
