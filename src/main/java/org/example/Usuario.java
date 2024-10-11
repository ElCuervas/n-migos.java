package org.example;

public abstract class Usuario {
    protected long idUsuario;
    public Usuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public abstract void buscarJuegoPorNombre(String nombre);
    public abstract void filtrarJuegos(String filtro);
}
