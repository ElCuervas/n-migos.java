package org.example;
/**
 * La clase UsuarioNoRegistrado representa a un usuario que no está registrado
 * en el sistema. Este tipo de usuario puede buscar y filtrar juegos,
 * además de tener la opción de registrarse o iniciar sesión como invitado.
 */
public class UsuarioNoRegistrado extends Usuario {

    /**
     * Crea una nueva instancia de UsuarioNoRegistrado con un identificador único.
     *
     * @param idUsuario el identificador único del usuario
     */
    public UsuarioNoRegistrado(long idUsuario) {
        this.idUsuario= idUsuario;
    }

    /**
     * Permite registrar al usuario no registrado en el sistema.
     * Simula el proceso de registro mediante un mensaje en consola.
     */
    public void registrar() {
        System.out.println("Registrando usuario...");
    }

    /**
     * Inicia sesión como usuario invitado.
     * Simula el proceso de iniciar sesión como invitado mediante un mensaje en consola.
     */
    public void iniciarComoInvitado() {
        System.out.println("Iniciando sesión como invitado...");
    }

    /**
     * Busca un juego por su nombre. Implementación específica para un usuario no registrado.
     *
     * @param nombre el nombre del juego a buscar
     */
    @Override
    public void buscarJuegoPorNombre(String nombre) {
        System.out.println("Buscando juego por nombre: " + nombre);
    }

    /**
     * Filtra los juegos según un criterio específico. Implementación específica para un usuario no registrado.
     *
     * @param filtro el criterio utilizado para filtrar los juegos
     */
    @Override
    public void filtrarJuegos(String filtro) {
        System.out.println("Filtrando juegos con filtro: " + filtro);
    }
}
