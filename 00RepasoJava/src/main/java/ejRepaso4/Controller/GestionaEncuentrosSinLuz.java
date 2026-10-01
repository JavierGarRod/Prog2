package ejRepaso4.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import ejRepaso4.Exception.EldenException;
import ejRepaso4.Models.Encuentro;
import ejRepaso4.Models.SinLuz;
import ejRepaso4.Repository.Registro;

public class GestionaEncuentrosSinLuz {
    public static void main(String[] args) {
        Registro registro = new Registro();

        SinLuz ardyn = new SinLuz("Ardyn");
        SinLuz selene = new SinLuz("Selene");
        SinLuz kael = new SinLuz("Kael");
        registro.agregaSinLuz(ardyn);
        registro.agregaSinLuz(selene);
        registro.agregaSinLuz(kael);

        Encuentro e1 = new Encuentro("Asalto al Bastión Carmesí", LocalDate.of(2025, 3, 10), 8, Arrays.asList("Caballero Carmesí", "Tirano de Ceniza"));
        Encuentro e2 = new Encuentro("Emboscada en el Bosque Umbrío", LocalDate.of(2025, 3, 14), 5, Arrays.asList("Lobo Siniestro", "Bandido espectral"));
        Encuentro e3 = new Encuentro("Duelo en la Cripta Helada", LocalDate.of(2025, 3, 18), 7, Arrays.asList("Espectro del Hielo", "Mago congelado"));
        Encuentro e4 = new Encuentro("Resistencia en la Torre Abandonada", LocalDate.of(2025, 3, 20), 6, Arrays.asList("Arquero maldito", "Guardián de piedra"));
        Encuentro e5 = new Encuentro("Invasión en la Villa Marchita", LocalDate.of(2025, 3, 23), 9, Arrays.asList("Gigante marchito", "Portador del Plomo"));
        Encuentro e6 = new Encuentro("Caza en el Lago Sombrío", LocalDate.of(2025, 3, 25), 4, Arrays.asList("Serpiente negra", "Sombra anfibia"));
        Encuentro e7 = new Encuentro("Asalto final al Nexo del Caos", LocalDate.of(2025, 3, 30), 10, Arrays.asList("Señor del Caos", "Centinela oscuro", "Eco ardiente"));
        
        try {
            // 1. Agregar encuentros a los 3 SinLuz e imprimir
            registro.agregaEncuentro(e1, ardyn.getIdentificador());
            registro.agregaEncuentro(e2, ardyn.getIdentificador());
            registro.agregaEncuentro(e3, ardyn.getIdentificador());
            registro.agregaEncuentro(e4, selene.getIdentificador());
            registro.agregaEncuentro(e5, selene.getIdentificador());
            registro.agregaEncuentro(e6, kael.getIdentificador());
            registro.agregaEncuentro(e7, kael.getIdentificador());

            System.out.println("=== REGISTRO (ordenado por nombre) ===");
            System.out.println(registro);
        } catch (EldenException ex) {
            System.out.println(ex.getMessage());
        }

        // 2. SinLuz no almacenado en el registro
        SinLuz fantasma = new SinLuz("Fantasma");   // creado pero NO agregado
        try {
            registro.agregaEncuentro(e1, fantasma.getIdentificador());
        } catch (EldenException ex) {
            System.out.println("Excepción capturada: " + ex.getMessage());
        }

        // 3. Agregar un encuentro que el SinLuz ya contiene (mismo nombre, otros datos)
        Encuentro e1Modificado = new Encuentro("Asalto al Bastión Carmesí",
                LocalDate.of(2025, 4, 1), 3, Arrays.asList("Caballero Carmesí"));
        try {
            System.out.println("\n=== ANTES de actualizar ===");
            System.out.print(registro.getSinLuz(ardyn.getIdentificador()));

            registro.agregaEncuentro(e1Modificado, ardyn.getIdentificador());

            System.out.println("=== DESPUÉS de actualizar ===");
            System.out.print(registro.getSinLuz(ardyn.getIdentificador()));
        } catch (EldenException ex) {
            System.out.println(ex.getMessage());
        }

        // Apartado 5: SinLuz con dificultad > 6
        System.out.println("\n=== SinLuz con algún encuentro de dificultad > 6 ===");
        for (SinLuz s : registro.getSinLuzDificiles()) {
            System.out.print(s);
        }
    }
}
