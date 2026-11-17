package TEMA2.Boletin2.Ej2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import TEMA2.Boletin2.Ej3.Utilidades;

/**
 * Ejercicio 2 - Contar los caracteres de todos los ficheros de "resources" en paralelo.
 *
 * Primera versión: un número fijo de hilos trabajadores (NUM_HILOS) que van cogiendo
 * ficheros de una cola compartida hasta que no queda ninguno. El total se acumula
 * en un AtomicInteger para que los hilos no se pisen al sumar.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
    	Utilidades ref=new Utilidades();
    	Trabajador ref2=new Trabajador();
    	
    	int num_Hilos=3;
        String ruta=Utilidades.RUTA_DIRECTORIO;

        // Recorremos la carpeta y metemos los ficheros en una cola compartida
        ConcurrentLinkedQueue<File> pendientes = new ConcurrentLinkedQueue<>(ref.listarFicheros(ruta));
        int caracterTotales = 0;

        // Todos los hilos ejecutan la misma tarea y comparten la cola y el total
        Trabajador trabajo = new Trabajador(pendientes, caracterTotales);

        List<Thread> hilos = new ArrayList<>();
        try {
			try {
				for (int i = 1; i <= num_Hilos; i++) {
				    Thread hilo = new Thread(trabajo, "Hilo-" + i);
				    hilos.add(hilo);
				    hilo.start();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Esperamos a que acaben todos antes de mostrar el total
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        caracterTotales=Trabajador.caracteresTotales;

        System.out.println("Caracteres totales de todos los ficheros: " + caracterTotales);
    }
}
