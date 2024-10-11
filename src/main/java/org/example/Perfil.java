package org.example;

public class Perfil {
    private UsuarioRegistrado usuario;
    private Biblioteca biblioteca;

    public Perfil(UsuarioRegistrado usuario, Biblioteca biblioteca) {
        this.usuario = usuario;
        this.biblioteca = biblioteca;
    }

    public void mostrarInformacion() {
        System.out.println("Mostrando información del perfil del usuario: " + usuario);
    }

    public void editarInformacion() {
        System.out.println("Editando información del perfil del usuario: " + usuario);
    }
}
