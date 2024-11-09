package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Clase que representa un catálogo de juegos. Permite gestionar una lista de juegos y obtener información
 * desde una API externa utilizando IDs de juegos.
 */
public class CatalogoPreR {

    private final ArrayList<Juego> listaJuegos;
    private final ArrayList<Integer> gameIDs;

    /**
     * Constructor de la clase Catalogo. Inicializa las listas de juegos y de IDs de juegos.
     */
    public CatalogoPreR() {
        listaJuegos = new ArrayList<>();
        gameIDs = new ArrayList<>();
    }

    private static final String apiKey = "93d03e013f054d4b957439eaa1b0503b"; //desabilitada

    /**
     * Agrega un juego al catálogo.
     * @param juego El juego que se desea añadir.
     */
    public void ingresarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    /**
     * Agrega una ID de juego al catálogo si no ha sido previamente ingresada.
     * @param id La ID del juego que se desea agregar.
     */
    public void ingresarID(int id) {
        if (gameIDs.contains(id)) {
            System.out.println("La ID ya está guardada en el catálogo");
        } else {
            gameIDs.add(id);
        }
    }

    /**
     * Muestra todos los juegos actualmente almacenados en el catálogo.
     * Si el catálogo está vacío, se mostrará un mensaje indicándolo.
     */
    public void mostrarCatalogo() {
        if (listaJuegos.isEmpty()) {
            System.out.println("El catálogo está vacío de momento");
        } else {
            for (Juego juego : listaJuegos) {
                System.out.println("-----------------------------------------------------------------------------------------");
                juego.mostrarDetalles();
            }
        }
    }

    /**
     * Obtiene una lista de IDs de juegos desde la API externa y las agrega al catálogo.
     */
    public void conseguirIDs() {
        String urlString = "https://api.rawg.io/api/games?key=" + apiKey + "&ordering=-added&page_size=10";

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

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray gamesArray = jsonResponse.getJSONArray("results");

                for (int i = 0; i < gamesArray.length(); i++) {
                    JSONObject game = gamesArray.getJSONObject(i);
                    int gameId = game.getInt("id");
                    this.ingresarID(gameId);
                }
                System.out.println("IDs conseguidas");
            } else {
                System.out.println("GET request fallido: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene información detallada de los juegos asociados a las IDs almacenadas y las agrega al catálogo.
     */
    public void conseguirJuegos() {
        if (gameIDs.isEmpty()) {
            System.out.println("Primero se tienen que ingresar las ID al catálogo");
        }
        for (Integer gameId : this.gameIDs) {
            String urlString = "https://api.rawg.io/api/games/" + gameId + "?key=" + apiKey;

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

                    JSONObject game = new JSONObject(response.toString());

                    String name = game.optString("name");
                    String released = game.optString("released");
                    String description = game.optString("description");
                    String backgroundImage = game.optString("background_image");

                    JSONArray developersArray = game.optJSONArray("developers");
                    StringBuilder developers = new StringBuilder();
                    if (developersArray != null) {
                        for (int i = 0; i < developersArray.length(); i++) {
                            JSONObject developer = developersArray.getJSONObject(i);
                            developers.append(developer.optString("name"));
                            if (i < developersArray.length() - 1) {
                                developers.append(", ");
                            }
                        }
                    }

                    JSONArray genresArray = game.optJSONArray("genres");
                    StringBuilder genres = new StringBuilder();
                    if (genresArray != null) {
                        for (int i = 0; i < genresArray.length(); i++) {
                            JSONObject genre = genresArray.getJSONObject(i);
                            genres.append(genre.optString("name"));
                            if (i < genresArray.length() - 1) {
                                genres.append(", ");
                            }
                        }
                    }

                    Juego nuevoJuego = new Juego(name, released, genres.toString(), developers.toString(), backgroundImage, description);
                    this.ingresarJuego(nuevoJuego);
                    System.out.println("Se añadió el juego '" + name + "' al catálogo");

                } else {
                    System.out.println("GET request fallido: " + responseCode);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Obtiene la lista de juegos almacenados en el catálogo.
     * @return La lista de juegos en el catálogo.
     */
    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }


    public ArrayList<Integer> getGameIDs() {
        return gameIDs;
    }
}
