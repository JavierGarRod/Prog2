package Ficheros;

import java.io.File;
import java.io.IOException;

public class Introduccion {
    public static void main(String[] args) {
        String rutaDirectorio = "C:\\Users\\profesor\\Documents\\Tema1Fichero";
        File directorio = new File(rutaDirectorio);

        // Referencio a un fichero dentro del directorio
        File fichero = new File(directorio, "fichero.txt");

        try {
            boolean creado = fichero.createNewFile();

            if (creado) {
                System.out.println("Fichero creado correctamente.");
            } else {
                System.out.println("El fichero ya existe.");
            }

        } catch (IOException e) {
            System.err.println("Error al crear fichero: " + e.getMessage());
        }
    }
}
