package Simulaciones.Simulacion1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneradorHacienda {
	public static void main(String[] args) {

        try {
            // Creamos el proceso hijo y le pasamos el fichero.
        	ProcessBuilder pb = new ProcessBuilder(
        		    "java",
        		    "-cp",
        		    System.getProperty("java.class.path"),
        		    "GeneraNSSFichero",
        		    args[0]
        		);

            // Iniciamos la ejecución del programa hijo.
            Process proceso = pb.start();

            // Leemos los datos que envía el hijo.
            BufferedReader br = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
            );

            // Recibimos el número de líneas que contienen NSS.
            int lineasNSS = Integer.parseInt(br.readLine());

            // Recibimos el número total de líneas.
            int totalLineas = Integer.parseInt(br.readLine());

            // Esperamos a que termine el proceso hijo.
            int codigoSalida = proceso.waitFor();

            // Calculamos el porcentaje de líneas con NSS.
            double porcentaje = 0;

            if (totalLineas > 0) {
                porcentaje = (double) (lineasNSS / totalLineas) * 100;
            }

            // Mostramos los resultados.
            System.out.println("Líneas con NSS: " + lineasNSS);
            System.out.println("Líneas totales: " + totalLineas);
            System.out.printf("Porcentaje de líneas con NSS: %.2f%%%n",porcentaje);

        } catch (Exception e) {
            // Informamos si ocurre un error al ejecutar el hijo
            // o al recibir sus datos.
            System.out.println("Error: " + e.getMessage());
        }
    }
}
