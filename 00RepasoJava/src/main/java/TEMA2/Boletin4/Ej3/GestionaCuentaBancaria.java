package TEMA2.Boletin4.Ej3;

public class GestionaCuentaBancaria {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000); // Saldo inicial

        // Cinco ingresos en total, repartidos entre dos hilos
        Thread ingreso1 = new Ingresador(cuenta, "Ingresador 1", 3);
        Thread ingreso2 = new Ingresador(cuenta, "Ingresador 2", 2);

        // Cinco retiradas en total, repartidas entre dos hilos
        Thread retirada1 = new Retirador(cuenta, "Retirador 1", 3);
        Thread retirada2 = new Retirador(cuenta, "Retirador 2", 2);

        ingreso1.start();
        retirada1.start();
        ingreso2.start();
        retirada2.start();

        try {
            ingreso1.join();
            ingreso2.join();
            retirada1.join();
            retirada2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Saldo final: " + cuenta.getSaldo() + " €");
    }
}
