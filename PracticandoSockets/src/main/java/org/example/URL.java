package org.example;
import java.net.*;
import java.io.*;


public class URL {
    public static void main(String[] args) throws IOException {
        //El objeto URLConnection permite la comunicacion con lo que hay dentro de la URL
        //El metodo OpenConnection() de la clase URL permite crer un objeto URLConnection
        URL url = null;
        URLConnection connection = null;
        try {
           // url = new URL("http://www.elaltozano.es");
           // connection = url.openConnection();
            BufferedReader in;
            InputStream stream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(stream));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
