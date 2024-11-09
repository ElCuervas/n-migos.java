package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PerfilTest {
    private Perfil perfil;
    private UsuarioRegistrado usuario;

    private final ByteArrayOutputStream ContenidoSystem = new ByteArrayOutputStream();

    @BeforeEach
    void setUP(){
        usuario = new UsuarioRegistrado(1,"juanito", "22123");
        System.setOut(new PrintStream(ContenidoSystem));
    }
    @Test
    void CrearPerfiles() {
        Perfil perfil = new Perfil(usuario);
    }
    @Test
    void MostrarInformacion(){
        Perfil perfil = new Perfil(usuario);
        perfil.mostrarInformacion();
        String MostratUsuario = "Mostrando información del perfil del usuario: " + usuario.toString() + System.lineSeparator();
        assertEquals(MostratUsuario, ContenidoSystem.toString());
    }
}