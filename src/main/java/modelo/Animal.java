package modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import utiilidades.Capitalize;

/**Herencia con Jackson**/
/*
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Perro.class, name = "perro"),
        @JsonSubTypes.Type(value = Gato.class, name = "gato")
})
*/

public class Animal {

    private String nombre;
    private int edad;
    private String identificador;
    private TipoAnimal tipo;

    @JsonBackReference
    private Persona amo;

    public Animal(String nombre, int edad, String identificador, Persona amo, String tipo){
        this.nombre = nombre;
        this.edad = edad;
        this.identificador = identificador;
        this.amo = amo;
        this.tipo = TipoAnimal.valueOf(tipo.toUpperCase());
    }

    public Animal(String nombre, int edad, String identificador, String tipo){
        this.nombre = nombre;
        this.edad = edad;
        this.identificador = identificador;
        this.tipo = TipoAnimal.valueOf(tipo.toUpperCase());
    }

    public Animal(){

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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Persona getAmo() {
        return amo;
    }

    public void setAmo(Persona amo) {
        this.amo = amo;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoAnimal.valueOf(tipo.toUpperCase());
    }

    @Override
    public String toString() {
        return "especie: " + Capitalize.capitalize(tipo.toString()) + ", nombre: " + nombre + ", edad: " + edad + ", identificador: " + identificador + ", amo: " + amo.getNombre() +"; " + amo.getRut();
    }
}
