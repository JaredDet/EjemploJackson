package modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Perro {

    private String nombre;
    private int edad;
    private String identificador;

    @JsonBackReference
    private Persona amo;

    public Perro(String nombre, int edad, String identificador, Persona amo){
        this.nombre = nombre;
        this.edad = edad;
        this.identificador = identificador;
        this.amo = amo;
    }

    public Perro(String nombre, int edad, String identificador){
        this.nombre = nombre;
        this.edad = edad;
        this.identificador = identificador;
    }

    public Perro(){

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

    @Override
    public String toString() {
        return "nombre: " + nombre + ", edad: " + edad + ", identificador: " + identificador + ", amo: " + amo.getNombre() +"; " + amo.getRut();
    }
}
