package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoPostReacTest {
    private Catalogo catalogo;
    private CreadorJuegos creadorJuegos;
    private ConsultorApi consultorApi;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        creadorJuegos = new CreadorJuegos();
        consultorApi = new ConsultorApi();
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
        consultorApi.ingresarID(123);
        consultorApi.ingresarID(123); // Intentamos agregar la misma ID otra vez
        assertEquals(1, consultorApi.getGameIDs().size()); // La ID no debe duplicarse
    }

    @Test
    void testConseguirIDs() {
        // Simulamos la obtención de IDs de la API
        consultorApi.conseguirIDs();
        assertFalse(consultorApi.getGameIDs().isEmpty()); // Verificamos que la lista de IDs no esté vacía después de la llamada
    }

    @Test
    void testConseguirJuegos() {

        // Ejecutamos el método para conseguir los juegos
        catalogo.conseguirJuegos();
        int largoCatalogo = catalogo.getListaJuegos().size();
        // Verificamos que los juegos fueron añadidos
        assertTrue(largoCatalogo > 0 && largoCatalogo <= 10);
    }
}
