package ejRepaso2.Controller;

import java.time.LocalDate;

import ejRepaso2.Models.Conversacion;
import ejRepaso2.Models.TipoAgente;

public interface IServicioConversaciones {

    void registraNuevaConveracion(
            TipoAgente tipo,
            String pregunta,
            String respuesta);

    Conversacion getRecuperaConversacion(
            TipoAgente tipo,
            String pregunta,
            LocalDate fecha);

    boolean eliminaConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta);

    boolean incrementaNumeroValoraciones(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta,
            double valoracion);

    double getValoracionMediaParaHumanos();

    double getValoracionMedidaParaBots();
}

