package org.example;
import java.util.ArrayList;

/**
 * Clase que representa un usuario registrado dentro del sistema.
 * Hereda de la clase {@link Usuario} y permite gestionar las acciones
 * de un usuario como iniciar sesión, administrar su biblioteca de juegos,
 * puntuar juegos y dejar reseñas.
 */
public class UsuarioRegistrado extends Usuario {

    /**
     * Nombre del usuario registrado.
     */
    private String nombre;

    /**
     * Contraseña del usuario registrado.
     */
    private String contraseña;

    /**
     * Lista de géneros favoritos del usuario.
     */
    private ArrayList<String> generoFavorito;

    /**
     * Biblioteca asociada al usuario donde se almacenan sus juegos.
     */
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase UsuarioRegistrado.
     *
     * @param idUsuario   Identificador único del usuario.
     * @param nombre      Nombre del usuario.
     * @param contraseña  Contraseña del usuario.
     */
    public UsuarioRegistrado(long idUsuario, String nombre, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.generoFavorito = new ArrayList<>();
        this.biblioteca = new Biblioteca();
    }

    /**
     * Método para iniciar sesión del usuario comparando la contraseña ingresada.
     *
     * @param contraseña Contraseña ingresada por el usuario.
     */
    public void iniciarSesion(String contraseña) {
        if (this.contraseña == contraseña) {
            System.out.println("Iniciando sesión para el usuario: " + nombre);
        }else{
            System.out.printf("Contraseña no valida");
        }
    }

    /**
     * Obtiene la biblioteca asociada al usuario.
     *
     * @return La biblioteca del usuario.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Agrega un juego a la biblioteca del usuario.
     *
     * @param juego Juego a agregar.
     */
    public void agregarJuegoBiblioteca(Juego juego) {
        biblioteca.agregarJuego(juego);
    }

    /**
     * Elimina un juego de la biblioteca del usuario.
     *
     * @param juego Juego a eliminar.
     */
    public void eliminarJuegoBiblioteca(Juego juego) {
        biblioteca.eliminarJuego(juego);
    }

    /**
     * Puntúa un juego en la biblioteca del usuario.
     *
     * @param juego      Juego a puntuar.
     * @param puntuacion Puntuación que se le asigna al juego.
     */
    public void puntuarJuego(Juego juego, float puntuacion) {
        juego.setCalificacion(puntuacion);
    }

    /**
     * Deja una reseña para un juego en la biblioteca del usuario.
     *
     * @param juego  Juego sobre el cual dejar la reseña.
     * @param resena Contenido de la reseña.
     */
    public void dejarResena(Juego juego, String resena) {
        Resena nuevaResena = new Resena(this, resena);
        juego.agregarResena(nuevaResena);
    }

    /**
     * Elimina una reseña de un juego en la biblioteca del usuario.
     *
     * @param juego  Juego del cual eliminar la reseña.
     * @param resena Reseña a eliminar.
     */
    public void eliminarResena(Juego juego, Resena resena) {
        juego.eliminarResena(resena);
    }

    /**
     * Busca un juego en la biblioteca del usuario por su nombre.
     *
     * @param nombre Nombre del juego a buscar.
     */
    @Override
    public void buscarJuegoPorNombre(String nombre) {
        System.out.println("Buscando juego en la biblioteca del usuario: " + nombre);
    }

    /**
     * Filtra los juegos en la biblioteca del usuario según un criterio.
     *
     * @param filtro Criterio de filtro a aplicar.
     */
    @Override
    public void filtrarJuegos(String filtro) {
        System.out.println("Filtrando juegos en la biblioteca del usuario: " + filtro);
    }

}