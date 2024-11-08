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

    public void conseguirJuegos() {
        ArrayList juegosObtenidos =creadorJuegos.crearJuegosDesdeApi();
        if (juegosObtenidos.isEmpty()){
            System.out.println("Primero se tienen que ingresar las ID al catálogo");
        }else {
            listaJuegos.addAll(juegosObtenidos);
        }
        
    }

    public void ingresarJuego(Juego juego){
        if (listaJuegos.contains(juego)){
            System.out.println("El juego ya se encuentra en el catalogo");
        }else {
            listaJuegos.add(juego);
        }
    }

    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void mostrarCatalogo(){
        if (listaJuegos.isEmpty()) {
            System.out.println("El catálogo está vacío de momento");
        } else {
            for (Juego juego : listaJuegos) {
                System.out.println("-----------------------------------------------------------------------------------------");
                juego.mostrarDetalles();
            }
        }
    }

}

