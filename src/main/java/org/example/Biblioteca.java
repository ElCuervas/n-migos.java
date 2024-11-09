package org.example;
import java.util.ArrayList;
/**
 * Clase que representa una biblioteca de juegos, la cual almacena y gestiona
 * una colección de juegos.
 */
public class Biblioteca {

    /**
     * Lista de juegos en la biblioteca.
     */
    private ArrayList<Juego> juegos;

    /**
     * Constructor que inicializa una biblioteca vacía.
     */
    public Biblioteca() {
        this.juegos = new ArrayList<>();
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    /**
     * Agrega un juego a la biblioteca.
     *
     * @param juego El juego que se desea agregar a la biblioteca.
     */
    public void  agregarJuego(Juego juego) {
        juegos.add(juego);
        System.out.println("Juego agregado a la biblioteca: " + juego.getTitulo());
    }

    /**
     * Elimina un juego de la biblioteca.
     *
     * @param juego El juego que se desea eliminar de la biblioteca.
     */
    public void eliminarJuego(Juego juego) {
        juegos.remove(juego);
        System.out.println("main.java.org.example.Juego eliminado de la biblioteca: " + juego.getTitulo());
    }

    /**
     * Devuelve una representación en forma de cadena de la biblioteca,
     * que incluye los títulos de todos los juegos.
     *
     * @return Una cadena con los títulos de los juegos en la biblioteca.
     */
    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < juegos.size(); i++) {
            mensaje.append(" \n").append(juegos.get(i).getTitulo());
        }
        return "Biblioteca:" +
                  mensaje;
    }
}
