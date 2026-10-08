package Ficheros.Boletin1.Ej7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ej7 {
	 private static final Logger logger = Logger.getLogger(Ej7.class.getName());

	 public static void main(String[] args) {
	    	
		 File directorio = new File("C:\\Users\\profesor\\Documents\\Tema1Fichero");
		 Ej7 ref=new Ej7();
		 Scanner teclado = new Scanner(System.in);
	     logger.info("Introduce una letra: ");
	     String letra = teclado.nextLine();

	     List<File> resultados = ref.buscar(directorio, letra);

	     for (File fichero : resultados) {
	         logger.info(fichero.getAbsolutePath());
	     }
	 }
	 
	 public List<File> buscar(File directorio, String letraBuscar) {
	     List<File> resultado = new ArrayList<>();

	     //Mira si el directorio es nulo o no existe
	     if (directorio == null || !directorio.isDirectory()) {
	         return resultado;
	     }

	     //Crea una lista de ficheros que contiene el directorio
	     File[] ficheros = directorio.listFiles();

	     //Si el directorio no tiene ficheros
	     if (ficheros == null) {
	         return resultado;
	     }

	     //Recorre los ficheros del directorio
	     for (File fichero : ficheros) {

	    	 //Si el fichero seleccionado es un directorio hace la recursiva
	         if (fichero.isDirectory()) {
	             resultado.addAll(buscar(fichero, letraBuscar));

	         //Si no se obtiene su nombre y se comprueba si contiene la letra a buscar, si es asi, lo añade a la lista resultado
	         } else {
	             if (fichero.getName().toLowerCase().contains(letraBuscar.toLowerCase())) {
	                 resultado.add(fichero);
	             }
	         }
	     }

	     return resultado;
	 }
	
}
