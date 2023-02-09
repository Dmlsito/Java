package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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


public class App 
{
    public static void main( String[] args )
    {
        insertData();
        /*String name = "719 Albert (A911 TB)";
        MetodosCRUD metodos = new MetodosCRUD();
        metodos.selectPlanet(name);\

         */

    }

    public static void insertData(){
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
                //We parse and add the data to the Planet object
                PlanetDTO planetParseado = new Gson().fromJson(resultado, PlanetDTO.class);

                Planet planet = new Planet(planetParseado.getId(), planetParseado.getNeo_reference_id(), planetParseado.getName(), planetParseado.getDesignation(), planetParseado.getAbsolute_magnitude_h(), planetParseado.getOrbitalPlanetData(), planetParseado.getListApproachData());
                System.out.println(planetParseado.getListApproachData());
                //metodos.insertPlanets(planet);


                //We parse and add the data to the OrbitalPlanetData object
                OrbitalPlanetDataDTO data = (new Gson().fromJson( resultado.getAsJsonObject().get("orbital_data").getAsJsonObject(), OrbitalPlanetDataDTO.class));
                OrbitalPlanetData dataPlanet = new OrbitalPlanetData(data.getOrbit_id(), data.getOrbit_determination_date(), data.getFirst_observation_date(), data.getLast_observation_date(), data.getData_arc_in_days(), data.getObservation_used(), data.getOrbit_uncertainty(), data.getMinimun_orbit_intersection(), data.getJupiter_tisserand_invariant(), data.getEpoch_osculation(), data.getEccentricity(), data.getSemi_major_axis(), data.getInclination(), data.getAscending_node_longitude(), data.getOrbital_period(), data.getPerihelion_distanced(), data.getPerihelion_argument(), data.getPlanet());
                //metodos.insertOrbitalPlanetsData(dataPlanet);



            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
