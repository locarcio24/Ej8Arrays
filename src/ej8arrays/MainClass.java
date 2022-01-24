package ej8arrays;

import numeros.Numero;

/**
 *
 * @author Bruno
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa();
        int nTrabajadores;
        nTrabajadores = Numero.pedirNumero("Introduce el numero de trabajadores-> ", 0);
        miEmpresa.pedirInfo(nTrabajadores);
        miEmpresa.printInfo();
    }
    
}
