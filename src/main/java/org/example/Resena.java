package org.example;

import java.time.LocalDateTime;

/**
 * La clase Resena representa una reseña creada por un usuario registrado, que contiene un texto,
 * una fecha de creación y un estado que indica si ha sido eliminada.
 */
public class Resena {
    private UsuarioRegistrado usuario;
    private String texto;
    private LocalDateTime fechaCreacion;
    private boolean eliminada;

    /**
     * Constructor de la clase Resena. Crea una nueva reseña con el usuario que la realizó y el texto asociado.
     * La fecha de creación se inicializa con el momento actual, y el estado de eliminación es false por defecto.
     *
     * @param usuario El usuario que crea la reseña. Debe ser un objeto de tipo UsuarioRegistrado.
     * @param texto El contenido de la reseña. No puede ser nulo ni estar vacío.
     * @throws IllegalArgumentException Si el texto de la reseña es nulo o está vacío.
     */
    public Resena(UsuarioRegistrado usuario, String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El texto de la reseña no puede estar vacío.");
        }
        this.usuario = usuario;
        this.texto = texto;
        this.fechaCreacion = LocalDateTime.now();
        this.eliminada = false;
    }

    /**
     * Obtiene el usuario que realizó la reseña.
     *
     * @return El usuario que creó la reseña.
     */
    public UsuarioRegistrado getUsuario() {
        return usuario;
    }

    /**
     * Obtiene el texto de la reseña. Si la reseña ha sido eliminada, retorna un mensaje indicándolo.
     *
     * @return El texto de la reseña, o un mensaje si ha sido eliminada.
     */
    public String getTexto() {
        if (eliminada) {
            return "Esta reseña ha sido eliminada.";
        }
        return texto;
    }

    /**
     * Obtiene la fecha en que se creó la reseña.
     *
     * @return La fecha de creación de la reseña.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Edita el texto de la reseña si no ha sido eliminada. Si la reseña ya está eliminada, no se puede modificar.
     *
     * @param nuevoTexto El nuevo contenido de la reseña. No puede ser nulo ni estar vacío.
     * @throws IllegalArgumentException Si el nuevo texto es nulo o está vacío.
     */
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

    /**
     * Elimina la reseña, cambiando su estado a eliminada. Una reseña eliminada no se puede modificar.
     * Si ya estaba eliminada, muestra un mensaje indicando que ya estaba eliminada.
     */
    public void eliminar() {
        if (!eliminada) {
            this.eliminada = true;
            System.out.println("Reseña eliminada.");
        } else {
            System.out.println("Esta reseña ya había sido eliminada.");
        }
    }

    /**
     * Indica si la reseña ha sido eliminada o no.
     *
     * @return true si la reseña ha sido eliminada, false en caso contrario.
     */
    public boolean esEliminada() {
        return eliminada;
    }
}
