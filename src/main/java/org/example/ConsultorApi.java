package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Clase que hace las consultas a la api. Permite obtener información
 * desde una API externa utilizando IDs de juegos obtenidos en la misma clase.
 */
public class ConsultorApi {
    private static final String apiKey = "93d03e013f054d4b957439eaa1b0503b"; //desabilitada

    /**
     * Método para obtener una lista de IDs de juegos desde la API.
     * @return lista con las IDs conseguidas de la api.
     */
    public ArrayList<Integer> peticionIDs() {
        String urlString = "https://api.rawg.io/api/games?key=" + apiKey + "&ordering=-added&page_size=10";
        ArrayList<Integer> gameIDs = new ArrayList<>();

        try {
            JSONObject jsonResponse = LlamadaApi(urlString);
            JSONArray gamesArray = jsonResponse.getJSONArray("results");

            for (int i = 0; i < gamesArray.length(); i++) {
                JSONObject game = gamesArray.getJSONObject(i);
                int gameId = game.getInt("id");
                gameIDs.add(gameId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameIDs;
    }

    /**
     * Método para obtener los detalles de un juego específico utilizando su ID.
     * @param gameId ID del juego.
     * @return JSONObject con los detalles del juego.
     */
    public JSONObject obtenerDetallesJuego(int gameId) {
        String urlString = "https://api.rawg.io/api/games/" + gameId + "?key=" + apiKey;
        JSONObject gameData= null;

        try {
            gameData = LlamadaApi(urlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameData;
    }

    /**
     * Método que hace peticiones de informacion referente a juegos.
     * @param urlString url de la peticion.
     * @return JSONObject con los detalles a pedir de los juegos.
     */
    private JSONObject LlamadaApi(String urlString){
        JSONObject jsonResponse=null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                 jsonResponse = new JSONObject(response.toString());
            } else {
                System.out.println("GET request fallido: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
    
}
