package ejRepaso4.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import ejRepaso4.Exception.EldenException;
import ejRepaso4.Models.Encuentro;
import ejRepaso4.Models.SinLuz;

public class Registro {

    /*
     * TreeSet con Comparator (nombre, identificador):
     *  - Mantiene los SinLuz SIEMPRE ordenados alfabéticamente por nombre.
     *  - Un Set evita duplicados; un HashSet/HashMap no ordenaría, y una List
     *    habría que reordenarla tras cada inserción.
     *  - Se desempata por identificador para que dos SinLuz distintos con el
     *    mismo nombre no se consideren "iguales" y se pierdan.
     */
    private TreeSet<SinLuz> sinLuces = new TreeSet<>(
            Comparator.comparing(SinLuz::getNombre).thenComparingInt(SinLuz::getIdentificador));

    public void agregaSinLuz(SinLuz s) {
        sinLuces.add(s);
    }

    // Apartado 2
    public SinLuz getSinLuz(int identificador) throws EldenException {
        for (SinLuz s : sinLuces) {
            if (s.getIdentificador() == identificador) return s;
        }
        throw new EldenException("No existe el SinLuz con el id:" + identificador);
    }

    // Apartado 3
    public void agregaEncuentro(Encuentro encuentro, int identificadorSinLuz) throws EldenException {
        SinLuz s = getSinLuz(identificadorSinLuz);   // lanza EldenException si no existe
        s.agregaEncuentro(encuentro);
    }

    // Apartado 5: SinLuz con algún encuentro de dificultad > 6
    public List<SinLuz> getSinLuzDificiles() {
        List<SinLuz> resultado = new ArrayList<>();
        for (SinLuz s : sinLuces) {
            for (Encuentro e : s.getEncuentros()) {
                if (e.getDificultad() > 6) {
                    resultado.add(s);
                    break;
                }
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SinLuz s : sinLuces) sb.append(s);
        return sb.toString();
    }
}
