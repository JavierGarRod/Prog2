package TEMA2.Boletin1.Ej4;

public class Mascota implements Runnable{
	private String nombre;
	private int contadorVecesComido;
	
	public Mascota(String nombre) {
		super();
		this.nombre = nombre;
		this.contadorVecesComido = 0;
	}
	
	private void comer(){
		this.contadorVecesComido++;
		System.out.println("La mascota con nombre: "+this.nombre+" ha comenzado a comer");
		
		// 3. Duerme el hilo 1 segundo * número de veces que ha comido
        try {
            Thread.sleep(1000 * contadorVecesComido);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }

        // 4. Imprime que ha terminado de comer (se muestra el contador para poder verlo)
        System.out.println("La mascota " + nombre + " ha terminado de comer (contador: " + contadorVecesComido + ")");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
