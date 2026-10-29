package Boletin1.Ej2.Models;

public class LanzadorAnalisisTemperaturas {
	public static void main(String[] args) throws Exception{
		double[] umbral = {10, 20, 25, 30, 35};
        String rutaFichero = args[0];
        for(int i=0;i<umbral.length;i++) {
        	ProcessBuilder pb1=new ProcessBuilder(
    				"java","-cp", 
    				System.getProperty("java.class.path"), 
    				"AnalizadorTemperaturas", 
    				String.valueOf(i), rutaFichero
    		);
        	
        	System.out.println("Resultado guardado en " + umbral[i] + ".txt");
    		pb1.start();
        }
	}
}
