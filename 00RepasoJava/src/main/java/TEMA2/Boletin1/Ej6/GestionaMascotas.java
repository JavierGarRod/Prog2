package TEMA2.Boletin1.Ej6;

public class GestionaMascotas {

    public static void main(String[] args) {
        final int NUM_CUIDADORES = 100;

        Mascota lulu = new Mascota("Lulú");
        Thread[] cuidadores = new Thread[NUM_CUIDADORES];

        for (int i = 0; i < NUM_CUIDADORES; i++) {
            cuidadores[i] = new Thread(lulu, "Cuidador-" + (i + 1));
            cuidadores[i].start();
        }

        // El hilo principal espera a que TODOS los cuidadores terminen.
        // Sin join(), main imprimiría el valor antes de que acaben los hilos.
        for (int i = 0; i < NUM_CUIDADORES; i++) {
            try {
                cuidadores[i].join();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }

        System.out.println("Lulú ha comido " + lulu.getVecesComido() + " veces");
    }
}
