package org.example;

import java.util.ArrayList;
/**
 * La clase Juego representa un juego con atributos como título, género, desarrollador,
 * imagen, resumen, calificación y una lista de reseñas.
 * Proporciona métodos para gestionar la información del juego y las reseñas asociadas.
 */
public class Juego {
    private String titulo;
    private String lanzamieto;
    private String genero;
    private String desarrollador;
    private String imagen;
    private String resumen;
    private float calificacion;
    private ArrayList<Resena> resenas;
    /**
     * Crea una nueva instancia de Juego con los detalles proporcionados.
     * La calificación se inicializa en 0 y la lista de reseñas se crea vacía.
     *
     * @param titulo el título del juego
     * @param genero el género del juego
     * @param desarrollador el desarrollador del juego
     * @param imagen la ruta o URL de la imagen asociada al juego
     * @param resumen una breve descripción del juego
     */
    public Juego(String titulo, String lanzamiento, String genero, String desarrollador, String imagen, String resumen) {
        this.titulo = titulo;
        this.lanzamieto = lanzamiento;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.imagen = imagen;
        this.resumen = resumen;
        this.calificacion = 0;
        this.resenas = new ArrayList<>();
    }

    public ArrayList<Resena> getResenas() {
        return resenas;
    }

    public float getCalificacion() {
        return calificacion;
    }

    /**
     * Obtiene el título del juego.
     *
     * @return el título del juego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece la calificación del juego.
     *
     * @param calificacion la nueva calificación del juego
     */
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Agrega una nueva reseña a la lista de reseñas del juego.
     *
     * @param resena la reseña a agregar
     */
    public void agregarResena(Resena resena) {
        resenas.add(resena);
    }

    /**
     * Elimina una reseña existente de la lista de reseñas del juego.
     *
     * @param resena la reseña a eliminar
     */
    public void eliminarResena(Resena resena) {
        resenas.remove(resena);
    }

    /**
     * Muestra los detalles del juego, incluyendo título, género, desarrollador y calificación.
     */
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Desarrollador: " + desarrollador);
        System.out.println("Calificación: " + calificacion);
        System.out.println("Url de Imagen: "+ imagen);
    }

}
