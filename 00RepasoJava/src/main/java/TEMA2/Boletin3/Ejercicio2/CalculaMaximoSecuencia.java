package TEMA2.Boletin3.Ejercicio2;

import java.util.Random;

public class CalculaMaximoSecuencia {

    public static void main(String[] args) {
        long inicioTiempo = System.currentTimeMillis();

        int tamTabla = 10000;
        int[] tabla = construyeTablaNotas(tamTabla);
        int maximo = calculaMax(tabla);

        System.out.println("Máximo encontrado: " + maximo);

        long finTiempo = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (finTiempo - inicioTiempo) + " ms");
    }

    private static int calculaMax(int[] tabla) {
        int maximo = tabla[0];
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] > maximo) maximo = tabla[i];
        }
        return maximo;
    }

    private static int[] construyeTablaNotas(int tamanyo) {
        int[] tabla = new int[tamanyo];
        Random random = new Random();
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = random.nextInt(500) + 1;
        }
        return tabla;
    }
}
