package ejRepaso2.Repository;

import java.time.LocalDate;

import ejRepaso2.Exception.ConversacionException;
import ejRepaso2.Models.Conversacion;
import ejRepaso2.Models.TipoAgente;

public interface IRepositorioConversaciones {

    void agregaConversacion(
            TipoAgente tipo,
            String pregunta,
            String respuesta);

    Conversacion getConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta)
            throws ConversacionException;

    boolean contieneConversacion(
            Conversacion conversacion);

    void eliminaConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta)
            throws ConversacionException;

    void incrementaNumeroValoraciones(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta,
            double valoracion)
            throws ConversacionException;
}

