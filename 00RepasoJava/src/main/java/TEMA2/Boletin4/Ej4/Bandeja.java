package TEMA2.Boletin4.Ej4;

import java.util.LinkedList;
import java.util.Queue;

public class Bandeja {

    private Queue<Integer> platos = new LinkedList<>();
    private final int capacidad = 3;

    public synchronized void ponerPlato(int numero) throws InterruptedException {
        while (platos.size() == capacidad) {
            System.out.println("Bandeja llena. El cocinero espera...");
            wait();
        }

        platos.add(numero);
        System.out.println(Thread.currentThread().getName()
                + " deja el plato " + numero
                + ". Platos en bandeja: " + platos.size());

        notifyAll();
    }

    public synchronized int retirarPlato() throws InterruptedException {
        while (platos.isEmpty()) {
            System.out.println(Thread.currentThread().getName()
                    + " espera porque la bandeja está vacía...");
            wait();
        }

        int plato = platos.poll();
        System.out.println(Thread.currentThread().getName()
                + " retira el plato " + plato
                + ". Platos en bandeja: " + platos.size());

        notifyAll();
        return plato;
    }
}
