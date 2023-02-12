package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {



 metodoInsertarTeamPlayer();


    }

    public static void metodoInsertarTeamPlayer(){
        HttpURLConnection connection = null;
        OutputStreamWriter wr = null;
        String line = null;
        MetodosCRUD metodo= new MetodosCRUD();


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

            JsonObject objetoJson = new Gson().fromJson(sb.toString(), JsonObject.class);


            JsonArray resultados = objetoJson.get("data").getAsJsonArray();
            for(JsonElement resultado: resultados){

                TeamDTO teamRecuperado = new Gson().fromJson(resultado.getAsJsonObject().get("team"), TeamDTO.class);
                Team team = new Team(teamRecuperado.getId(), teamRecuperado.getAbbreviation(), teamRecuperado.getCity(), teamRecuperado.getConference(), teamRecuperado.getDivision(), teamRecuperado.getFull_name(), teamRecuperado.getName());
                System.out.println(team.getIdTeam());

                metodo.insertarEquipo(team);
                int id = team.getIdTeam();

                PlayerDTO playerRecuperado = new Gson().fromJson(resultado, PlayerDTO.class);
                Player player = new Player(playerRecuperado.getId(), playerRecuperado.getFirst_name(), playerRecuperado.getLast_name(), playerRecuperado.getPosition(), playerRecuperado.getHeight_feet(), playerRecuperado.getHeight_inches(), playerRecuperado.getWeight_pounds(), playerRecuperado.getTeam());

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
