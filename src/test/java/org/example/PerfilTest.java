package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void CrearPerfil() {
        Perfil perfil = new Perfil(usuario);
        assertNotNull(perfil, "La clase perfil no fue creada correctamente");
    }
    @Test
    void MostrarInformacion(){
        Perfil perfil = new Perfil(usuario);
        perfil.mostrarInformacion();
        String MostratUsuario = "Mostrando información del perfil del usuario: " + usuario.toString() + System.lineSeparator();
        assertEquals(MostratUsuario, ContenidoSystem.toString());
    }
}