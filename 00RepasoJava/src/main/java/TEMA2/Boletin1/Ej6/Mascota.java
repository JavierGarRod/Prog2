package TEMA2.Boletin1.Ej6;

public class Mascota implements Runnable {

    private String nombre;
    private int vecesComido;

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.vecesComido = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVecesComido() {
        return vecesComido;
    }

    @Override
    public void run() {
        comer();
    }

    public void comer() {
        // 1. Incrementa el número de veces que come
        vecesComido++;

        // 2. Imprime que ha comenzado a comer
        System.out.println("La mascota " + nombre + " ha comenzado a comer");

        // 3. Duerme el hilo 1 segundo * número de veces que ha comido
        try {
            Thread.sleep(1000 * vecesComido);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }

        // 4. Imprime que ha terminado de comer
        System.out.println("La mascota " + nombre + " ha terminado de comer");
    }
}
