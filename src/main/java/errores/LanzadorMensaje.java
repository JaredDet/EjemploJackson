package errores;

import java.io.IOException;

public class LanzadorMensaje {

    public static void lanzarError(IOException e) {
        System.err.println("Ha ocurrido un error: " + e.getMessage());
    }

    public static void lanzarNoSeHaEncontradoLaClase(ClassNotFoundException e) {
        System.err.println("Error: no se ha encontrado la clase " + e.getMessage());
    }

    public static void lanzarEntradaNoValida() {
        System.err.println("Entrada no válida");
    }

    public static void lanzarNoSeHaEncontradoLaMascota(){
        System.err.println("No se ha encontrado la mascota");
    }

    public static void lanzarStringNulo(){
        System.err.println("No se admite String vacíos");
    }
}
