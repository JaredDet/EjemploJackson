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
}
