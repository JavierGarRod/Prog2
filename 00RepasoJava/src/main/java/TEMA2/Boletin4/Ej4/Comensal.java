package TEMA2.Boletin4.Ej4;

public class Comensal implements Runnable {

    private Bandeja bandeja;

    public Comensal(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            try {
                int plato = bandeja.retirarPlato();

                System.out.println(Thread.currentThread().getName()
                        + " está comiendo el plato " + plato);

                Thread.sleep(3000);

                System.out.println(Thread.currentThread().getName()
                        + " ha terminado de comer el plato " + plato);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(Thread.currentThread().getName()
                + " ha terminado de comer.");
    }
}
