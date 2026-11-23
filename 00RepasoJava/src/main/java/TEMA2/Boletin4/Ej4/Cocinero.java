package TEMA2.Boletin4.Ej4;

public class Cocinero implements Runnable {

    private Bandeja bandeja;

    public Cocinero(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 12; i++) {
            try {
                System.out.println("Cocinero preparando plato " + i);
                Thread.sleep(5000);
                bandeja.ponerPlato(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("El cocinero ha terminado su jornada.");
    }
}
