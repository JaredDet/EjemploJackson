package datos;

import errores.LanzadorMensaje;
import utiilidades.Jackson;

import java.io.*;

public class ManejoDatos {


    private File archivo;

    public ManejoDatos(String ruta) {
        this.archivo = new File(ruta);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(String ruta) {
        archivo = new File(ruta);
    }

    private void crear() throws IOException {

        if (archivo.createNewFile()) {
            System.out.println("Se ha creado el archivo: " + archivo.getName());
        }
    }

    public boolean manejoCrear() {
        try {
            if (!archivo.exists()) {
                crear();
                return true;
            } else {
                System.err.println("ERROR: El archivo ya existe");
                return false;
            }
        } catch (IOException e) {
            LanzadorMensaje.lanzarError(e);
            return false;
        }
    }

    private Object leer(String nombreClase) throws IOException, ClassNotFoundException {

        FileReader file = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(file);
        return Jackson.manejoConvertirJSONaObjeto(lector.readLine(), Class.forName(nombreClase));
    }

    public Object manejoLeer(String nombreClase) {

        try {
            return leer(nombreClase);
        } catch (IOException e) {
            LanzadorMensaje.lanzarError(e);
            return null;
        } catch (ClassNotFoundException e) {
            LanzadorMensaje.lanzarNoSeHaEncontradoLaClase(e);
            return null;
        }
    }

    private void escribirJSON(String json) throws IOException {
        FileWriter escritor;
        escritor = new FileWriter(archivo);
        escritor.write(json);
        escritor.close();
    }

    private void actualizar(Object objeto) throws IOException {
        String json = Jackson.manejoConvertirObjetoaJSON(objeto);
        escribirJSON(json);
    }

    public boolean manejoActualizar(Object objeto) {
        try {
            actualizar(objeto);
        } catch (IOException e) {
            LanzadorMensaje.lanzarError(e);
            return false;
        }
        return true;
    }

    public boolean borrar() {
        if (archivo.delete()) {
            System.out.println("Se ha borrado el archivo: " + archivo.getName());
            return true;
        }
        System.err.println("ERROR: No se ha podido borrar el archivo");
        return false;
    }
}