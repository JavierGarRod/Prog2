package TEMA2.Boletin1.Ej8;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascota {
	public GestionaMascota() {
		super();
	}
	
	public static void main(String[] args) {
		List<Thread.State> estadosHilos=new ArrayList<Thread.State>();
		
		Mascota hilo=new Mascota("PROCESOS");
		Mascota hilo1=new Mascota("SERVICIO");
		Thread h1=new Thread(hilo);
		Thread h2=new Thread(hilo1);
		
		estadosHilos.add(h1.getState());
	
		h1.start();
		estadosHilos.add(h1.getState());
		h2.start();
		
		try {
			Thread.currentThread().sleep(5000);
			estadosHilos.add(h1.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(estadosHilos);
	
	}
}
