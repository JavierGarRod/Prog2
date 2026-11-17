package TEMA2.Boletin2.Ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Métodos comunes para los ejercicios 2, 3 y 4.
 */
public class Utilidades {
    public static final String RUTA_DIRECTORIO = "src/main/resources";

    /** Devuelve los ficheros (no carpetas) que hay dentro de la ruta indicada, ordenados por nombre. */
    public List<File> listarFicheros(String ruta) {
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles(File::isFile);
        if (archivos == null) {
            throw new IllegalArgumentException("No existe la carpeta: " + directorio.getAbsolutePath());
        }
        Arrays.sort(archivos);
        return new ArrayList<>(Arrays.asList(archivos));
    }

    /** Cuenta los caracteres de un fichero de texto (UTF-8). */
    public int contarCaracteres(File fichero) {
        int contador = 0;
        char[] buffer = new char[8192];
        try (BufferedReader lector = new BufferedReader(
                new InputStreamReader(new FileInputStream(fichero), StandardCharsets.UTF_8))) {
            int leidos;
            while ((leidos = lector.read(buffer)) != -1) {
                contador += leidos;
            }
        } catch (IOException e) {
            System.err.println("Error leyendo " + fichero.getName() + ": " + e.getMessage());
        }
        return contador;
    }
}
