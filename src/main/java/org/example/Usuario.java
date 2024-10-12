package org.example;

/**
 * La clase abstracta Usuario define los atributos y comportamientos básicos
 * que todos los tipos de usuarios deben implementar.
 * Un usuario tiene un identificador único y puede buscar juegos o filtrarlos.
 */
public abstract class Usuario {
    protected long idUsuario;

    /**
     * Constructor por defecto para la clase Usuario. No asigna ningún valor al identificador de usuario.
     */
    public Usuario() {}

    /**
     * Busca un juego por su nombre. Este método debe ser implementado por las
     * clases que extienden de Usuario.
     *
     * @param nombre el nombre del juego a buscar
     */
    public abstract void buscarJuegoPorNombre(String nombre);

    /**
     * Filtra los juegos según un criterio específico. Este método debe ser
     * implementado por las clases que extienden de Usuario.
     *
     * @param filtro el criterio utilizado para filtrar los juegos
     */
    public abstract void filtrarJuegos(String filtro);
}
