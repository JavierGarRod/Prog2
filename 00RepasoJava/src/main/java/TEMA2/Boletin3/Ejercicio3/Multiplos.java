package TEMA2.Boletin3.Ejercicio3;

public class Multiplos implements Runnable {

    private int numero;

    public Multiplos(int numero) {
        this.numero = numero;
    }

    public void imprimeMultiplos() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Múltiplo de " + numero + ": " + (numero * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override
    public void run() {
        imprimeMultiplos();
    }
}
