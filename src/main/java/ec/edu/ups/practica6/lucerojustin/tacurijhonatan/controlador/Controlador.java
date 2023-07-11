/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica6.lucerojustin.tacurijhonatan.controlador;

import ec.edu.ups.practica6.lucerojustin.tacurijhonatan.modelo.Directorio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;



/**
 *
 * @author Usuario
 */
public class Controlador {
    public void crearDirectorio(String ruta, String nombreDirectorio) {
        String rutaCompleta = ruta + "/" + nombreDirectorio;

        File directorio = new File(rutaCompleta);

        if (directorio.exists()) {
            System.out.println("El directorio ya existe: " + directorio.getAbsolutePath());
        } else {
            boolean exito = directorio.mkdir();

            if (exito) {
                System.out.println("Directorio creado: " + directorio.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio: " + directorio.getAbsolutePath());
            }
        }
    }

    public void crearArchivo(String ruta, String nombreArchivo) {
        String rutaCompleta = ruta + "/" + nombreArchivo;

        File archivo = new File(rutaCompleta);

        if (archivo.exists()) {
            System.out.println("El archivo ya existe: " + archivo.getAbsolutePath());
        } else {
            try {
                boolean exito = archivo.createNewFile();

                if (exito) {
                    System.out.println("Archivo creado: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el archivo: " + archivo.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
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

    public boolean eliminarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);

        if (archivo.exists() && archivo.isFile()) {
            return archivo.delete();
        }

        return false;
    }

    /*private void eliminarContenidoDirectorio(File directorio) {
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    eliminarContenidoDirectorio(archivo);
                }
                archivo.delete();
            }
        }
    }*/
    
    
   public void listarDirectorios(File directorio, DefaultMutableTreeNode nodoPadre) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        DefaultMutableTreeNode nodoDirectorio = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoDirectorio);
                        listarDirectorios(archivo, nodoDirectorio);
                    }
                }
            }
        }
    }

   
   public void listarArchivos(File directorio, DefaultMutableTreeNode nodoPadre) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        DefaultMutableTreeNode nodoArchivo = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoArchivo);
                    }
                }
            }
        }
    }
    public void listarDirectoriosOcultos(File directorio, DefaultMutableTreeNode nodoPadre) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory() && archivo.isHidden()) {
                        DefaultMutableTreeNode nodoDirectorio = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoDirectorio);
                        listarDirectoriosOcultos(archivo, nodoDirectorio);
                    }
                }
            }
        }
    }
    
    public void listarArchivosOcultos(File directorio, DefaultMutableTreeNode nodoPadre) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.isHidden()) {
                        DefaultMutableTreeNode nodoArchivo = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoArchivo);
                    }
                }
            }
        }
    }
    
    public void listarTodo(File directorio, DefaultMutableTreeNode nodoPadre) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        DefaultMutableTreeNode nodoDirectorio = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoDirectorio);
                        listarTodo(archivo, nodoDirectorio);
                    } else {
                        DefaultMutableTreeNode nodoArchivo = new DefaultMutableTreeNode(archivo.getName());
                        nodoPadre.add(nodoArchivo);
                    }
                }
            }
        }
    }
    
     public boolean renombrarArchivo(String nombreAnterior, String nuevoNombre) {
        File archivoAnterior = new File(nombreAnterior);
        File archivoNuevo = new File(archivoAnterior.getParent(), nuevoNombre);

        if (archivoAnterior.exists() && !archivoNuevo.exists()) {
            return archivoAnterior.renameTo(archivoNuevo);
        }

        return false;
    }

    public boolean renombrarDirectorio(String nombreAnterior, String nuevoNombre) {
        File directorioAnterior = new File(nombreAnterior);
        File directorioNuevo = new File(directorioAnterior.getParent(), nuevoNombre);

        if (directorioAnterior.exists() && !directorioNuevo.exists()) {
            return directorioAnterior.renameTo(directorioNuevo);
        }

        return false;
    }
}

