package Ficheros.Boletin2.Models;

import java.io.File;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Ficheros.Boletin2.Exception.DiffFolderException;

public class DiffFolder{
	private File directorio1;
	private File directorio2;


	public DiffFolder(String ruta1, String ruta2) throws DiffFolderException{
		super();
		this.directorio1 = new File(ruta1);
		this.directorio2 = new File(ruta2);

        if (directorio1!=null && directorio2!=null && !directorio1.isDirectory() && !directorio2.isDirectory()) { // Comprobar si la ruta existe
            setFolders(directorio1, directorio2);
        }else {
        	throw new DiffFolderException("La ruta no existe");
        }
	}
	
	public void setFolders(File direc1, File direc2) {
		this.directorio1 = direc1;
		this.directorio2 = direc2;
	}
	
	public Collection<ResultadoComparacion> comparame(){
		int cantidad1=directorio1.listFiles().length;
		int cantidad2=directorio2.listFiles().length;
		
		return null;
	}

}
