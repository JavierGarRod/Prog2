package TEMA2.Boletin4.Ej2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Ej2 {

    private static int contador = 0;

    // Método sincronizado que comprueba si la palabra aparece en el fichero
    public synchronized boolean buscaPalabra(File archivo, String palabra) {
        /*
    	try {
            String contenido = Files.readString(archivo.toPath());
            return contenido.toLowerCase().contains(palabra.toLowerCase());
        } catch (IOException e) {
            System.out.println("Error leyendo " + archivo.getName() + ": " + e.getMessage());
            return false;
        }
        */
    	return false;
    }

    public static void main(String[] args) {
    	Ej2 ref=new Ej2();
        String directorio = "C:/Textos"; // Cambia esta ruta por la de tu carpeta
        String palabra = "Java";

        File carpeta = new File(directorio);
        File[] archivos = carpeta.listFiles();

        if (archivos == null) {
            System.out.println("No se encuentra el directorio: " + directorio);
            return;
        }

        Thread hilo = new Thread(() -> {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {
                    System.out.println("Buscando en: " + archivo.getName());

                    if (ref.buscaPalabra(archivo, palabra)) {
                        synchronized (Ej2.class) {
                            contador++;
                        }
                        System.out.println("La palabra aparece en " + archivo.getName());
                    }
                }
            }

            System.out.println("La palabra '" + palabra + "' aparece en "
                    + contador + " ficheros.");
        }, "Buscador");

        hilo.start();
    }
}
