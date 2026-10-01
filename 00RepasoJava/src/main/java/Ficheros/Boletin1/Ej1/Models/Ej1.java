package Ficheros.Boletin1.Ej1.Models;

import java.io.File;
import java.util.Scanner;
import Ficheros.Boletin1.Ej1.Exception.RutaNoValidaException;

public class Ej1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la ruta del directorio: ");
        String ruta = teclado.nextLine();

        try {
            File directorio = new File(ruta);

            // Comprobar si la ruta existe
            if (!directorio.exists() || !directorio.isDirectory()) {
                throw new RutaNoValidaException("La ruta no existe.");
            }

            // Comprobar si es un directorio
            if (!directorio.isDirectory()) {
                throw new RutaNoValidaException("La ruta indicada no es un directorio.");
            }

            // Obtener los elementos del directorio
            File[] elementos = directorio.listFiles();

            // listFiles() puede devolver null si no hay permisos
            if (elementos == null) {
                throw new RutaNoValidaException("No se puede acceder al contenido del directorio. ");
            }

            int totalFicheros = 0;
            int totalDirectorios = 0;

            // Recorrer los elementos del directorio
            for (File elemento : elementos) {

                if (elemento.isFile()) {
                    System.out.println("[F] " + elemento.getName());
                    totalFicheros++;

                } else if (elemento.isDirectory()) {
                    System.out.println("[D] " + elemento.getName());
                    totalDirectorios++;
                }
            }

            // Mostrar totales
            System.out.println("Total de ficheros: " + totalFicheros);
            System.out.println("Total de directorios: " + totalDirectorios);

        } catch (RutaNoValidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

