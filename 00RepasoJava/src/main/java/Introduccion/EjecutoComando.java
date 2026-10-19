package Introduccion;

public class EjecutoComando {
	private final static String directorioGenerarClasses = "target\\classes";
		
	public int ejecutaClase (String clase) {
	   int exit = -1;
	   String claseCompleta =  clase;
	    
	   try {
			String[] comando = {"java", "-cp",
			directorioGenerarClasses, 
			claseCompleta };
			ProcessBuilder pb = new ProcessBuilder(comando);
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process proceso = pb.start();
			exit = proceso.waitFor();
			System.out.println(exit);
	   } 
	   catch (Exception e) {
			System.out.println(e.getMessage());
			
	   }
	   
	   return exit;
	}
}
