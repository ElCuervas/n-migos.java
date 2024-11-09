package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoPostReacTest {
    private Catalogo catalogo;
    private CreadorJuegos creadorJuegos;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        creadorJuegos = catalogo.getCreadorJuegos();
    }

    @Test
    void testIngresarJuego() {
        Juego juego = new Juego("Titulo1", "2022", "Accion", "Desarrollador1", "url_imagen", "Descripción breve");
        catalogo.ingresarJuego(juego);
        assertEquals(1, catalogo.getListaJuegos().size());
        assertEquals("Titulo1", catalogo.getListaJuegos().get(0).getTitulo());
    }

    @Test
    void testIngresarID() {
        creadorJuegos.ingresarID(123);
        creadorJuegos.ingresarID(123); // Intentamos agregar la misma ID otra vez
        assertEquals(1, creadorJuegos.getGameIDs().size()); // La ID no debe duplicarse
    }

    @Test
    void testConseguirIDs() {
        // Simulamos la obtención de IDs de la API
        creadorJuegos.conseguirIDs();
        assertFalse(creadorJuegos.getGameIDs().isEmpty()); // Verificamos que la lista de IDs no esté vacía después de la llamada
    }

    @Test
    void testConseguirJuegos() {
        // Primero agregamos algunas IDs
        creadorJuegos.ingresarID(1);
        creadorJuegos.ingresarID(2);

        // Ejecutamos el método para conseguir los juegos
        catalogo.conseguirJuegos();

        // Verificamos que los juegos fueron añadidos
        assertFalse(catalogo.getListaJuegos().isEmpty());
    }
}
