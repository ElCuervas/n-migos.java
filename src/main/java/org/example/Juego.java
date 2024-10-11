package org.example;

import java.util.ArrayList;

public class Juego {
    private String titulo;
    private String lanzamieto;
    private String genero;
    private String desarrollador;
    private String imagen;
    private String resumen;
    private float calificacion;
    private ArrayList<Resena> resenas;

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

    public String getTitulo() {
        return titulo;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public void agregarResena(Resena resena) {
        resenas.add(resena);
    }

    public void eliminarResena(Resena resena) {
        resenas.remove(resena);
    }

    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Desarrollador: " + desarrollador);
        System.out.println("Calificación: " + calificacion);
        System.out.println("Url de Imagen: "+ imagen);
    }
}
