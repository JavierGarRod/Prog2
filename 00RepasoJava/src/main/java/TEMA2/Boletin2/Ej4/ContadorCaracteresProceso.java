package TEMA2.Boletin2.Ej4;

import java.io.File;

import TEMA2.Boletin2.Ej3.Utilidades;

/**
 * Lanza COMO PROCESO independiente (Ejercicio 4).
 * Recibe la ruta de un fichero como argumento, cuenta sus caracteres
 * y escribe el número por la salida estándar para que el proceso padre lo lea.
 */
public class ContadorCaracteresProceso {
    public static void main(String[] args) {
    	Utilidades ref=new Utilidades();
        if (args.length < 1) {
            System.err.println("Uso: java ContadorCaracteresProceso <fichero>");
            System.exit(1);
        }
        System.out.println(ref.contarCaracteres(new File(args[0])));
    }
}
