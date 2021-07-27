package lanzador;

import modelo.Animal;
import modelo.Persona;

public class App {

    public static void main(String[] args) {

        Persona vaquita = Persona.accederaManejo("leer");
        System.out.println(vaquita.toString());
    }
}