package org.example;

import java.util.ArrayList;

/**
 * Clase que representa un usuario dentro del sistema.
 * Dependiendo de si el usuario está registrado o no, puede acceder a diferentes funcionalidades.
 */
public class UsuarioRegistrado extends Usuario {

    private String nombre;
    private String contrasena;
    private ArrayList<String> generoFavorito;
    private Biblioteca biblioteca;
    private boolean estaRegistrado;

    /**
     * Constructor para usuario registrado.
     *
     * @param idUsuario   Identificador único del usuario.
     * @param nombre      Nombre del usuario.
     * @param contrasena  contrasena del usuario.
     * @param estaRegistrado Booleano que indica si el usuario está registrado.
     */
    public UsuarioRegistrado(long idUsuario, String nombre, String contrasena, boolean estaRegistrado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.generoFavorito = new ArrayList<>();
        this.biblioteca = new Biblioteca();
        this.estaRegistrado = estaRegistrado;
    }

    /**
     * Método para registrar el usuario.
     */
    public void registrar() {
        if (!estaRegistrado) {
            System.out.println("Registrando usuario...");
            estaRegistrado = true;
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }

    /**
     * Método para iniciar sesión.
     *
     * @param contrasena contrasena ingresada por el usuario.
     */
    public void iniciarSesion(String contrasena) {
        if (!estaRegistrado) {
            System.out.println("Usuario no registrado, no puede iniciar sesión.");
            return;
        }
        if (this.contrasena.equals(contrasena)) {
            System.out.println("Iniciando sesión para el usuario: " + nombre);
        } else {
            System.out.println("contrasena no valida");
        }
    }

    /**
     * Permite iniciar sesión como invitado.
     */
    public void iniciarComoInvitado() {
        if (estaRegistrado) {
            System.out.println("El usuario ya está registrado, no puede iniciar como invitado.");
        } else {
            System.out.println("Iniciando sesión como invitado...");
        }
    }

    /**
     * Agrega un juego a la biblioteca del usuario.
     *
     * @param juego Juego a agregar.
     */
    public void agregarJuegoBiblioteca(Juego juego) {
        if (estaRegistrado) {
            biblioteca.agregarJuego(juego);
        } else {
            System.out.println("Usuario no registrado. No tiene permisos para agregar juegos a la biblioteca.");
        }
    }

    /**
     * Elimina un juego de la biblioteca del usuario.
     *
     * @param juego Juego a eliminar.
     */
    public void eliminarJuegoBiblioteca(Juego juego) {
        if (estaRegistrado) {
            biblioteca.eliminarJuego(juego);
        } else {
            System.out.println("Usuario no registrado. No tiene permisos para eliminar juegos de la biblioteca.");
        }
    }

    /**
     * Puntúa un juego en la biblioteca del usuario.
     *
     * @param juego      Juego a puntuar.
     * @param puntuacion Puntuación que se le asigna al juego.
     */
    public void puntuarJuego(Juego juego, float puntuacion) {
        if (estaRegistrado) {
            juego.setCalificacion(puntuacion);
        } else {
            System.out.println("Usuario no registrado. No tiene permisos para puntuar juegos.");
        }
    }

    /**
     * Deja una reseña para un juego en la biblioteca del usuario.
     *
     * @param juego  Juego sobre el cual dejar la reseña.
     * @param resena Contenido de la reseña.
     */
    public void dejarResena(Juego juego, String resena) {
        if (estaRegistrado) {
            if (resena.isEmpty()) {
                throw new IllegalArgumentException("El texto de la reseña no puede estar vacío.");
            }
            Resena nuevaResena = new Resena(this, resena);
            juego.agregarResena(nuevaResena);
        } else {
            System.out.println("Usuario no registrado. No tiene permisos para dejar reseñas.");
        }
    }

    /**
     * Elimina una reseña de un juego en la biblioteca del usuario.
     *
     * @param juego  Juego del cual eliminar la reseña.
     * @param resena Reseña a eliminar.
     */
    public void eliminarResena(Juego juego, Resena resena) {
        if (estaRegistrado) {
            juego.eliminarResena(resena);
        } else {
            System.out.println("Usuario no registrado. No tiene permisos para eliminar reseñas.");
        }
    }

    /**
     * Busca un juego por su nombre.
     *
     * @param nombre Nombre del juego a buscar.
     */
    @Override
    public void buscarJuegoPorNombre(String nombre) {
        System.out.println("Buscando juego: " + nombre);
    }

    /**
     * Filtra los juegos según un criterio específico.
     *
     * @param filtro Criterio de filtro a aplicar.
     */
    @Override
    public void filtrarJuegos(String filtro) {
        System.out.println("Filtrando juegos con filtro: " + filtro);
    }

    /**
     * Método para obtener la biblioteca del usuario.
     *
     * @return la biblioteca del usuario.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
}
