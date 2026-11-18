package TEMA2.Boletin3.Ejercicio4;

public class MultiplosCooperativos {

    public void imprimeMultiplos(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Múltiplo de " + numero + ": " + (numero * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
