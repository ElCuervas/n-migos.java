package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRegistradoTest {

    static UsuarioRegistrado usuarioRegistrado;
    static Juego juegoTest;



    @BeforeAll
    static void setUpBeforeClass(){
        usuarioRegistrado = new UsuarioRegistrado(1,"Test","123",true);
        juegoTest = new Juego("Titulo1", "2022", "Accion", "Desarrollador1", "url_imagen", "Descripción breve");

    }

    @Test
    void testIniciarSesion() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        usuarioRegistrado.iniciarSesion("123");

        assertEquals("Iniciando sesión para el usuario: Test\r\n",outContent.toString());

        System.setOut(System.out);
    }
    @Test
    void testIniciarSesionClaveIncorrecta() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        usuarioRegistrado.iniciarSesion("1234");

        assertEquals("contrasena no valida", outContent.toString().trim());

        System.setOut(System.out);
    }

    @Test
    void testAgregarJuegoBiblioteca() {
        usuarioRegistrado.agregarJuegoBiblioteca(juegoTest);
        assertFalse(usuarioRegistrado.getBiblioteca().getJuegos().isEmpty());
    }
    @Test
    void testEliminarJuegoBiblioteca() {
        usuarioRegistrado.eliminarJuegoBiblioteca(juegoTest);
        assertTrue(usuarioRegistrado.getBiblioteca().getJuegos().isEmpty());
    }

    @Test
    void testDejarResena(){
        usuarioRegistrado.dejarResena(juegoTest,"Resena Test");
        assertFalse(juegoTest.getResenas().isEmpty());
    }
    @Test
    void testDejarResenaVacia(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> usuarioRegistrado.dejarResena(juegoTest, "")
        );
        assertEquals("El texto de la reseña no puede estar vacío.", exception.getMessage());
    }
    @Test
    void testEliminarResena(){
        usuarioRegistrado.eliminarResena(juegoTest,juegoTest.getResenas().get(0));
        assertTrue(juegoTest.getResenas().isEmpty());
    }
    @Test
    void testPuntuarJuego(){
        usuarioRegistrado.puntuarJuego(juegoTest,1);
        assertEquals(1,juegoTest.getCalificacion());
    }
}