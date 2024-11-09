package org.example;

import java.util.ArrayList;

/**
 * Clase que representa un catálogo de juegos. Permite gestionar una lista de juegos y crear más instancias de juego.
 */
public class Catalogo {
    private final ArrayList<Juego> listaJuegos;
    private final CreadorJuegos creadorJuegos;

    /**
     * Constructor que inicializa el catálogo con una lista vacía de juegos y un creador de juegos.
     */
    public Catalogo() {
        listaJuegos = new ArrayList<>();
        creadorJuegos = new CreadorJuegos();
    }

    /**
     * Obtiene juegos desde una fuente externa y los agrega a la lista de juegos en el catálogo.
     */
    public void conseguirJuegos() {
        listaJuegos.addAll(creadorJuegos.crearJuegosDesdeApi());
    }

    /**
     * Agrega un juego al catálogo si no está presente. Si el juego ya existe, muestra un mensaje.
     *
     * @param juego El juego a agregar al catálogo.
     */
    public void ingresarJuego(Juego juego) {
        if (listaJuegos.contains(juego)) {
            System.out.println("El juego ya se encuentra en el catálogo");
        } else {
            listaJuegos.add(juego);
        }
    }

    /**
     * Obtiene la lista de juegos actualmente en el catálogo.
     *
     * @return La lista de juegos en el catálogo.
     */
    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    /**
     * Muestra los detalles de cada juego en el catálogo. Si el catálogo está vacío, muestra un mensaje.
     */
    public void mostrarCatalogo() {
        if (listaJuegos.isEmpty()) {
            System.out.println("El catálogo está vacío de momento");
        } else {
            for (Juego juego : listaJuegos) {
                System.out.println("-----------------------------------------------------------------------------------------");
                juego.mostrarDetalles();
            }
        }
    }

    /**
     * Obtiene el objeto creador de juegos asociado a este catálogo.
     *
     * @return El creador de juegos.
     */
    public CreadorJuegos getCreadorJuegos() {
        return creadorJuegos;
    }
}
