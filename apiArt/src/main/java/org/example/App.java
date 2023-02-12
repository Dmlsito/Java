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

public class App
{
    public static void main( String[] args )
    {

        HttpURLConnection connection = null;
        OutputStreamWriter wr = null;
        String line = null;
        MetodoBaseDatos metodo= new MetodoBaseDatos();



        try{

            // LLamar a API
            URL serverAddress = new URL("https://api.artic.edu/api/v1/artworks");
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

                ObraDTO obraRecuperada =  new Gson().fromJson(resultado, ObraDTO.class);
                Obra obra = new Obra(obraRecuperada.getId(), obraRecuperada.getApi_model(), obraRecuperada.isIs_boosted(),obraRecuperada.getTittle(),obraRecuperada.getAlt_tittles(),obraRecuperada.getThumbnails());

                ThumbnailDTO thumbnailDTO = new Gson().fromJson(resultado.getAsJsonObject().get("thumbnail"), ThumbnailDTO.class);
                Thumbnail thumbnail = new Thumbnail(obra.getIdApi(), thumbnailDTO.getLqip(),thumbnailDTO.getWidth(),thumbnailDTO.getHeight(),thumbnailDTO.getAlt_text(),thumbnailDTO.getObra());
                metodo.insertarObra(obra);
                metodo.insertarMiniatura(thumbnail);
            }
            metodo.selectAll();

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            connection.disconnect();
        }


    }
}
