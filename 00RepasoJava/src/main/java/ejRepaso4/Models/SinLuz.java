package ejRepaso4.Models;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class SinLuz {
    private static int contador = 0;          // autoincremental

    private int identificador;
    private String nombre;

    /*
     * Map<String, Encuentro> (clave = nombre del encuentro) en lugar de List:
     *  - Una List permitiría duplicados y habría que buscar a mano el encuentro
     *    repetido para sustituirlo.
     *  - Con un Map, put() con la misma clave reemplaza el valor: "actualizar"
     *    un encuentro existente es O(1) y no hay duplicados.
     *  - LinkedHashMap conserva el orden de inserción para imprimir.
     */
    private Map<String, Encuentro> encuentros = new LinkedHashMap<>();

    public SinLuz(String nombre) {
        this.identificador = ++contador;
        this.nombre = nombre;
    }

    public int getIdentificador() { return identificador; }
    public String getNombre() { return nombre; }
    public Collection<Encuentro> getEncuentros() { return encuentros.values(); }

    public void agregaEncuentro(Encuentro e) {
        encuentros.put(e.getNombre(), e);   // añade o actualiza
    }

    // Igualdad solo por identificador
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinLuz)) return false;
        return identificador == ((SinLuz) o).identificador;
    }

    @Override
    public int hashCode() { return Objects.hash(identificador); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinLuz #").append(identificador).append(" - ").append(nombre).append("\n");
        if (encuentros.isEmpty()) sb.append("   (sin encuentros)\n");
        for (Encuentro e : encuentros.values()) sb.append("   · ").append(e).append("\n");
        return sb.toString();
    }
}
