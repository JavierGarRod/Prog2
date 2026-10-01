package ejRepaso4.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Encuentro {
    private String nombre;
    private LocalDate fecha;
    private int dificultad;
    private List<String> enemigos;

    public Encuentro(String nombre, LocalDate fecha, int dificultad, List<String> enemigos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.dificultad = dificultad;
        this.enemigos = new ArrayList<>(enemigos);   // en lugar de List.copyOf
    }
    // resto de la clase igual

    public String getNombre() { return nombre; }
    public LocalDate getFecha() { return fecha; }
    public int getDificultad() { return dificultad; }
    public List<String> getEnemigos() { return enemigos; }

    // Un encuentro se identifica por su nombre (permite "actualizarlo" en el apartado 4.3)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encuentro)) return false;
        return nombre.equals(((Encuentro) o).nombre);
    }

    @Override
    public int hashCode() { return Objects.hash(nombre); }

    @Override
    public String toString() {
        return nombre + " [" + fecha + ", dificultad=" + dificultad + ", enemigos=" + enemigos + "]";
    }
}