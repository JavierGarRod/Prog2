package ejRepaso2.Controller;

import java.time.LocalDate;

import ejRepaso2.Exception.ConversacionException;
import ejRepaso2.Models.Conversacion;
import ejRepaso2.Models.TipoAgente;
import ejRepaso2.Repository.IRepositorioConversaciones;

public class ServicioConversacionesImpl
        implements IServicioConversaciones {

    private IRepositorioConversaciones
            repositorioConversaciones;

    public ServicioConversacionesImpl(
            IRepositorioConversaciones repositorioConversaciones) {

        this.repositorioConversaciones =
                repositorioConversaciones;
    }

    @Override
    public void registraNuevaConveracion(
            TipoAgente tipo,
            String pregunta,
            String respuesta) {

        if (tipo == null) {
            return;
        }

        if (pregunta == null) {
            return;
        }

        if (respuesta == null) {
            return;
        }

        repositorioConversaciones.agregaConversacion(
                tipo,
                pregunta,
                respuesta);
    }

    @Override
    public Conversacion getRecuperaConversacion(
            TipoAgente tipo,
            String pregunta,
            LocalDate fecha) {

        if (tipo == null || pregunta == null || fecha == null) {
            return null;
        }

        try {
            return repositorioConversaciones.getConversacion(
                    fecha,
                    tipo,
                    pregunta);
        } catch (ConversacionException e) {

            return null;
        }
    }

    @Override
    public boolean eliminaConversacion(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta) {

        if (fecha == null
                || tipo == null || pregunta == null) {
            return false;
        }

        try {
            repositorioConversaciones.eliminaConversacion(
                    fecha,
                    tipo,
                    pregunta);
            return true;
        } catch (ConversacionException e) {
            return false;
        }
    }

    @Override
    public boolean incrementaNumeroValoraciones(
            LocalDate fecha,
            TipoAgente tipo,
            String pregunta,
            double valoracion) {

        // Validación realizada en el servicio
        if (fecha == null
                || tipo == null || pregunta == null) {
            return false;
        }

        // Ejemplo de valoración válida: 0-5
        if (valoracion < 0 || valoracion > 5) {
            return false;
        }
        try {
            repositorioConversaciones
                    .incrementaNumeroValoraciones(
                            fecha,
                            tipo,
                            pregunta,
                            valoracion);

            return true;

        } catch (ConversacionException e) {

            return false;
        }
    }

    @Override
    public double getValoracionMediaParaHumanos() {

        // Esta operación necesitaría consultar las conversaciones.
        // Ver implementación explicada abajo.

        return 0;
    }

    @Override
    public double getValoracionMedidaParaBots() {

        return 0;
    }
}

