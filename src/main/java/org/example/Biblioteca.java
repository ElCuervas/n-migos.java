package org.example;
import java.util.ArrayList;
public class Biblioteca {
    private ArrayList<Juego> juegos;

    public Biblioteca() {
        this.juegos = new ArrayList<>();
    }
    public void  agregarJuego(Juego juego) {
        juegos.add(juego);
        System.out.println("Juego agregado a la biblioteca: " + juego.getTitulo());
    }

    public void eliminarJuego(Juego juego) {
        juegos.remove(juego);
        System.out.println("main.java.org.example.Juego eliminado de la biblioteca: " + juego.getTitulo());
    }

    public ArrayList<Juego> obtenerJuegos() {
        return juegos;
    }
}
