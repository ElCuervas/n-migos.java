package org.example;

import java.time.LocalDateTime;

/**
 * La clase {@code Resena} representa una reseña de un juego realizada por un usuario registrado.
 * Contiene el texto de la reseña, la fecha de creación y el estado de si ha sido eliminada.
 */
public class Resena {

    /**
     * Usuario registrado que creó la reseña.
     */
    private UsuarioRegistrado usuario;

    /**
     * Texto de la reseña.
     */
    private String texto;

    /**
     * Fecha y hora en la que fue creada la reseña.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Indica si la reseña ha sido eliminada.
     */
    private boolean eliminada;

    /**
     * Constructor que crea una nueva reseña asociada a un usuario registrado.
     * 
     * @param usuario El usuario que escribe la reseña.
     * @param texto   El contenido de la reseña. No puede estar vacío.
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
     * Devuelve el usuario que creó la reseña.
     * 
     * @return El usuario registrado que escribió la reseña.
     */
    public UsuarioRegistrado getUsuario() {
        return usuario;
    }

    /**
     * Devuelve el texto de la reseña. Si la reseña ha sido eliminada, devuelve un mensaje
     * indicando que la reseña ha sido eliminada.
     * 
     * @return El texto de la reseña o un mensaje indicando que ha sido eliminada.
     */
    public String getTexto() {
        if (eliminada) {
            return "Esta reseña ha sido eliminada.";
        }
        return texto;
    }

    /**
     * Devuelve la fecha en la que fue creada la reseña.
     * 
     * @return La fecha de creación de la reseña.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Permite editar el texto de la reseña siempre y cuando esta no haya sido eliminada.
     * 
     * @param nuevoTexto El nuevo texto para la reseña. No puede estar vacío.
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
     * Elimina la reseña marcándola como eliminada. Si la reseña ya había sido eliminada,
     * se muestra un mensaje indicando que ya estaba eliminada.
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
     * Indica si la reseña ha sido eliminada.
     * 
     * @return {@code true} si la reseña ha sido eliminada, de lo contrario {@code false}.
     */
    public boolean esEliminada() {
        return eliminada;
    }
}
