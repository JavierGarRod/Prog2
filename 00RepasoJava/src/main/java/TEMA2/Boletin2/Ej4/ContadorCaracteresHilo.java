package TEMA2.Boletin2.Ej4;

import java.io.File;

import TEMA2.Boletin2.Ej3.Utilidades;

/**
 * Cuenta los caracteres de UN fichero. Se ejecuta dentro de un Thread
 * y el resultado se recupera con getContador() cuando el hilo ha terminado (join).
 */
public class ContadorCaracteresHilo implements Runnable {
	Utilidades ref=new Utilidades();
    private final File fichero;
    private int contador = 0;

    public ContadorCaracteresHilo(String ruta) {
        this.fichero = new File(ruta);
    }

    public ContadorCaracteresHilo(File fichero) {
        this.fichero = fichero;
    }

    @Override
    public void run() {
        contador = ref.contarCaracteres(fichero);
    }

    public int getContador() {
        return contador;
    }

    public String getNombreFichero() {
        return fichero.getName();
    }
}
