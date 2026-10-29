package Simulaciones.Simulacion1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class GeneraNSSFichero {
	public static void main(String[] args) {
		// Comprobamos que se ha recibido el nombre del fichero.
        if (args.length == 0) {
            System.out.println("Error");
        }

        // Contadores de líneas.
        int totalLineas = 0;
        int lineasNSS = 0;

        // Abrimos el fichero de entrada y el fichero de salida.
        try (
            BufferedReader br = new BufferedReader(
                new FileReader(args[0])
            );
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("NSSs.txt")
            )
        ) {

            String linea;

            // Leemos el fichero línea a línea.
            while ((linea = br.readLine()) != null) {

                // Contamos todas las líneas del fichero.
                totalLineas++;

                // Comprobamos si la línea contiene un NSS válido.
                if (contieneNSS(linea)) {

                    // Contamos las líneas que contienen un NSS.
                    lineasNSS++;

                    // Guardamos la línea en NSSs.txt.
                    bw.write(linea);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }

        // Enviamos los dos contadores al programa padre.
        // Cada número se escribe en una línea diferente.
        System.out.println(lineasNSS);
        System.out.println(totalLineas);
    }

    // Método que comprueba si una línea contiene un NSS.
    public static boolean contieneNSS(String linea) {
        // Recorremos todos los caracteres de la línea.
        for (int i = 0; i <= linea.length() - 12; i++) {
            // Comprobamos que comienza por AN.
            if (linea.charAt(i) == 'A' && linea.charAt(i + 1) == 'N') {
                // Comprobamos que los diez caracteres siguientes
                // son dígitos.
                boolean valido = true;

                for (int j = i + 2; j < i + 12; j++) {
                    if (!Character.isDigit(linea.charAt(j))) {
                        valido = false;
                    }
                }
                // Si los diez caracteres son dígitos,
                // hemos encontrado un NSS.
                if (valido) {
                    return true;
                }
            }
        }

        // Si no encontramos ningún NSS, devolvemos false.
        return false;
    }
}
