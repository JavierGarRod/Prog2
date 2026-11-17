package TEMA2.Boletin2.Ej1;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1 - Protectora de animales con prioridades.
 *
 * 100 cuidadores (hilos) agrupados en 10 tramos de 10:
 *   cuidadores   1-10  -> prioridad 1  (Thread.MIN_PRIORITY)
 *   cuidadores  11-20  -> prioridad 2
 *   ...
 *   cuidadores  91-100 -> prioridad 10 (Thread.MAX_PRIORITY)
 * Los últimos cuidadores tienen más prioridad que los primeros.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
    	Cuidador ref=new Cuidador();
    	int num_cuidadores = 100;
        List<Thread> hilos = new ArrayList<>();

        for (int i = 1; i <= num_cuidadores; i++) {
            Thread hilo = new Thread(new Cuidador(i), "Cuidador-" + i);

            int prioridad = (i - 1) / 10 + 1; // 1..10 (MIN_PRIORITY..MAX_PRIORITY)
            hilo.setPriority(prioridad);

            hilos.add(hilo);
        }

        // Se lanzan todos una vez configuradas sus prioridades
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperamos a que terminen todos los cuidadores
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        int animalAtendido=Cuidador.animalesAtendidos;

        System.out.println("Animales atendidos en total: " + animalAtendido);
    }
}
