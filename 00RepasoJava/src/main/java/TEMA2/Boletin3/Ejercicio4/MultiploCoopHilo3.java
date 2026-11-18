package TEMA2.Boletin3.Ejercicio4;

public class MultiploCoopHilo3 extends Thread {

    private MultiplosCooperativos objeto;

    public MultiploCoopHilo3(MultiplosCooperativos objeto) {
        this.objeto = objeto;
    }

    @Override
    public void run() {
        objeto.imprimeMultiplos(3);
    }
}
