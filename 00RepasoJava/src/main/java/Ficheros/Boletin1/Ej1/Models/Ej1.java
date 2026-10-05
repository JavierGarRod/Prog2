package Ficheros.Boletin1.Ej1.Models;

import java.io.File;
import java.util.Scanner;
import Ficheros.Boletin1.Ej1.Exception.RutaNoValidaException;

public class Ej1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la ruta del directorio (Sin comillas): ");
        String ruta = teclado.nextLine();

        try {
            File directorio = new File(ruta);

            if (!directorio.exists()) { // Comprobar si la ruta existe
                throw new RutaNoValidaException("La ruta no existe.");
            }
            else if (!directorio.isDirectory()) { // Comprobar si es un directorio
                throw new RutaNoValidaException("La ruta indicada no es un directorio.");
            }

            // Obtener los elementos del directorio
            File[] elementos = directorio.listFiles();

            
            if (elementos == null) { // listFiles() puede devolver null si no hay permisos
                throw new RutaNoValidaException("No se puede acceder al contenido del directorio. ");
            }

            
            int totalFicheros = 0;
            int totalDirectorios = 0;

            for (File elemento : elementos) { // Recorrer los elementos del directorio

                if (elemento.isFile()) {
                    System.out.println("[F] " + elemento.getName());
                    totalFicheros++;

                } else if (elemento.isDirectory()) {
                    System.out.println("[D] " + elemento.getName());
                    totalDirectorios++;
                }
            }

            System.out.println("Total de ficheros: " + totalFicheros);
            System.out.println("Total de directorios: " + totalDirectorios);

        } catch (RutaNoValidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

