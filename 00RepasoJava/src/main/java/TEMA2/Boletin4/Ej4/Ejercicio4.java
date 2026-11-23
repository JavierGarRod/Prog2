package TEMA2.Boletin4.Ej4;

public class Ejercicio4 {

    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();

        Thread cocinero = new Thread(new Cocinero(bandeja), "Cocinero");
        Thread comensal1 = new Thread(new Comensal(bandeja), "Comensal 1");
        Thread comensal2 = new Thread(new Comensal(bandeja), "Comensal 2");
        Thread comensal3 = new Thread(new Comensal(bandeja), "Comensal 3");

        cocinero.start();
        comensal1.start();
        comensal2.start();
        comensal3.start();

        try {
            cocinero.join();
            comensal1.join();
            comensal2.join();
            comensal3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("El restaurante ha cerrado.");
    }
}
