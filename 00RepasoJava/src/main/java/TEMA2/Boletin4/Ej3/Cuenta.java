package TEMA2.Boletin4.Ej3;

public class Cuenta {

    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void ingresarDinero(double cantidad) {
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() + " ingresa " + cantidad + " €. Saldo actual: " + saldo + " €");
    }

    public synchronized void retirarDinero(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println(Thread.currentThread().getName() + " retira " + cantidad + " €. Saldo actual: " + saldo + " €");
        } else {
            System.out.println(Thread.currentThread().getName() + " no puede retirar " + cantidad + " €. Saldo insuficiente: " + saldo + " €");
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}
