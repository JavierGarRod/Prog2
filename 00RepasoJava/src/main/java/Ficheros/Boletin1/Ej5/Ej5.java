package Ficheros.Boletin1.Ej5;

import java.io.File;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ej5 ref=new Ej5();

        System.out.print("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine();

        File directorio = new File(ruta);

        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("La ruta no corresponde a un directorio.");
            return;
        }

        int bytes = ref.calcularTamano(directorio);

        if (bytes < 1024) {
            System.out.printf("Tamaño: %.2f bytes%n", (double) bytes);
        } else if (bytes < 1024 * 1024) {
            System.out.printf("Tamaño: %.2f KB%n", bytes / 1024.0);
        } else {
            System.out.printf("Tamaño: %.2f MB%n", bytes / (1024.0 * 1024.0));
        }
    }
    
    public int calcularTamano(File directorio) {
        int tamano = 0;
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    tamano += archivo.length();
                } else if (archivo.isDirectory()) {
                    tamano += calcularTamano(archivo);
                }
            }
        }

        return tamano;
    }
}
