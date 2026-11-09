package TEMA2.Boletin1.Ej1;

import java.util.ArrayList;
import java.util.List;

public class HiloPadre {

	public HiloPadre() {
		super();
	}
	
	public static void main(String[] args) {
		List<Thread.State> estadosHilos=new ArrayList<Thread.State>();
		
		Hijo1 hilo=new Hijo1("PROCESOS");
		Hijo1 hilo1=new Hijo1("SERVICIO");
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
