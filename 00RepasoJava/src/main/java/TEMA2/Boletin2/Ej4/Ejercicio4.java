package TEMA2.Boletin2.Ej4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import TEMA2.Boletin2.Ej3.Utilidades;

/**
 * Ejercicio 4 - Tercera versión: un proceso por fichero, y comparación de tiempos:
 *   (1) secuencial   (2) con hilos   (3) con procesos
 */
public class Ejercicio4 {
    public static void main(String[] args) throws Exception {
    	Ejercicio4 ref2=new Ejercicio4();
    	Utilidades ref=new Utilidades();
    	
    	String ruta=Utilidades.RUTA_DIRECTORIO;
    	
        List<File> ficheros = ref.listarFicheros(ruta);

        long t_comienzo, t_fin;

        // (1) Secuencial
        t_comienzo = System.currentTimeMillis();
        int totalSecuencial = ref2.contarSecuencial(ficheros);
        t_fin = System.currentTimeMillis();
        long tiempoSecuencial = t_fin - t_comienzo;

        // (2) Con hilos
        t_comienzo = System.currentTimeMillis();
        int totalHilos = ref2.contarConHilos(ficheros);
        t_fin = System.currentTimeMillis();
        long tiempoHilos = t_fin - t_comienzo;

        // (3) Con procesos
        t_comienzo = System.currentTimeMillis();
        int totalProcesos = ref2.contarConProcesos(ficheros);
        t_fin = System.currentTimeMillis();
        long tiempoProcesos = t_fin - t_comienzo;

        System.out.println("Ficheros contados: " + ficheros.size());
        System.out.println("(1) Secuencial: " + tiempoSecuencial + " mseg -> " + totalSecuencial + " caracteres");
        System.out.println("(2) Hilos:      " + tiempoHilos + " mseg -> " + totalHilos + " caracteres");
        System.out.println("(3) Procesos:   " + tiempoProcesos + " mseg -> " + totalProcesos + " caracteres");

        if (totalSecuencial == totalHilos && totalHilos == totalProcesos) {
            System.out.println("Los tres métodos dan el mismo resultado.");
        } else {
            System.out.println("¡Cuidado! Los resultados no coinciden.");
        }
    }

    // (1) Un fichero detrás de otro, en el hilo main
    public int contarSecuencial(List<File> ficheros) {
    	Utilidades ref=new Utilidades();
        int total = 0;
        for (File fichero : ficheros) {
            total += ref.contarCaracteres(fichero);
        }
        return total;
    }

    // (2) Un hilo por fichero
    public int contarConHilos(List<File> ficheros) {
        List<Thread> hilos = new ArrayList<>();
        List<ContadorCaracteresHilo> contadores = new ArrayList<>();

        for (File fichero : ficheros) {
            ContadorCaracteresHilo contador = new ContadorCaracteresHilo(fichero);
            contadores.add(contador);
            Thread hilo = new Thread(contador);
            hilos.add(hilo);
            hilo.start();
        }
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int total = 0;
        for (ContadorCaracteresHilo c : contadores) {
            total += c.getContador();
        }
        return total;
    }

    // (3) Un proceso (una JVM nueva) por fichero
    public int contarConProcesos(List<File> ficheros) throws IOException, InterruptedException {
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        // Se lanzan todos los procesos...
        List<Process> procesos = new ArrayList<>();
        for (File fichero : ficheros) {
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", classpath,
                    "ContadorCaracteresProceso", fichero.getPath());
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            procesos.add(pb.start());
        }

        // ...y después se recoge lo que ha escrito cada uno por su salida estándar
        int total = 0;
        for (Process proceso : procesos) {
            try (BufferedReader salida = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea = salida.readLine();
                total += Integer.parseInt(linea.trim());
            }
            proceso.waitFor();
        }
        return total;
    }
}
