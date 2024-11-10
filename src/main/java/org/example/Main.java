package org.example;
public class Main {
    public static void main(String[] args) {
        //pruebas catalogo
        Catalogo catalogo = new Catalogo();
        catalogo.mostrarCatalogo();
        catalogo.conseguirJuegos();
        catalogo.getCreadorJuegos().conseguirIDs();
        catalogo.conseguirJuegos();
        catalogo.mostrarCatalogo();

        //pruebas usuario y perfil
        UsuarioRegistrado usuario1 = new UsuarioRegistrado(1,"juanito", "22123", true);
        Perfil perfil1 = new Perfil(usuario1);
        perfil1.mostrarInformacion();

        //pruebas biblioteca
        Biblioteca biblioteca = new Biblioteca();
        Juego juego1 = catalogo.getListaJuegos().get(0);
        Juego juego2 = catalogo.getListaJuegos().get(2);
        Juego juego3 = catalogo.getListaJuegos().get(6);
        biblioteca.agregarJuego(juego1);
        biblioteca.agregarJuego(juego2);
        biblioteca.agregarJuego(juego3);
        System.out.println(biblioteca);
    }
}
