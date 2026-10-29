package ExamenT1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class LanzadorProcesadorSuministro {
	public static String RUTA="src/main/resources/recargas.txt";
	public static void main(String[] args) {
		try {
			
			//Abrimos el fichero
			BufferedReader br = new BufferedReader(new FileReader(RUTA));
			String linea=br.readLine();
			String lineaSeparado=null;
			Process proceso=null;
			BufferedReader br1 = null;
			int total=0;
			
	        // Leemos el fichero línea a línea.
	        while (linea != null) {
	        	lineaSeparado=linea.replace(";", " ");
	        	String [] comando = {"java","-cp", 
						System.getProperty("java.class.path"), 
						"ProcesadorSuministrosPorPunto",
						lineaSeparado};
	        	ProcessBuilder pb1=new ProcessBuilder(comando);
	        	pb1.inheritIO();
	        	proceso=pb1.start();
	        	
	        	br1 = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	        	
	        	//Recibo el total de kWh del hijo y lo sumo a el total
		        int totalKWHporHora=Integer.parseInt(br1.readLine());
		        total=total+totalKWHporHora;
		        
		        // Esperamos a que termine el proceso hijo.
	            int codigoSalida = proceso.waitFor();
	            System.out.println("Entro en while");
	        }
	        
            System.out.println("--- Resumen de facturación --");
            System.out.println(linea);
            System.out.println("TOTAL facturado: "+total);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
