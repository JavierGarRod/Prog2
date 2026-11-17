package TEMA2.Boletin2.Ej3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import TEMA2.Boletin2.Ej4.ContadorCaracteresHilo;

public class Ejercicio3 {
    public static void main(String[] args) {
    	Utilidades ref=new Utilidades();
        String ruta = Utilidades.RUTA_DIRECTORIO;

        List<File> ficheros = ref.listarFicheros(ruta);
        List<Thread> hilos = new ArrayList<Thread>();
        List<ContadorCaracteresHilo> contadores = new ArrayList<ContadorCaracteresHilo>();
        long t_comienzo = 0;
        long t_fin = 0;
        int caracteresTotales = 0;

        t_comienzo = System.currentTimeMillis();

        for (File archivo : ficheros) {
            // Crear y ejecutar un hilo para cada archivo
            ContadorCaracteresHilo contador = new ContadorCaracteresHilo(archivo);
            contadores.add(contador);
            Thread hilo = new Thread(contador);
            hilos.add(hilo);
            hilo.start();
        }

        // Todos mis hilos están creados y runnable: esperamos a que terminen
        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t_fin = System.currentTimeMillis();
        long tiempototal = t_fin - t_comienzo;
        System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");

        for (ContadorCaracteresHilo c : contadores) {
            System.out.println(c.getNombreFichero() + ": " + c.getContador() + " caracteres");
            caracteresTotales = caracteresTotales + c.getContador();
        }
        
        System.out.println("Caracteres totales: " + caracteresTotales);
    }
}
