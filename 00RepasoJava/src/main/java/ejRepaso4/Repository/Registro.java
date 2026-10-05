package ejRepaso4.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejRepaso4.Exception.EldenException;
import ejRepaso4.Models.Encuentro;
import ejRepaso4.Models.SinLuz;

public class Registro {

    private Map<Integer, SinLuz> sinLuces = new HashMap<>();

    public void agregaSinLuz(SinLuz s) {
        sinLuces.put(s.getIdentificador(), s);
    }

    // Apartado 2
    public SinLuz getSinLuz(int identificador) throws EldenException {
        SinLuz s = sinLuces.get(identificador);

        if (s == null) {
            throw new EldenException(
                "No existe el SinLuz con el id:" + identificador
            );
        }

        return s;
    }

    // Apartado 3
    public void agregaEncuentro(Encuentro encuentro, int identificadorSinLuz)
            throws EldenException {

        SinLuz s = getSinLuz(identificadorSinLuz);
        s.agregaEncuentro(encuentro);
    }

    // Apartado 5
    public List<SinLuz> getSinLuzDificiles() {
        List<SinLuz> resultado = new ArrayList<>();

        for (SinLuz s : sinLuces.values()) {
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

        for (SinLuz s : sinLuces.values()) {
            sb.append(s);
        }

        return sb.toString();
    }
}
