package TEMA2.Boletin1.Ej5;

public class GestionaMascotas {

    public static void main(String[] args) {
        final int NUM_CUIDADORES = 100; // antes 5

        Mascota lulu = new Mascota("Lulú");

        // 100 hilos (cuidadores) asociados al MISMO objeto Mascota
        for (int i = 1; i <= NUM_CUIDADORES; i++) {
            Thread cuidador = new Thread(lulu, "Cuidador-" + i);
            cuidador.start();
        }
    }
}
