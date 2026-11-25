package TEMA2.Boletin4.Ej4;

import java.util.List;
import java.util.ArrayList;

public class Bandeja {

    private int capacidad;
    List<String> bandejaPlatos;
    private int numPlatos;

    public Bandeja() {
        this.capacidad = 3;
        this.bandejaPlatos = new ArrayList<String>();
        this.numPlatos=1;
    }

    public synchronized void pongoPlato(String plato) throws InterruptedException {

        while (bandejaPlatos.size() == capacidad) {
            System.out.println("Bandeja de platos llena");
            wait();
        }

        System.out.println("Añade " + plato+""+this.numPlatos + " a bandeja");
        this.bandejaPlatos.add(plato);
        this.numPlatos++;
        notifyAll();
    }

    public synchronized void quitoPlato() throws InterruptedException {

        while (this.bandejaPlatos.isEmpty()) {
            System.out.println("Bandeja de platos vacía");
            wait();
        }

        System.out.println("Quita plato a bandeja: ");
        this.bandejaPlatos.remove(0);
        notifyAll();
    }
}