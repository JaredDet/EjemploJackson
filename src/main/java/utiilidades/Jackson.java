package utiilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import errores.LanzadorMensaje;

public class Jackson {


    private static Object convertirJSONaObjeto(String json, Class<?> clase) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clase);
    }

    public static Object manejoConvertirJSONaObjeto(String json, Class<?> clase) {
        try {
            return convertirJSONaObjeto(json, clase);
        } catch (JsonProcessingException e) {
            LanzadorMensaje.lanzarError(e);
            return null;
        }
    }

    private static String convertirObjetoaJSON(Object objeto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(objeto);
    }

    public static String manejoConvertirObjetoaJSON(Object objeto) {
        try {
            return convertirObjetoaJSON(objeto);
        } catch (JsonProcessingException e) {
            LanzadorMensaje.lanzarError(e);
            return null;
        }
    }
}
