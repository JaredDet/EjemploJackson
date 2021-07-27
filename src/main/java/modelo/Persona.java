package modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import datos.ManejoDatos;
import errores.LanzadorMensaje;

import java.util.ArrayList;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "rut")

public class Persona {

    private String nombre;
    private int edad;
    private String rut;
    private final String universidad = "UFRO";

    private final ArrayList<Persona> amigos = new ArrayList<>();

    @JsonManagedReference
    private final ArrayList<Animal> mascotas;

    public Persona(String nombre, int edad, String rut) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
        mascotas = new ArrayList<>();
    }

    public Persona() {
        mascotas = new ArrayList<>();
    }

    public ArrayList<Persona> getAmigos() {
        return amigos;
    }

    public void addAmigos(Persona amigo) {
        amigos.add(amigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getUniversidad() {
        return universidad;
    }

    public ArrayList<Animal> getMascotas() {
        return mascotas;
    }

    public void addMascotas(Animal mascota) {
        mascotas.add(mascota);
    }

    private void borrarMascota(Animal mascota){
        mascotas.remove(mascota);
    }
    public void manejoBorrarMascota(Animal mascota){
        if(mascotas.contains(mascota)){
            borrarMascota(mascota);
        }else{
            LanzadorMensaje.lanzarNoSeHaEncontradoLaMascota();
        }
    }

    private void borrarAmigo(Persona amigo){
        amigos.remove(amigo);
    }
    public void manejoBorrarAmigo(Persona amigo){
        if(amigos.contains(amigo)){
            borrarAmigo(amigo);
        }else{
            LanzadorMensaje.lanzarNoSeHaEncontradoLaMascota();
        }
    }

    public static Persona accederaManejo(String opcion) {

        ManejoDatos manejo = new ManejoDatos("src/main/resources/recursos.txt");
        Persona persona = null;

        switch (opcion) {
            case "create" -> manejo.manejoCrear();
            case "leer" -> persona = (Persona) manejo.manejoLeer("modelo.Persona");
            case "borrar" -> manejo.borrar();
            default -> LanzadorMensaje.lanzarEntradaNoValida();
        }
        return persona;
    }

    public void accederaManejo(String opcion, Persona persona) {

        ManejoDatos manejo = new ManejoDatos("src/main/resources/recursos.txt");

        switch (opcion) {
            case "create" -> manejo.manejoCrear();
            case "actualizar" -> manejo.manejoActualizar(persona);
            case "borrar" -> manejo.borrar();
            default -> LanzadorMensaje.lanzarEntradaNoValida();
        }
    }

    private String toStringAmigo() {

        StringBuilder builder = new StringBuilder();

        for(Persona amigo: amigos){
            builder.append(" Nombre: ").append(amigo.getNombre()).append("; ").append("Edad: ").append(amigo.getEdad()).append("; ").append("Mascotas: ").append(amigo.getMascotas()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "\n Nombre: " + nombre +
                "\n Edad: " + edad +
                "\n Rut: " + rut +
                "\n Universidad: " + universidad +
                "\n Mascotas: " + mascotas.toString().replace("[", "").replace("]", "") +
                "\n Amigos: \n" + toStringAmigo();
    }
}
