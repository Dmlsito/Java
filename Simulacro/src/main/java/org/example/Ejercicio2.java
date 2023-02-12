package org.example;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Ejercicio2 {

    public static void main(String[] args) throws ParseException, SQLException {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2005");
        Date date1 = dateFormat.parse("29/09/2003");
        Date date2 = dateFormat.parse("21/10/2002");
        long time1 =  date.getTime();
        long time2 =  date.getTime();
        long time3 =  date.getTime();
        Timestamp timestamp1 = new Timestamp(time1);
        Timestamp timestamp2 = new Timestamp(time2);
        Timestamp timestamp3 = new Timestamp(time3);

        Futbolista futbolista1 =  new Futbolista(1, "Pablo", "Club", 3, timestamp1 );
        Futbolista futbolista2 =  new Futbolista(2, "Paco", "Club", 3, timestamp1 );
        Futbolista futbolista3 =  new Futbolista(3, "Adrian", "Club", 3, timestamp1 );
        List<Futbolista> listFutbolistas = new ArrayList<Futbolista>();
        listFutbolistas.add(futbolista1);
        listFutbolistas.add(futbolista2);
        listFutbolistas.add(futbolista3);
        ServicioListas servicio = new ServicioListas();
        servicio.inserBatch(listFutbolistas);
        System.out.println(servicio.listarTodo());

        

    }

}
