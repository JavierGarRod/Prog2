package TEMA2.Boletin2.Ej2;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import TEMA2.Boletin2.Ej3.Utilidades;

public class Trabajador implements Runnable{
	Utilidades ref=new Utilidades();
	
    private ConcurrentLinkedQueue<File> pendientes;
    static int caracteresTotales;

    Trabajador(ConcurrentLinkedQueue<File> pendientes, int caracteresTotales) {
        this.pendientes = pendientes;
        this.caracteresTotales = caracteresTotales;
    }

	public Trabajador() {
		super();
	}
	

	@Override
    public void run() {
        File fichero;
        // poll() devuelve null cuando la cola está vacía
        while ((fichero = pendientes.poll()) != null) {
            int caracteres = ref.contarCaracteres(fichero);
            caracteresTotales=caracteresTotales+caracteres;
            System.out.println(Thread.currentThread().getName() + " -> "
                    + fichero.getName() + ": " + caracteres + " caracteres");
        }
    }
}
