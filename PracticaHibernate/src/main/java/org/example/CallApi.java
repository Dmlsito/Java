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
import java.util.Set;

public class CallApi {

    public static void main( String[] args )
    {
        MetodosCRUD metodos = new MetodosCRUD();
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
                //Object parse
                resultado.getAsJsonObject().get("orbital_data").getAsJsonObject();
                Planet planetParseado = new Gson().fromJson(resultado, Planet.class);
                Planet planet = new Planet( planetParseado.getId(), planetParseado.getNeoReferenceId(), planetParseado.getName(), planetParseado.getDesignation(), planetParseado.getAbsoluteMagnitudeH(), planetParseado.getOrbitalPlanetData());
                metodos.insertPlanets(planet);
                //System.out.println(planet);

                OrbitalPlanetDataDTO data = (new Gson().fromJson( resultado.getAsJsonObject().get("orbital_data").getAsJsonObject(), OrbitalPlanetDataDTO.class));

                OrbitalPlanetData dataPlanet = new OrbitalPlanetData(data.getOrbit_id(), data.getOrbit_determination_date(), data.getFirst_observation_date(), data.getLast_observation_date(), data.getData_arc_in_days(), data.getObservation_used(), data.getOrbit_uncertainty(), data.getMinimun_orbit_intersection(), data.getJupiter_tisserand_invariant(), data.getEpoch_osculation(), data.getEccentricity(), data.getSemi_major_axis(), data.getInclination(), data.getAscending_node_longitude(), data.getOrbital_period(), data.getPerihelion_distanced(), data.getPerihelion_argument(), data.getPlanet());

                metodos.insertOrbitalPlanetsData(dataPlanet);
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
