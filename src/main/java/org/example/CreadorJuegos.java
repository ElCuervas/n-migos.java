package org.example;

import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Clase creadora de juegos. Permite obtener información
 * de juegos y devolver instancias de {@link Juego}.
 */
public class CreadorJuegos {
    private final ConsultorApi consultorApi;
    private static ArrayList<Integer> gameIDs;
    /**
     * Constructor que inicializa el creador de juegos y crea una lista vacía de IDs de juegos.
     */
    public CreadorJuegos() {
        this.consultorApi = new ConsultorApi();
        gameIDs = new ArrayList<>();
    }

    /**
     * Crea y devuelve una lista de juegos basada en los IDs obtenidos por {@link ConsultorApi}.
     *
     * @return Lista de juegos creados.
     */
    public ArrayList<Juego> crearJuegosDesdeApi() {
        ArrayList<Juego> listaJuegos = new ArrayList<>();

        if (gameIDs.isEmpty()) {
            System.out.println("Primero se tienen que ingresar las ID al catálogo");
        } else {
            for (Integer gameId : gameIDs) {
                JSONObject gameData = consultorApi.obtenerDetallesJuego(gameId);
                if (gameData != null) {
                    Juego juego = crearJuegoDesdeJson(gameData);
                    listaJuegos.add(juego);
                    System.out.println("Se añadió el juego '" + juego.getTitulo() + "' al catálogo");
                }
            }
        }
        return listaJuegos;
    }

    /**
     * Obtiene una lista de IDs de juegos desde la API y la almacena en {@code gameIDs}.
     */
    public void conseguirIDs() {
        gameIDs.addAll(consultorApi.peticionIDs());
        System.out.println("IDs conseguidas");
    }

    /**
     * Crea una instancia de {@link Juego} a partir de un objeto JSON que contiene los datos del juego.
     *
     * @param gameData JSONObject con los datos del juego.
     * @return Instancia de {@link Juego} creada.
     */
    private Juego crearJuegoDesdeJson(JSONObject gameData) {
        String name = gameData.optString("name");
        String released = gameData.optString("released");

        String developers = obtenerDatosLista(gameData, "developers");
        String genres = obtenerDatosLista(gameData, "genres");

        String backgroundImage = gameData.optString("background_image");
        String description = gameData.optString("description");

        return new Juego(name, released, genres, developers, backgroundImage, description);
    }

    /**
     * Recopila y formatea información específica de una lista JSON dentro de los datos de un juego.
     *
     * @param lista     JSONObject con los datos del juego.
     * @param busqueda  Clave que identifica la lista de datos en el JSON.
     * @return Cadena de texto con los elementos de la lista separados por comas.
     */
    private String obtenerDatosLista(JSONObject lista, String busqueda) {
        StringBuilder respuesta = new StringBuilder();
        var listaDatos = lista.optJSONArray(busqueda);
        if (listaDatos != null) {
            for (int i = 0; i < listaDatos.length(); i++) {
                var dato = listaDatos.getJSONObject(i);
                respuesta.append(dato.optString("name"));
                if (i < listaDatos.length() - 1) {
                    respuesta.append(", ");
                }
            }
        }
        return respuesta.toString();
    }

    /**
     * Agrega una ID de juego al catálogo si no está ya presente. Si la ID ya existe, muestra un mensaje.
     *
     * @param id ID del juego a agregar al catálogo.
     */
    public void ingresarID(int id) {
        if (gameIDs.contains(id)) {
            System.out.println("La ID ya está guardada en el catálogo");
        } else {
            gameIDs.add(id);
        }
    }

    /**
     * Devuelve la lista de IDs de juegos actualmente almacenada.
     * Este método es principalmente para pruebas y asegurar que la clase funcione correctamente.
     *
     * @return Lista de IDs de juegos.
     */
    public ArrayList<Integer> getGameIDs() {
        return gameIDs;
    }
}
