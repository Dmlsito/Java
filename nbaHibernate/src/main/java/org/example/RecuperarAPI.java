package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.bytebuddy.pool.TypePool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;


public class RecuperarAPI {
    public static void main( String[] args ) {

        metodoInsertarTeamPlayer();


    }
        public static void metodoInsertarTeamPlayer(){
            HttpURLConnection connection = null;
            OutputStreamWriter wr = null;
            String line = null;
            MetodosBaseDatos metodo= new MetodosBaseDatos();


            try {
                // LLamar a API
                URL serverAddress = new URL("https://www.balldontlie.io/api/v1/players");
                connection = (HttpURLConnection)serverAddress.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(true);
                connection.setReadTimeout(10000);
                connection.connect();

                // Leer resultados API
                BufferedReader rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();

                while ((line = rd.readLine()) != null)
                {
                    sb.append(line);
                }

                // Si viene en forma de Array el resultado de la API, habria que cambiarlo
                // Formatear resultados API
                JsonObject objetoJson = new Gson().fromJson(sb.toString(), JsonObject.class);

                // título de donde vienen los datos
                JsonArray resultados = objetoJson.get("data").getAsJsonArray();
                for(JsonElement resultado: resultados){

                    // Aqui le digo que el resultado que obtenga de todo el JSON, pillame como objeto JSON desde donde a mi me interesa recoger
                    TeamDTO teamRecuperado = new Gson().fromJson(resultado.getAsJsonObject().get("team"), TeamDTO.class);
                    Team team = new Team(teamRecuperado.getId(), teamRecuperado.getAbbreviation(), teamRecuperado.getCity(), teamRecuperado.getConference(), teamRecuperado.getDivision(), teamRecuperado.getFull_name(), teamRecuperado.getName());

                    //Me da una excepcion de NullPointer al mandar aqui el equipo para insertarlo //
                   metodo.insertarEquipo(team);

                    PlayerDTO playerRecuperado = new Gson().fromJson(resultado, PlayerDTO.class);
                    Player player = new Player(playerRecuperado.getId(), team.getIdTeam(),  playerRecuperado.getFirst_name(), playerRecuperado.getLast_name(), playerRecuperado.getPosition(), playerRecuperado.getHeight_feet(), playerRecuperado.getHeight_inches(), playerRecuperado.getWeight_pounds(), playerRecuperado.getTeam());
                    //System.out.println(player.getTeam());

                    //System.out.println(team.getName());
                    metodo.insertarJugador(player);
                }

            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally
            {
                connection.disconnect();
            }


    }


}
