package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CallApi {

    public static void main( String[] args )
    {
        HttpURLConnection connection = null;
        OutputStreamWriter wr = null;
        String line = null;

        try {
            // LLamar a API
            URL serverAddress = new URL("https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=7RI1iO9XFonO0Rwl974iXQyUXeOEcS1tAcJKJsah");
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

            // Formatear resultados API
            JsonObject objetoJson = new Gson().fromJson(sb.toString(), JsonObject.class);
            JsonArray resultados = objetoJson.get("near_earth_objects").getAsJsonArray();
            for(JsonElement resultado: resultados){
                System.out.println(resultado);
            }

        } catch (MalformedURLException e) {
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
