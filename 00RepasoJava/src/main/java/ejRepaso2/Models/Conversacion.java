package ejRepaso2.Models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Conversacion {

    private String identificador;
    private String pregunta;
    private String respuesta;
    private LocalDate fechaConversacion;
    private int numValoracionesPositivas;

    // Necesario para poder calcular correctamente la media
    private double sumaValoraciones;

    public Conversacion() {
    }

    public Conversacion(TipoAgente tipo, String pregunta, String respuesta) {
        this.identificador = calcularIdentificador();
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.fechaConversacion = LocalDate.now();
        this.numValoracionesPositivas = 0;
        this.sumaValoraciones = 0;
    }

    /*
     * Constructor útil para recuperar/copiar una conversación
     */
    public Conversacion(TipoAgente tipo,
                        String peticion,
                        String respuesta,
                        LocalDate fechaConversacion,
                        double valoracion) {

        this.identificador = calcularIdentificador();
        this.pregunta = peticion;
        this.respuesta = respuesta;
        this.fechaConversacion = fechaConversacion;
        this.numValoracionesPositivas = 0;
        this.sumaValoraciones = valoracion;
    }

    private String calcularIdentificador() {
        long numeroAleatorio =
                ThreadLocalRandom.current().nextLong(1_000_000);

        return LocalDate.now().toString() + "-" + numeroAleatorio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public LocalDate getFechaConversacion() {
        return fechaConversacion;
    }

    public int getNumValoracionesPositivas() {
        return numValoracionesPositivas;
    }

    public double getSumaValoraciones() {
        return sumaValoraciones;
    }

    public void incrementarValoracion(double valoracion) {
        sumaValoraciones += valoracion;
        numValoracionesPositivas++;
    }

    public double getValoracionMedia() {
        if (numValoracionesPositivas == 0) {
            return 0;
        }

        return sumaValoraciones / numValoracionesPositivas;
    }

    @Override
    public String toString() {
        return "Conversacion{" +
                "identificador='" + identificador + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", fechaConversacion=" + fechaConversacion +
                ", numValoraciones=" + numValoracionesPositivas +
                ", valoracionMedia=" + getValoracionMedia() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Conversacion)) {
            return false;
        }

        Conversacion otra = (Conversacion) obj;

        return Objects.equals(this.identificador, otra.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
}

