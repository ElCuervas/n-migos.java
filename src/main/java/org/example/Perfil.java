package org.example;

public class Perfil {
    private UsuarioRegistrado usuario;
    private Biblioteca biblioteca;

    public Perfil(UsuarioRegistrado usuario) {
        this.usuario = usuario;
        this.biblioteca = usuario.getBiblioteca();
    }

    public void mostrarInformacion() {
        System.out.println("Mostrando información del perfil del usuario: " + usuario.toString());
    }

    public void editarInformacion() {
        System.out.println("Editando información del perfil del usuario: " + usuario);
    }
}
