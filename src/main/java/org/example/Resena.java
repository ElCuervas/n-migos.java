package org.example;

import java.time.LocalDateTime;

public class Resena {
    private UsuarioRegistrado usuario;
    private String texto;
    private LocalDateTime fechaCreacion;
    private boolean eliminada;

    public Resena(UsuarioRegistrado usuario, String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El texto de la reseña no puede estar vacío.");
        }
        this.usuario = usuario;
        this.texto = texto;
        this.fechaCreacion = LocalDateTime.now();
        this.eliminada = false;
    }

    public UsuarioRegistrado getUsuario() {
        return usuario;
    }

    public String getTexto() {
        if (eliminada) {
            return "Esta reseña ha sido eliminada.";
        }
        return texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void editarTexto(String nuevoTexto) {
        if (nuevoTexto == null || nuevoTexto.isBlank()) {
            throw new IllegalArgumentException("El nuevo texto no puede estar vacío.");
        }
        if (!eliminada) {
            this.texto = nuevoTexto;
        } else {
            System.out.println("No se puede editar una reseña eliminada.");
        }
    }

    public void eliminar() {
        if (!eliminada) {
            this.eliminada = true;
            System.out.println("Reseña eliminada.");
        } else {
            System.out.println("Esta reseña ya había sido eliminada.");
        }
    }

    public boolean esEliminada() {
        return eliminada;
    }
}
