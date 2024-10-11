package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Juego> listaJuegos;

    public Catalogo() {
        listaJuegos = new ArrayList<>();
    }
    private static final String apiKey = "apikey"; //la llave estara disponible una vez que se hable de el asunto de la seguridad

    public void ingresarJuego(Juego juego) {
    }

    public void mostrarCatalogo() {
    }

    public void retroceder() {
        System.out.println("Retrocediendo en el catálogo...");
    }

    public static ArrayList<Integer> conseguirIDs() {
        String urlString = "https://api.rawg.io/api/games?key=" + apiKey + "&ordering=-added&page_size=10";
        ArrayList<Integer> gamesIDs = new ArrayList<>();

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

                System.out.println("Popular Game IDs:");
                for (int i = 0; i < gamesArray.length(); i++) {
                    JSONObject game = gamesArray.getJSONObject(i);
                    int gameId = game.getInt("id");
                    gamesIDs.add(gameId);
                }
            } else {
                System.out.println("GET request failed: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gamesIDs;
    }

    public static String detallesDelJuego(int gameId) {
        String urlString = "https://api.rawg.io/api/games/" + gameId + "?key=" + apiKey;
        String detalles = "";

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

                // Desarrolladores
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
                detalles = "{Nombre: "+ name +
                        "\n lanzamiento: " + released +
                        "\n desarroladores: " + developers +
                        "\n generos: " + genres +
                        "\n descripcion: " + description +
                        "\n imagen: " + backgroundImage + "}";

            } else {
                System.out.println("GET request failed: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalles;
    }

    public static void main(String[] args) {//main de prueba para conseguir la data de los juegos
        ArrayList<Integer> Ids = conseguirIDs();
        for (Integer id : Ids) {
            System.out.println(detallesDelJuego(id));
        }
    }
}
/*  Estos dos metodos en conjunto extraen informacion que puede ser utilizada por el sistema,
    el siguiente ejemplo es uno de los juegos que entrega la api al pedirle los juegos mas populares:
    {Nombre: Counter-Strike: Global Offensive
    lanzamiento: 2012-08-21
    desarroladores: Valve Software, Hidden Path Entertainment
    generos: Shooter
    descripcion: <p>Counter-Strike is a multiplayer phenomenon in its simplicity. No complicated narratives to explain the source of the conflict, no futuristic and alien threats, but counter-terrorists against terrorists. Arena shooter at its core, CS:GO provides you with various methods of disposing enemies and reliant on cooperation within the team. During the round of the classical clash mode, you will gradually receive currency to purchase different equipment. Each player can carry a primary weapon, secondary pistol, knife and a set of grenades, which all can change the battle if wielded by the skilled player. <br />
    Objectives are clear and vary from map to map, from game mode to game mode. Stop the terrorists from planting explosives, stop the counter-terrorist from retrieving the hostages, kill everyone who isn’t you and just perform the best with.<br />
    CS:GO is one of the major cybersport discipline, which makes playing it more exciting to some players. Aside from purchasing the game, CS:GO is infamous for its loot case system, that requires players to purchase keys, in order to open said cases. Customization items consist of weapon skins, weapon stickers, and sprays that do not affect gameplay and have purely visual value to the player.</p>
    imagen: https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg}

    En base ha esta informacion pueden construir lo demas
 */
