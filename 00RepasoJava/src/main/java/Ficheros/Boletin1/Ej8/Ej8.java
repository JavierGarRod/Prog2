package Ficheros.Boletin1.Ej8;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class Ej8 {
	private static final Logger logger = Logger.getLogger(Ej8.class.getName());

    public static void main(String[] args) {

        File directorio = new File("C:\\Users\\profesor\\Documents\\Tema1Fichero");

        File[] ficheros = directorio.listFiles(File::isFile);

        if (ficheros == null) {
            logger.warning("No se ha podido acceder al directorio.");
            return;
        }

        // Ordenar por tamaño: de mayor a menor
        Arrays.sort(ficheros, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return Long.compare(f2.length(), f1.length());
            }
        });

        logger.info("5 ficheros más grandes:");

        for (int i = 0; i < Math.min(5, ficheros.length); i++) {
            logger.info(ficheros[i].getName() + " - " + ficheros[i].length() + " bytes");
        }

        // Ordenar por fecha de modificación: de más reciente a más antiguo
        Arrays.sort(ficheros, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return Long.compare(f2.lastModified(), f1.lastModified());
            }
        });

        logger.info("Ficheros ordenados por fecha de modificación:");

        for (File fichero : ficheros) {
            logger.info(fichero.getName() + " - " + fichero.lastModified());
        }
    }
}
