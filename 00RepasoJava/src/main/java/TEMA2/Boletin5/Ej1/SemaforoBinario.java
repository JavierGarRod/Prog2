package TEMA2.Boletin5.Ej1;

/*
ESTA CLASE VA A SER PRIEMPRE LA MISMA, LO UNICO QUE HACE ES VER SI 
ESTA LIBRE UNA ACCION PARA QUE PUEDA ENTRAR EL HILO
*/
public class SemaforoBinario { 
    private boolean libre = true;

    public synchronized void adquirir() {

        while (!libre) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        libre = false;
    }

    public synchronized void liberar() {
        libre = true;
        notify();
    }
}