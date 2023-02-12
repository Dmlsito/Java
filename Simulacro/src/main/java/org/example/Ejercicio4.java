package org.example;

import java.io.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        ServicioHibernate methods = new ServicioHibernate();
        methods.insertarLista(leerFichero());
    }
    public static List<Futbolista> leerFichero(){
        FileReader inputReader = null;
        BufferedReader reader = null;
        File file = new File("FicheroDatos.txt");
        SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        List<Futbolista> listadoFutbolistas = new ArrayList<Futbolista>();
        ServicioHibernate servicioHibernate = new ServicioHibernate();
        try {
            inputReader = new FileReader(file);
            reader = new BufferedReader(inputReader);
            String result = reader.readLine();

            while(result != null){
                String[] futbolistas = result.split("[|]");
                Futbolista futbolista = new Futbolista();
                futbolista.setNombre(futbolistas[0]);
                futbolista.setClub(futbolistas[1]);
                futbolista.setMedia(Float.parseFloat(futbolistas[2]));
                Date ultimoPartidoDate = dateFormat.parse(futbolistas[3]);
                Timestamp ultimoPartido = new java.sql.Timestamp(ultimoPartidoDate.getTime());
                futbolista.setUltimoPartido(ultimoPartido);
                listadoFutbolistas.add(futbolista);
                result = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw    new RuntimeException(e);
        }finally {
            try {

                if (reader != null) reader.close();
                if(inputReader != null) inputReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listadoFutbolistas;
    }
}
