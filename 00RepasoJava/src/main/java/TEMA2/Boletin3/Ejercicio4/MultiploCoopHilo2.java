package TEMA2.Boletin3.Ejercicio4;

public class MultiploCoopHilo2 extends Thread {

    private MultiplosCooperativos objeto;

    public MultiploCoopHilo2(MultiplosCooperativos objeto) {
        this.objeto = objeto;
    }

    @Override
    public void run() {
        objeto.imprimeMultiplos(2);
    }
}
