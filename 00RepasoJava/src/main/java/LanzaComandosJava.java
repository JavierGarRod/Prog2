import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzaComandosJava {
	private final static String directorioGenerarClasses = "target\\classes";
	private final static String rutaSourceJava = "src\\main\\java\\unidad1\\ProcesoHijo.java";

	public int lanzaCompilador(String rutaFicheroFuente, String rutaParaGenerarClass) {
		ProcessBuilder pb;
		int salida=-1;
		try {
			String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSourceJava};
			pb = new ProcessBuilder(comando);
			pb.inheritIO(); // La salidas y los errores se ven por consola
			Process proceso = pb.start();
			salida = proceso.waitFor(); //esperamos a que javac termine 
			logger.debug("javac terminó con código {}", salida); 

		} catch (Exception e) { 			
			logger.error(e.getMessage()); 		
		}
		return salida;
	}
	
	private static Logger logger = LogManager.getLogger(LanzaComandosJava.class);
	
	public static void main(String[] args) {
		LanzaComandosJava l = new LanzaComandosJava();
		int codigo= l.lanzaCompilador(rutaSourceJava, directorioGenerarClasses);                 
	} }
