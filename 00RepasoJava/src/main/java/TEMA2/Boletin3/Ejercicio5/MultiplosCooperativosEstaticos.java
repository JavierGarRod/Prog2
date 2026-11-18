package TEMA2.Boletin3.Ejercicio5;

public class MultiplosCooperativosEstaticos {

    public static void imprimeMultiplos(int numero) {
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
