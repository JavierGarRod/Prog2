package TEMA2.Boletin1.Ej4;

public class Mascota implements Runnable{
	private String nombre;
	private int contadorVecesComido;
	
	public Mascota(String nombre, int contadorVecesComido) {
		super();
		this.nombre = nombre;
		this.contadorVecesComido = contadorVecesComido;
	}
	
	private void comer(){
		this.contadorVecesComido++;
		System.out.println("La mascota con nombre: "+this.nombre+" ha comenzado a comer");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
