package org.example;

import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Clase creadora de juegos. Permite obtener información
 * de juegos y devolver instancias de Juego.
 */
public class CreadorJuegos {
    private final ConsultorApi consultorApi;

    public CreadorJuegos() {
        this.consultorApi = new ConsultorApi();
    }

    /**
     * Método para crear y devolver una lista de juegos basada en IDs obtenidos por ConsultorApi.
     * @return Lista de juegos creados.
     */
    public ArrayList<Juego> crearJuegosDesdeApi() {
        ArrayList<Juego> listaJuegos = new ArrayList<>();
        ArrayList<Integer> gameIDs = consultorApi.obtenerGameIDs();

        for (Integer gameId : gameIDs) {
            JSONObject gameData = consultorApi.obtenerDetallesJuego(gameId);
            if (gameData != null) {
                Juego juego = crearJuegoDesdeJson(gameData);
                listaJuegos.add(juego);
            }
        }

        return listaJuegos;
    }

    /**
     * Crea una instancia de Juego a partir de un JSONObject con los datos de un juego.
     * @param gameData JSONObject con los datos del juego.
     * @return Instancia de Juego creada.
     */
    private Juego crearJuegoDesdeJson(JSONObject gameData) {
        String name = gameData.optString("name");
        String released = gameData.optString("released");
        String developers = obtenerDatosLista(gameData, "developers");
        String genres = obtenerDatosLista(gameData , "genres");
        String backgroundImage = gameData.optString("background_image");
        String description = gameData.optString("description");


        return new Juego(name, released, genres, developers, backgroundImage, description);
    }

    /**
     * Recopila informacion especifica entre los datos de un juego que sean lista.
     * @param lista JSONObject con los datos del juego.
     * @param busqueda String con la opcion a escojer entre los datos del juego.
     * @return String de los datos recopilados.
     */
    private String obtenerDatosLista(JSONObject lista, String busqueda){
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
}
