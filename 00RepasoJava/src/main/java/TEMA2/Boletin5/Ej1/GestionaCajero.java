package TEMA2.Boletin5.Ej1;



public class GestionaCajero {
    public static void main(String[] args) { 
        Cuenta cuenta = new Cuenta(1500);

        SemaforoBinario semaforo = new SemaforoBinario();

        Cajero c1 = new Cajero(cuenta, semaforo, "Cajero 1");
        Cajero c2 = new Cajero(cuenta, semaforo, "Cajero 2");

        Thread hilo1 = new Thread(c1);
        Thread hilo2 = new Thread(c2);

        hilo1.start();
        hilo2.start();
    }
}