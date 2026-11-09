package TEMA2.Boletin1.Ej1;

public class Hijo1 extends Thread{
	String nombreHilo;
	
	public Hijo1(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}



	@Override
	public void run() {
		while(true) {
			System.out.println(this.nombreHilo);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
