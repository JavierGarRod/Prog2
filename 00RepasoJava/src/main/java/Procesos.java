import java.io.IOException;
import java.util.logging.Logger;

import Ficheros.Boletin1.Ej4.Models.Ej4;

public class Procesos {
	/*public static void main(String[] args)
	{
			Runtime rt = Runtime.getRuntime();
			System.out.println("Memoria Libre:" + rt.freeMemory());
			System.out.println("Total Memoria:" + rt.totalMemory());
			System.out.println("Max Memoria:" + rt.maxMemory());
			System.out.println("Nº Procesadores" + rt.availableProcessors());
			//System.out.println("JRE Version:" + rt.version());
			System.out.println("Terminando programa...");
			rt.exit(1); //Termina la ejecución de la máquina virtual
	}*/
	private static Logger logger = Logger.getLogger(Procesos.class.getName());
	
	public static void main(String[] args){
		
		
		Runtime rt = Runtime.getRuntime();
		String[] informacionProceso = {"notePad.exe"};
		Process proceso;
		try {
			proceso = rt.exec(informacionProceso);
			int codigoRetorno = proceso.waitFor(); //Espero a que termine
			System.out.println(codigoRetorno);;
		} catch (IOException e) {
			System.out.println(e.getMessage());;
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());;
		}
	}

}
