package org.example;

public abstract class Usuario {
    protected long idUsuario;
    public Usuario() {}
    public abstract void buscarJuegoPorNombre(String nombre);
    public abstract void filtrarJuegos(String filtro);
}
