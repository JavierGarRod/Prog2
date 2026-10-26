package Boletin1.Ej1;

public class LanzadorContadoresPalabras {
	public static void main(String[] args) throws Exception{
		String ruta=args[0];
		
		ProcessBuilder pb1=new ProcessBuilder(
				"java","-cp", 
				System.getProperty("java.class.path"), 
				"ContadorPalabras", 
				ruta, args[1]
		);
		
		pb1.start();
	}
}
