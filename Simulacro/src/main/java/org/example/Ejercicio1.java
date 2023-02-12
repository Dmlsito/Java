package org.example;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args ) throws ParseException, SQLException {

        Servicio servicio = new Servicio();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2007");
        long time = date.getTime();
        Timestamp ultimoPartido = new Timestamp(time);

        Futbolista futbolista = new Futbolista(1, "Daniel", "MiClub", 6, ultimoPartido);
        int id = servicio.insertar(futbolista);
        System.out.println(servicio.consultar(id));
        futbolista.setNombre("Paquito");
        servicio.actualizar(futbolista);
        System.out.println(servicio.consultar(id));
        servicio.eliminar(id);

    }
}
