package TEMA2.Boletin3.Ejercicio3;

public class GestionaMultiplos {

    public static void main(String[] args) {
        long inicioTiempo = System.currentTimeMillis();

        Multiplos multDe2 = new Multiplos(2);
        Multiplos multDe3 = new Multiplos(3);
        Multiplos multDe7 = new Multiplos(7);

        Thread hilo1 = new Thread(multDe2);
        Thread hilo2 = new Thread(multDe3);
        Thread hilo3 = new Thread(multDe7);

        try {
            hilo1.start();
            hilo2.start();
            hilo3.start();

            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ejecución interrumpida.");
        }

        long finTiempo = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (finTiempo - inicioTiempo) + " ms");
    }
}
