package ejRepaso2.Controller;

import java.time.LocalDate;

import ejRepaso2.Models.Conversacion;
import ejRepaso2.Models.TipoAgente;
import ejRepaso2.Repository.IRepositorioConversaciones;
import ejRepaso2.Repository.RepositorioConversaciones;

public class GestionaPeticionesAChat {

    public static void main(String[] args) {

        IRepositorioConversaciones repositorio =
                new RepositorioConversaciones();

        IServicioConversaciones servicio =
                new ServicioConversacionesImpl(repositorio);

        // Registrar conversaciones
        servicio.registraNuevaConveracion(
                TipoAgente.HUMANO,
                "¿Cuál es el horario?",
                "Nuestro horario es de 9:00 a 18:00.");

        servicio.registraNuevaConveracion(
                TipoAgente.IA,
                "¿Cómo puedo cambiar mi contraseña?",
                "Puede cambiarla desde la sección de configuración.");

        servicio.registraNuevaConveracion(
                TipoAgente.HUMANO,
                "¿Dónde está mi pedido?",
                "Su pedido está en reparto.");

        // Como la fecha es LocalDate.now()
        LocalDate hoy = LocalDate.now();

        // Recuperar conversación
        Conversacion conversacion =
                servicio.getRecuperaConversacion(
                        TipoAgente.HUMANO,
                        "¿Cuál es el horario?",
                        hoy);

        if (conversacion != null) {
            System.out.println(conversacion);
        }

        // Añadir valoración
        boolean valorada =
                servicio.incrementaNumeroValoraciones(
                        hoy,
                        TipoAgente.HUMANO,
                        "¿Cuál es el horario?",
                        5);

        System.out.println(
                "Valoración registrada: " + valorada);

        // Obtener medias
        System.out.println(
                "Media humanos: "
                + servicio.getValoracionMediaParaHumanos());

        System.out.println(
                "Media bots: "
                + servicio.getValoracionMedidaParaBots());

        // Eliminar
        boolean eliminada =
                servicio.eliminaConversacion(
                        hoy,
                        TipoAgente.HUMANO,
                        "¿Dónde está mi pedido?");

        System.out.println(
                "Conversación eliminada: " + eliminada);
    }
}

