/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica6.lucerojustin.tacurijhonatan.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Directorio {
    public boolean crearDirectorio(String rutaDirectorio) {
        File nuevoDirectorio = new File(rutaDirectorio);
        
        if (!nuevoDirectorio.exists()) {
            if (nuevoDirectorio.mkdirs()) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean eliminarDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        eliminarDirectorio(archivo.getAbsolutePath());
                    } else {
                        archivo.delete();
                    }
                }
            }
            
            return directorio.delete();
        }
        
        return false;
    }
    
    public List<String> listarDirectorios(String rutaDirectorio) {
        List<String> listaDirectorios = new ArrayList<>();
        File directorio = new File(rutaDirectorio);
        
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        listaDirectorios.add(archivo.getName());
                    }
                }
            }
        }
        
        return listaDirectorios;
    }
    
    public boolean crearArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) {
            try {
                return archivo.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean eliminarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        
        if (archivo.exists() && archivo.isFile()) {
            return archivo.delete();
        }
        return false;
    }
    
    public List<String> listarArchivos(String rutaDirectorio) {
        List<String> listaArchivos = new ArrayList<>();
        File directorio = new File(rutaDirectorio);
        
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        listaArchivos.add(archivo.getName());
                    }
                }
            }
        }
        return listaArchivos;
    }
    
}
