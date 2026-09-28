package ejRepaso2.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejRepaso2.Exception.ConversacionException;
import ejRepaso2.Models.Conversacion;
import ejRepaso2.Models.TipoAgente;

public class RepositorioConversaciones
        implements IRepositorioConversaciones {

    private List<Conversacion> conversaciones;

    public RepositorioConversaciones() {
        conversaciones = new ArrayList<>();
    }

    @Override
    public void agregaConversacion(
            TipoAgente tipo,
            String pregunta,
            String respuesta) {

        Conversacion conversacion =
                new Conversacion(tipo, pregunta, respuesta);

        conversaciones.add(conversacion);
    }

    @Override
    public Conversacion getConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta)
            throws ConversacionException {

        for (Conversacion c : conversaciones) {

            if (c.getFechaConversacion().equals(fecha)
                    && c.getPregunta().equals(pregunta)) {

                // El tipo debería estar asociado a la conversación.
                // Como el diagrama no lo incluye como atributo,
                // se recomienda añadirlo al modelo.
            }
        }

        throw new ConversacionException(
                "No existe la conversación solicitada");
    }

    @Override
    public boolean contieneConversacion(
            Conversacion conversacion) {

        return conversaciones.contains(conversacion);
    }

    @Override
    public void eliminaConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta)
            throws ConversacionException {

        Conversacion encontrada =
                buscarConversacion(fecha, tipo, pregunta);

        conversaciones.remove(encontrada);
    }

    @Override
    public void incrementaNumeroValoraciones(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta,
            double valoracion)
            throws ConversacionException {

        Conversacion encontrada =
                buscarConversacion(fecha, tipo, pregunta);

        encontrada.incrementarValoracion(valoracion);
    }

    private Conversacion buscarConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta)
            throws ConversacionException {

        for (Conversacion c : conversaciones) {

            if (c.getFechaConversacion().equals(fecha)
                    && c.getPregunta().equals(pregunta)) {

                return c;
            }
        }

        throw new ConversacionException(
                "No existe la conversación");
    }
}

