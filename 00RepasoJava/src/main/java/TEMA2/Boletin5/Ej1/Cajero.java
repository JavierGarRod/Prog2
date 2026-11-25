package TEMA2.Boletin5.Ej1;


public class Cajero implements Runnable {
    private Cuenta cuenta;
    private SemaforoBinario semaforo;
    private String nombre;

    public Cajero(Cuenta cuenta, SemaforoBinario semaforo, String nombre) {
        this.cuenta = cuenta;
        this.semaforo = semaforo;
        this.nombre = nombre;
    }

    @Override
    public void run() {  //"PIDE PERMISO" SI LO TIENE CONSULTA LOS DATOS Y CUANDO TERMINA LIBERA LA ACCIÓN

        semaforo.adquirir();

        try {
            cuenta.consultaDatos(nombre);
        } finally {
            semaforo.liberar();
        }
    }
}
