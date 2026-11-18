package TEMA2.Boletin3.Ejercicio1;

public class CalculaMaxHilo implements Runnable {

    private int[] tabla;
    private int inicio;
    private int fin;
    private int maximoTramo;

    public CalculaMaxHilo(int[] tabla, int inicio, int fin) {
        this.tabla = tabla;
        this.inicio = inicio;
        this.fin = fin;
    }

    private int calculaMax() {
        int maximo = tabla[inicio];

        for (int i = inicio; i < fin; i++) {
            if (tabla[i] > maximo) {
                maximo = tabla[i];
            }
        }
        return maximo;
    }

    @Override
    public void run() {
        maximoTramo = calculaMax();
        System.out.println("Máximo del rango " + inicio + " - "
                + (fin - 1) + ": " + maximoTramo);
    }

    public int getMaximoTramo() {
        return maximoTramo;
    }
}
