package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Catalogo {
    private final ArrayList<Juego> listaJuegos;
    private final ArrayList<Integer> gameIDs;

    public Catalogo() {
        listaJuegos = new ArrayList<>();
        gameIDs = new ArrayList<>();
    }

    private static final String apiKey = "af375b9d59e746259fe257e3b81e0f0d"; //la llave estara disponible una vez que se hable de el asunto de la seguridad

    public void ingresarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    public void ingresarID(int id){
        if (gameIDs.contains(id)){
            System.out.println("la id ya esta guardada en el catalogo");
        }else {
            gameIDs.add(id);
        }
    }

    public void mostrarCatalogo() {
        if (listaJuegos.isEmpty()) {
            System.out.println("El catalogo esta vacio de momento");
        }else {
            for (Juego juego : listaJuegos) {
                System.out.println("---------------------------------");
                juego.mostrarDetalles();
            }
        }
    }

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
                System.out.println("Id's conseguidas");
            } else {
                System.out.println("GET request failed: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void conseguirJuegos() {
        if (gameIDs.isEmpty()){
            System.out.println("Primero se tienen que ingresar las ID al catalogo");
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

                    // generos
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
                    System.out.println("Se añadio el juego '"+ name +"' al catalogo");

                } else {
                    System.out.println("GET request failed: " + responseCode);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }
}
/*  Se modifico la clase para funcionar como un catalogo, almacenando los juegos y sus Id en arreglos los cuales se usaran en el programa
 */
