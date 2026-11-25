package TEMA2.Boletin5.Ej1;


public class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public void consultaDatos(String cajero) {

        System.out.println(cajero + " está consultando la cuenta.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(cajero + " - Saldo disponible: " + saldo + " euros.");
        System.out.println(cajero + " ha terminado la consulta.");
    }
}
