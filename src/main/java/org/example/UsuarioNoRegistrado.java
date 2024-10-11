package org.example;

public class UsuarioNoRegistrado extends Usuario {

    public UsuarioNoRegistrado(long idUsuario) {
        super(idUsuario);
    }

    public void registrar() {
        System.out.println("Registrando usuario...");
    }

    public void iniciarComoInvitado() {
        System.out.println("Iniciando sesión como invitado...");
    }

    @Override
    public void buscarJuegoPorNombre(String nombre) {
        System.out.println("Buscando juego por nombre: " + nombre);
    }

    @Override
    public void filtrarJuegos(String filtro) {
        System.out.println("Filtrando juegos con filtro: " + filtro);
    }
}
