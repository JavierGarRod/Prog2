package Ficheros.Boletin1.Ej2.Models;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Ficheros.Boletin1.Ej2.Exception.RutaNoValidaException;



public class Ej2 {

    public static void main(String[] args) {
    	
    	//PIDO AL USUARIO LA RUTA
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una ruta: ");
        String ruta = scanner.nextLine();

        //CONTROLO LA EXCEPCIÓN
        
        Ej2 bol = new Ej2();
        
        try {
            bol.mostrarInformacion(ruta);
        } catch (RutaNoValidaException e) {
            System.out.println(e.getMessage());
        }
    }

    	//MÉTODOS
    
    public void mostrarInformacion(String ruta) throws RutaNoValidaException { //sin usar static en los métodos (mejor crear objetos)
        File f = new File(ruta);

        // SI NO EXISTE -> EXCEPCION
        if (!f.exists()) {
            throw new RutaNoValidaException("Error: La ruta introducida no existe.");
        }

        // NOMBRE ELEMENTO -getName()
        System.out.println("Nombre: " + f.getName());

        // TOMAR LA RUTA RELATIVA -getPath()
        System.out.println("Ruta tal como se ha escrito: " + f.getPath());

        // TOMAR RUTA ABSOLUTA ( C:\ ...) -getAbsolutePath()
        System.out.println("Ruta absoluta: " + f.getAbsolutePath());

        // TOMAR RUTA CANONICA -getCanonicalPath()
        try {
            System.out.println("Ruta canónica: " + f.getCanonicalPath());
        } catch (IOException e) {
            System.out.println("Ruta canónica: No disponible");
        }

        // TOMAR DIRECTORIO PADRE -getParent()
        System.out.println("Directorio padre: " + f.getParent());

        // COMPROBAR SI ES TIPO DIRECTORIO -isDirectory()
        if (f.isDirectory()) {
            System.out.println("Tipo: Directorio");
        } else {
            System.out.println("Tipo: Fichero");
        }

        // COMPROBAR PERMISOS DE LECTURA, ESCRITURA Y EJECUCIÓN
        System.out.println("Permiso de lectura: " + f.canRead());
        System.out.println("Permiso de escritura: " + f.canWrite());
        System.out.println("Permiso de ejecución: " + f.canExecute());

        // COMPROBAR SI ESTÁ OCULTO -isHidden()
        System.out.println("Oculto: " + f.isHidden());

        // TAMAÑO EN BYTES -length()	
        System.out.println("Tamaño en bytes: " + f.length());

        // SI ES DIRECTORIO Y LISTA NOT NULL-> NUM ELEMENTOS
        if (f.isDirectory()) {
            File[] lista = f.listFiles();
            if (lista != null) {
                System.out.println("Número de elementos: " + lista.length);
            } else {
                System.out.println("Número de elementos: Sin acceso a lectura");
            }
        }

        // FECHA ÚLTIMA MODIFICACIÓN (.format() para modificar y .lastModified() para saber cuándo se hizo)
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(new Date(f.lastModified()));
        System.out.println("Fecha de última modificación: " + fechaFormateada);
    }
}
