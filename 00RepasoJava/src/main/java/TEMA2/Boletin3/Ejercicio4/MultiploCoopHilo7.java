package TEMA2.Boletin3.Ejercicio4;

public class MultiploCoopHilo7 extends Thread {

    private MultiplosCooperativos objeto;

    public MultiploCoopHilo7(MultiplosCooperativos objeto) {
        this.objeto = objeto;
    }

    @Override
    public void run() {
        objeto.imprimeMultiplos(7);
    }
}
