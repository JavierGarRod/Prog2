package TEMA2.Boletin1.Ej8;

public class Mascota extends Thread{
	String nombreHilo;
	
	public Mascota(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}



	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("SERVICIO");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("Termina SERVICIOS");
	}
}
