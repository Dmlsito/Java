package org.example;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio3 {
    public static void main(String[] args) throws ParseException {


        ServicioHibernate methods = new ServicioHibernate();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("23/09/2005");
        long time3 =  date.getTime();
        Timestamp timeStamp = new Timestamp(time3);
        Futbolista futbolista1 = new Futbolista("David",  "Deportivo", 4, timeStamp);
        methods.insertar(futbolista1);
        System.out.println(methods.consultar(futbolista1.getId()));
        futbolista1.setNombre("Gumersindo");
        methods.actualizar(futbolista1);
        System.out.println(methods.consultar(futbolista1.getId()));
        methods.eliminar(futbolista1.getId());
        System.out.println(methods.listarTodo());



    }
}
