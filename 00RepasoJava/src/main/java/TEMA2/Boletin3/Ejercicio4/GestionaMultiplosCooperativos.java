package TEMA2.Boletin3.Ejercicio4;

public class GestionaMultiplosCooperativos {

    public static void main(String[] args) {
        long inicioTiempo = System.currentTimeMillis();
        MultiplosCooperativos objeto = new MultiplosCooperativos();

        MultiploCoopHilo2 hilo2 = new MultiploCoopHilo2(objeto);
        MultiploCoopHilo3 hilo3 = new MultiploCoopHilo3(objeto);
        MultiploCoopHilo7 hilo7 = new MultiploCoopHilo7(objeto);

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
