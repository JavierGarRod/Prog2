package Boletin1.Ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ContadorPalabras {
	private static final Logger logger = Logger.getLogger(ContadorPalabras.class.getName());
	
	public static void main(String[] args) {
		ContadorPalabras ref=new ContadorPalabras();
		ref.cuentaPalabraContenidoFichero(null, null);
	}
	
	public int  cuentaPalabraContenidoFichero(String rutaYNombre, String palabra) throws FileNotFoundException{
		Scanner in=null;
		int contador = 0;
		List<String> contenido=new ArrayList<String>();
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				String leida = in.next();
				if(leida.equals(palabra))
				{
					contador ++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
			
				// OjO Al cerrar el Scanner cierra también el FileReader que envuelve. 
			}
			
		}
		return contador;
	}
}
