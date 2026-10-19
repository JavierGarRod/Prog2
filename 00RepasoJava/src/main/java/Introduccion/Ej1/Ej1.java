package Introduccion.Ej1;

public class Ej1 {
	public static void main(String[] args) {
		ProcessBuilder pb=new ProcessBuilder("python", "src/main/resources/prueba1.py");
		pb.inheritIO();
		//pb.start();
	
	}
}
