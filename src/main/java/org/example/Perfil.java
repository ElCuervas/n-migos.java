package org.example;

/**
 * La clase Perfil representa el perfil de un usuario registrado en una biblioteca.
 * Contiene la información del usuario y su biblioteca asociada, y ofrece
 * funcionalidades para mostrar y editar la información del perfil.
 */
public class Perfil {
    private UsuarioRegistrado usuario;
    private Biblioteca biblioteca;

    /**
     * Constructor para crear un nuevo perfil basado en un usuario registrado.
     * La biblioteca asociada se obtiene a partir del usuario proporcionado.
     *
     * @param usuario El usuario registrado al que pertenece este perfil.
     */
    public Perfil(UsuarioRegistrado usuario) {
        this.usuario = usuario;
        this.biblioteca = usuario.getBiblioteca();
    }

    /**
     * Muestra la información del perfil del usuario.
     * Actualmente, imprime la información del usuario en la consola.
     */
    public void mostrarInformacion() {
        System.out.println("Mostrando información del perfil del usuario: " + usuario.toString());
    }

    /**
     * Permite editar la información del perfil del usuario.
     * Actualmente, imprime un mensaje indicando que se está editando la información.
     */
    public void editarInformacion() {
        System.out.println("Editando información del perfil del usuario: " + usuario);
    }
}

