package TEMA2.Boletin3.Ejercicio5;

public class GestionaMultiplosEstaticos {

    public static void main(String[] args) {
        long inicioTiempo = System.currentTimeMillis();

        MultiploEstaticoDe2 hilo2 = new MultiploEstaticoDe2();
        MultiploEstaticoDe3 hilo3 = new MultiploEstaticoDe3();
        MultiploEstaticoDe7 hilo7 = new MultiploEstaticoDe7();

        try {
            hilo2.start();
            hilo3.start();
            hilo7.start();

            hilo2.join();
            hilo3.join();
            hilo7.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ejecución interrumpida.");
        }

        long finTiempo = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (finTiempo - inicioTiempo) + " ms");
    }
}
