import datos.ManejoDatos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestManejoDatos {

    private static ManejoDatos manejo;

    @BeforeEach
    void setUp() {
        manejo = new ManejoDatos("");
    }

    @AfterEach
    void tearDown() {
        manejo = null;
        System.gc();
    }

    @Test
    @DisplayName("Test para verificar fallos al crear un archivo")
    void falloAlCrearArchivo(){
        assertFalse(manejo.manejoCrear());
    }

    @Test
    @DisplayName("Test para verificar fallos al leer un archivo")
    void falloAlLeerArchivo(){
        assertNull(manejo.manejoLeer(null));
    }

    @Test
    @DisplayName("Test para verificar fallos al llamar a una clase")
    void falloAlLlamarUnaClase(){
        manejo.setArchivo("src/main/resources/recursos.txt");
        assertNull(manejo.manejoLeer("modelo.Generico"));
    }

    @Test
    @DisplayName("Test para verificar fallos al actualizar un archivo")
    void falloAlActualizarArchivo(){
        assertFalse(manejo.manejoActualizar(null));
    }

    @Test
    @DisplayName("Test para verificar que no se puede borrar un archivo que no existe")
    void falloAlBorrarArchivo(){
        assertFalse(manejo.borrar());
    }

    @Test
    @DisplayName("Test para verificar que se crea el archivo")
    void exitoAlCrearArchivo(){
        manejo.setArchivo("src/main/resources/prueba.txt");
        manejo.manejoCrear();
        assertTrue(manejo.getArchivo().exists());
    }

    @Test
    @DisplayName("Test para verificar que no se puede crear un archivo que ya existe")
    void falloAlCrearArchivoExistente(){
        manejo.setArchivo("src/main/resources/prueba.txt");
        assertFalse(manejo.manejoCrear());
    }

    @Test
    @DisplayName("Test para verificar que se borra el archivo")
    void exitoAlBorrarArchivo(){
        manejo.setArchivo("src/main/resources/prueba.txt");
        assertTrue(manejo.borrar());
    }
}
