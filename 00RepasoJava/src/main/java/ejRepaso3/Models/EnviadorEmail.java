package ejRepaso3.Models;

import java.util.logging.Logger;

public class EnviadorEmail {

    private static Logger LOGGER =
            Logger.getLogger(EnviadorEmail.class.getName());

    public void enviar(String destinatario, String asunto, String texto) {

        LOGGER.info(
                "\n================ EMAIL ================\n" +
                "Para: " + destinatario + "\n" +
                "Asunto: " + asunto + "\n" +
                "Mensaje:\n" + texto + "\n" +
                "========================================"
        );
    }
}
