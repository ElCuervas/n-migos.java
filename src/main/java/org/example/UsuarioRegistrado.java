package org.example;
import java.util.ArrayList;

public class UsuarioRegistrado extends Usuario {
    private

    String nombre;
    private String contraseña;
    private ArrayList<String> generoFavorito;
    private Biblioteca biblioteca;

    public UsuarioRegistrado(long idUsuario, String nombre, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.generoFavorito = new ArrayList<>();
        this.biblioteca = new Biblioteca();
    }

    public void iniciarSesion(String contraseña) {
        if (this.contraseña == contraseña) {
            System.out.println("Iniciando sesión para el usuario: " + nombre);
        }else{
            System.out.printf("Contraseña no valida");
        }
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void agregarJuegoBiblioteca(Juego juego) {
        biblioteca.agregarJuego(juego);
    }

    public void eliminarJuegoBiblioteca(Juego juego) {
        biblioteca.eliminarJuego(juego);
    }

    public void puntuarJuego(Juego juego, float puntuacion) {
        juego.setCalificacion(puntuacion);
    }

    public void dejarResena(Juego juego, String resena) {
        Resena nuevaResena = new Resena(this, resena);
        juego.agregarResena(nuevaResena);
    }

    public void eliminarResena(Juego juego, Resena resena) {
        juego.eliminarResena(resena);
    }

    @Override
    public void buscarJuegoPorNombre(String nombre) {
        System.out.println("Buscando juego en la biblioteca del usuario: " + nombre);
    }

    @Override
    public void filtrarJuegos(String filtro) {
        System.out.println("Filtrando juegos en la biblioteca del usuario: " + filtro);
    }

}