package org.example;

/**
 * La clase PerfilUsuario representa la información de un usuario registrado.
 * Contiene métodos para mostrar la información del usuario sin depender
 * directamente de su biblioteca.
 */
public class Perfil {
    private UsuarioRegistrado usuario;

    /**
     * Constructor para crear un nuevo perfil de usuario basado en un usuario registrado.
     *
     * @param usuario El usuario registrado al que pertenece este perfil.
     */
    public Perfil(UsuarioRegistrado usuario) {
        this.usuario = usuario;
    }

    /**
     * Muestra la información del perfil del usuario.
     * Llama al método correspondiente en UsuarioRegistrado para obtener la información.
     */
    public void mostrarInformacion() {
        System.out.println("Mostrando información del perfil del usuario: " + usuario.toString());
    }
}