package lanzador;

import modelo.Persona;

public class App {

    public static void main(String[] args) {

        Persona juan = Persona.accederaManejo("leer");
        System.out.println(juan.getAmigos().get(0).toString());
    }
}
