package TEMA2.Boletin2.Ej1;

import java.util.concurrent.atomic.AtomicInteger;

class Cuidador implements Runnable {
	//Contador compartido de animales atendidos (AtomicInteger => seguro entre hilos)
	static int animalesAtendidos = 0;
	
    private int numero;

    Cuidador(int numero) {
        this.numero = numero;
    }
    
    public Cuidador() {
		super();
	}


	@Override
    public void run() {
        // Se muestra la prioridad real que tiene el hilo en ejecución
        int prioridad = Thread.currentThread().getPriority();
        int animal = animalesAtendidos++;
        System.out.println("Cuidador " + numero + " (prioridad " + prioridad
                + ") atiende al animal nº " + animal);
    }
}
