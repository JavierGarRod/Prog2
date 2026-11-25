package TEMA2.Boletin4.Ej3;

public class Retirador extends Thread {

    private Cuenta cuenta;
    private int operaciones;

    public Retirador(Cuenta cuenta, String nombre, int operaciones) {
        super(nombre);
        this.cuenta = cuenta;
        this.operaciones = operaciones;
    }

    @Override
    public void run() {
        for (int i = 0; i < operaciones; i++) {
            int cantidad = (int) (Math.random() * 500 + 1);
            cuenta.retirarDinero(cantidad);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
