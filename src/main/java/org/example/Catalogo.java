package org.example;

import java.util.ArrayList;

/**
 * Clase que representa un catálogo de juegos. Permite gestionar una lista de juegos y crear mas intancias de juego
 */
public class Catalogo {
    private final ArrayList<Juego> listaJuegos;
    private final CreadorJuegos creadorJuegos;

    public Catalogo() {
        listaJuegos = new ArrayList<>();
        creadorJuegos = new CreadorJuegos();
    }

    public void llenarCatalogoConJuegos() {
        listaJuegos.addAll(creadorJuegos.crearJuegosDesdeApi());
    }

    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void mostrarCatalogo(){
        for (Juego juego : listaJuegos){
            System.out.println("-----------------------------------------------------------------------------------------");
            juego.mostrarDetalles();
        }
    }

}

