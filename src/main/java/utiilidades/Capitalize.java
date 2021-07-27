package utiilidades;

import errores.LanzadorMensaje;

public class Capitalize {

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            LanzadorMensaje.lanzarStringNulo();
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
