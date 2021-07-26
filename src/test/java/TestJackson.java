import modelo.Persona;
import utiilidades.Jackson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJackson {

    @Test
    @DisplayName("Test para verificar fallos al pasar de Objeto a String con formato JSON")
    void FalloAlPasarAJSON(){
        assertEquals("null", Jackson.manejoConvertirObjetoaJSON(null));
    }

    @Test
    @DisplayName("Test para verificar fallos al pasar de un String JSON a un objeto")
    void FalloAlLeerArchivo(){
        assertNull(Jackson.manejoConvertirJSONaObjeto("Generico", Persona.class));
    }
}
