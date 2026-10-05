package Ficheros.Boletin1.Ej4.Models;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ej4 {

    private static Logger logger = Logger.getLogger(Ej4.class.getName());

    public static void main(String[] args) {

        
        Scanner teclado = new Scanner(System.in);
        logger.info("Introduce la ruta del directorio (Sin comillas): ");
        String ruta = teclado.nextLine();
        File directorio = new File(ruta);
        
        Ej4 ref = new Ej4();
        ref.listar(directorio);

    }

    public void listar(File directorio) {
        File[] contenido = directorio.listFiles();

        if (contenido != null) {
            for (File archivo : contenido) {
                if (archivo.isDirectory()) {
                    // Entramos en el directorio y lo listamos recursivamente
                    listar(archivo);
                } else {
                    logger.info(archivo.getAbsolutePath());
                }
            }
        }
    }
}
