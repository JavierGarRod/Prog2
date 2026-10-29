package Resumen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * PROGRAMACIÓN DE SERVICIOS Y PROCESOS
 * Unidad 1: Multiproceso
 *
 * Ejemplos de:
 * - Runtime
 * - Process
 * - ProcessBuilder
 * - Procesos padre e hijo
 * - Comunicación entre procesos
 * - ProcessHandle
 */

public class ResumenT1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== PRACTICA PSP =====");
            System.out.println("1. Informacion de Runtime");
            System.out.println("2. Ejecutar un programa con Runtime.exec()");
            System.out.println("3. Ejecutar un programa con ProcessBuilder");
            System.out.println("4. Crear un proceso hijo Java");
            System.out.println("5. Comunicacion con el proceso hijo");
            System.out.println("6. Informacion del proceso actual");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    informacionRuntime();
                    break;

                case 2:
                    ejecutarConRuntime();
                    break;

                case 3:
                    ejecutarConProcessBuilder();
                    break;

                case 4:
                    crearProcesoHijo();
                    break;

                case 5:
                    comunicacionProcesoHijo();
                    break;

                case 6:
                    //informacionProcesoActual();
                    break;

                case 0:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        teclado.close();
    }

    /*
     * 1. CLASE RUNTIME
     *
     * Runtime permite obtener informacion de la maquina virtual
     * y ejecutar programas del sistema operativo.
     */

    public static void informacionRuntime() {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("\n--- INFORMACION DE RUNTIME ---");

        // Memoria libre disponible en la JVM.
        System.out.println("Memoria libre: "
                + runtime.freeMemory() + " bytes");

        // Memoria total actualmente reservada por la JVM.
        System.out.println("Memoria total: "
                + runtime.totalMemory() + " bytes");

        // Memoria maxima que puede utilizar la JVM.
        System.out.println("Memoria maxima: "
                + runtime.maxMemory() + " bytes");

        // Numero de procesadores disponibles.
        System.out.println("Procesadores disponibles: "
                + runtime.availableProcessors());

        // Version de Java.
        System.out.println("Version de Java: "
                + System.getProperty("java.version"));
    }

    /*
     * 2. RUNTIME.EXEC()
     *
     * Permite ejecutar un programa externo.
     *
     * Este ejemplo abre el Bloc de notas en Windows.
     */

    public static void ejecutarConRuntime() {

        try {

            Runtime runtime = Runtime.getRuntime();

            // Ejecutamos el Bloc de notas.
            Process proceso = runtime.exec("notepad.exe");

            System.out.println("Programa ejecutado.");

            // Esperamos a que termine el proceso.
            int resultado = proceso.waitFor();

            System.out.println("Codigo de salida: " + resultado);

        } catch (IOException e) {

            System.out.println("Error al ejecutar el programa.");
            e.printStackTrace();

        } catch (InterruptedException e) {

            // Recuperamos el estado de interrupcion del hilo.
            Thread.currentThread().interrupt();

            System.out.println("El proceso fue interrumpido.");
        }
    }

    /*
     * 3. PROCESSBUILDER
     *
     * ProcessBuilder permite configurar y ejecutar procesos.
     *
     * En este ejemplo se abre el Bloc de notas.
     */

    public static void ejecutarConProcessBuilder() {

        try {

            // Creamos el ProcessBuilder.
            ProcessBuilder pb =
                    new ProcessBuilder("notepad.exe");

            // Iniciamos el proceso.
            Process proceso = pb.start();

            System.out.println("Proceso iniciado con ProcessBuilder.");

            // Esperamos a que termine.
            int resultado = proceso.waitFor();

            System.out.println("Codigo de salida: " + resultado);

        } catch (IOException e) {

            System.out.println("No se pudo iniciar el proceso.");
            e.printStackTrace();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("Proceso interrumpido.");
        }
    }

    /*
     * 4. PROCESO PADRE E HIJO
     *
     * Este programa Java ejecuta otra clase Java llamada Hija.
     *
     * La clase Hija se encuentra mas abajo, en este mismo archivo.
     */

    public static void crearProcesoHijo() {

        try {

            // Ruta del ejecutable Java.
            String java = System.getProperty("java.home")
                    + System.getProperty("file.separator")
                    + "bin"
                    + System.getProperty("file.separator")
                    + "java";

            // Classpath utilizado por el programa actual.
            String classpath = System.getProperty("java.class.path");

            // Creamos el proceso hijo.
            ProcessBuilder pb = new ProcessBuilder(
                    java,
                    "-cp",
                    classpath,
                    "Hija",
                    "Hola desde el padre",
                    "10"
            );

            // El hijo utiliza la misma entrada y salida que el padre.
            pb.inheritIO();

            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            System.out.println("Proceso hijo iniciado.");

            // Esperamos a que termine.
            int resultado = proceso.waitFor();

            System.out.println(
                    "El proceso hijo ha terminado con codigo: "
                    + resultado
            );

        } catch (IOException e) {

            System.out.println("Error al crear el proceso hijo.");
            e.printStackTrace();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("El padre fue interrumpido.");
        }
    }

    /*
     * 5. COMUNICACION ENTRE PADRE E HIJO
     *
     * El padre lee la salida estandar del proceso hijo.
     *
     * getInputStream() permite leer lo que el hijo escribe
     * mediante System.out.println().
     */

    public static void comunicacionProcesoHijo() {

        try {

            String java = System.getProperty("java.home")
                    + System.getProperty("file.separator")
                    + "bin"
                    + System.getProperty("file.separator")
                    + "java";

            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(
                    java,
                    "-cp",
                    classpath,
                    "Hija",
                    "Mensaje recibido",
                    "25"
            );

            // Redirigimos los errores a la salida estandar.
            pb.redirectErrorStream(true);

            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            // Obtenemos el flujo de salida del hijo.
            InputStream flujo = proceso.getInputStream();

            // Convertimos bytes en caracteres.
            InputStreamReader lector =
                    new InputStreamReader(flujo);

            // Leemos el texto linea a linea.
            BufferedReader buffer =
                    new BufferedReader(lector);

            String linea;

            while ((linea = buffer.readLine()) != null) {

                System.out.println("Hijo dice: " + linea);
            }

            // Esperamos a que termine el proceso.
            int resultado = proceso.waitFor();

            System.out.println(
                    "Codigo de salida del hijo: " + resultado
            );

        } catch (IOException e) {

            System.out.println("Error de comunicacion.");
            e.printStackTrace();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("Proceso interrumpido.");
        }
    }

    /*
     * 6. PROCESSHANDLE
     *
     * ProcessHandle permite consultar informacion
     * sobre un proceso del sistema.
     */

   /* public static void informacionProcesoActual() {
    	
        // Obtenemos el proceso actual.
        Process proceso =
                Process.current();

        System.out.println("\n--- PROCESSHANDLE ---");

        // PID del proceso.
        System.out.println("PID: "
                + proceso.pid());

        // Informacion general del proceso.
        ProcessHandle.Info info =
                proceso.info();
    	
        // Comando utilizado para iniciar el proceso.
        System.out.println("Comando: "
                + info.command().orElse("No disponible"));

        // Argumentos del proceso.
        System.out.println("Argumentos: "
                + info.arguments()
                .map(argumentos ->
                        String.join(" ", argumentos))
                .orElse("No disponibles"));

        // Momento de inicio del proceso.
        System.out.println("Inicio: "
                + info.startInstant()
                .map(Object::toString)
                .orElse("No disponible"));

        // Tiempo de CPU utilizado.
        System.out.println("Tiempo de CPU: "
                + info.totalCpuDuration()
                .map(Object::toString)
                .orElse("No disponible"));

        // Usuario que ejecuta el proceso.
        System.out.println("Usuario: "
                + info.user()
                .orElse("No disponible"));
    }
}*/


/*
 * CLASE HIJA
 *
 * Esta clase se ejecuta como un proceso independiente.
 *
 * Recibe argumentos desde el proceso padre:
 * args[0] -> mensaje
 * args[1] -> numero
 */

class Hija {

    public void main(String[] args) {

        System.out.println("--- PROCESO HIJO ---");

        // Comprobamos que se han recibido argumentos.
        if (args.length >= 2) {

            // Primer argumento: mensaje.
            String mensaje = args[0];

            // Segundo argumento: numero.
            int numero = Integer.parseInt(args[1]);

            System.out.println("Mensaje recibido: " + mensaje);

            System.out.println("Numero recibido: " + numero);

            System.out.println("Numero multiplicado por 2: "
                    + (numero * 2));

        } else {

            System.err.println(
                    "Error: faltan argumentos."
            );

            // Terminamos el proceso indicando un error.
            System.exit(1);
        }
    }
}
}