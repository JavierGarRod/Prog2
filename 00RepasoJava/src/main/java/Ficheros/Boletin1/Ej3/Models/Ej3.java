package Ficheros.Boletin1.Ej3.Models;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import Ficheros.Boletin1.Ej3.Exception.RutaNoValidaException;


public class Ej3 {
	private static Logger logger = Logger.getLogger(Ej3.class.getName());

    public static void main(String[] args) throws Exception{

        // 1. Crear el directorio miDirectorio dentro de la carpeta del usuario
        String usuario = System.getProperty("user.home");
        File directorio = new File(usuario, "miDirectorio");

        if (directorio.mkdir()) {
            logger.info("Directorio creado correctamente: " + directorio.getAbsolutePath());
        } else {
            logger.warning("Error al crear el directorio o ya existe: " + directorio.getAbsolutePath());
        }

        // 2. Crear los dos ficheros vacíos
        File lectura = new File(directorio, "lectura.txt");
        File normal = new File(directorio, "normal.txt");

        if (lectura.createNewFile()) {
		    logger.info("lectura.txt creado correctamente.");
		} else {
		    logger.warning("lectura.txt ya existía.");
		}

		if (normal.createNewFile()) {
		    logger.info("normal.txt creado correctamente.");
		} else {
		    logger.warning("normal.txt ya existía.");
		}

        // 3. Marcar lectura.txt como solo lectura
        if (lectura.setReadOnly()) {
            logger.info("lectura.txt marcado como solo lectura.");
        } else {
            logger.warning("No se pudo marcar lectura.txt como solo lectura.");
        }

        // 4. Mostrar los permisos de lectura, escritura y ejecución
        logger.info("Permisos de lectura.txt:");
        logger.info("Lectura: " + lectura.canRead());
        logger.info("Escritura: " + lectura.canWrite());
        logger.info("Ejecución: " + lectura.canExecute());

        logger.info("Permisos de normal.txt:");
        logger.info("Lectura: " + normal.canRead());
        logger.info("Escritura: " + normal.canWrite());
        logger.info("Ejecución: " + normal.canExecute());

        // 5. Renombrar normal.txt a renombrado.txt
        File renombrado = new File(directorio, "renombrado.txt");

        if (normal.renameTo(renombrado)) {
            logger.info("normal.txt renombrado correctamente a renombrado.txt.");
        } else {
            logger.warning("No se pudo renombrar normal.txt.");
        }

        // 6. Intentar borrar lectura.txt
        if (lectura.delete()) {
            logger.info("lectura.txt borrado correctamente.");
        } else {
            logger.warning("No se pudo borrar lectura.txt.");

            // Quitamos la marca de solo lectura
            if (lectura.setWritable(true)) {
                logger.info("Se ha quitado la marca de solo lectura de lectura.txt.");

                // Volvemos a intentar borrarlo
                if (lectura.delete()) {
                    logger.info("lectura.txt borrado correctamente tras quitar la marca de solo lectura.");
                } else {
                    logger.warning("No se pudo borrar lectura.txt después de quitar la marca de solo lectura.");
                }

            } else {
                logger.warning("No se pudo quitar la marca de solo lectura de lectura.txt.");
            }
        }

        // 7. Mostrar el contenido final de miDirectorio
        logger.info("Contenido final de miDirectorio:");

        File[] contenido = directorio.listFiles();

        if (contenido != null) {
            for (File archivo : contenido) {
                logger.info(archivo.getName());
            }
        } else {
            logger.warning("No se pudo obtener el contenido del directorio.");
        }
    }
}
