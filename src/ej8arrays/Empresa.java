package ej8arrays;

import numeros.Numero;
import textos.Texto;

/**
 *
 * @author Bruno
 */
public class Empresa {

    Trabajador[] trabajadores;
    

    public Empresa() {
        
    }

    public void pedirInfo() {
        String nombreTrabj;
        int nTrabajadores, categoriaTrabj, ventasTrabj;
        nTrabajadores = Numero.pedirNumero("Introduce el numero de trabajadores-> ", 0);
        trabajadores = new Trabajador[nTrabajadores];
        for (int i = 0; i < trabajadores.length; i++) {
            nombreTrabj = Texto.pedirString("Nombre del trabajador-> ");
            System.out.println("0.- Administrativo\n1.- Operador\n2.- Programador\n3.- Analista");
            categoriaTrabj = Numero.pedirNumero("Introduce la categoria [0-3]-> ", 0, 3);
            ventasTrabj = Numero.pedirNumero("Introduce el importe de ventas-> ", 0);
            trabajadores[i] = new Trabajador(nombreTrabj, categoriaTrabj, ventasTrabj);
        }
    }
}
