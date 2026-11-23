package TEMA2.Boletin4.Ej1;

public class GestionaContadorVocales {
	public static void main(String[] args) {
		ContadorVocales contador=new ContadorVocales();
		String texto="Programacion concurrente con hilos en Java y sincronizacion";
		
		System.out.println("Texto: "+texto);
		
		char[] vocales= {'a','e','i','o','u'};
		ContadorHilo[] hilos=new ContadorHilo[vocales.length];
		
		int i=0;
		while(i<vocales.length) {
			hilos[i]=new ContadorHilo(texto, vocales[i], contador);
			hilos[i].start();
			
			i+=1;
		}
		
		int j=0;
		while(j<hilos.length) {
			try {
				hilos[j].join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			j+=1;
		}
		
		int total=contador.getVocalesTotales();
		System.out.println(total);
	}
}
