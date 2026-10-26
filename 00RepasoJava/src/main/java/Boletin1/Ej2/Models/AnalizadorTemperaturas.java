
package Boletin1.Ej2.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class AnalizadorTemperaturas {

    public static void main(String[] args) {
        AnalizadorTemperaturas ref = new AnalizadorTemperaturas();
        double[] umbral = {10, 20, 25, 30, 35};
        String ruta = args[0];

        try {
            ref.analizar(umbral, ruta);
        } catch (Exception e) {
            System.out.println("Error al procesar el fichero: " + e.getMessage());
        }
    }

    public void analizar(double[] umbral, String rutaFichero) throws IOException {
        int contador = 0;

        // Leer las temperaturas del fichero
        try (Scanner in = new Scanner(new File(rutaFichero))) {

            while (in.hasNextDouble()) {
                double temperatura = in.nextDouble();
                for(int i=0;i<umbral.length;i++) {
                	if (temperatura >= i) {
                        contador++;
                    }
                }
            }
        }
        
        for(int i=0;i<umbral.length;i++) {
        	// Crear el nombre del fichero de salida
            String nombreSalida = i % 1 == 0
                    ? String.valueOf((int) i)
                    : String.valueOf(umbral);

            // Escribir el resultado en un fichero llamado umbral.txt
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(nombreSalida + ".txt"))) {

                bw.write(String.valueOf(contador));
            }

            System.out.println("Temperaturas iguales o superiores a " + umbral + ": " + contador);
        }
        
    }
}
