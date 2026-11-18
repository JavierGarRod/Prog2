package TEMA2.Boletin3.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionaCalculaMaxHilo {

    public static void main(String[] args) {
        int tamTabla = 10000;
        int numHilos = 10;
        long inicioTiempo = System.currentTimeMillis();

        int[] tabla = construyeTablaNotas(tamTabla);
        List<Thread> hilos = new ArrayList<>();
        List<CalculaMaxHilo> objetos = new ArrayList<>();

        int rango = tamTabla / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * rango;
            int fin = (i == numHilos - 1) ? tamTabla : inicio + rango;

            CalculaMaxHilo tarea = new CalculaMaxHilo(tabla, inicio, fin);
            objetos.add(tarea);
            hilos.add(new Thread(tarea));
        }

        try {
            for (Thread hilo : hilos) hilo.start();
            for (Thread hilo : hilos) hilo.join();

            int maximoTotal = objetos.get(0).getMaximoTramo();
            for (CalculaMaxHilo tarea : objetos) {
                if (tarea.getMaximoTramo() > maximoTotal) {
                    maximoTotal = tarea.getMaximoTramo();
                }
            }
            System.out.println("Máximo global: " + maximoTotal);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ejecución interrumpida.");
        }

        long finTiempo = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (finTiempo - inicioTiempo) + " ms");
    }

    private static int[] construyeTablaNotas(int tamanyo) {
        int[] tabla = new int[tamanyo];
        Random random = new Random();
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = random.nextInt(500) + 1;
        }
        return tabla;
    }
}
