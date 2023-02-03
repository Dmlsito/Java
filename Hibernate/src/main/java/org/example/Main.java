package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.xml.transform.Transformer;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
    public static void main( String[] args ) {

        try{
            crearTarea();
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
        }

    }


    public static void crearTarea(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;

        try{
            date =  dateFormat.parse("23/01/2023 12:30");
        }catch(ParseException e){
            throw new RuntimeException(e);
        }

        long time = date.getTime();
        Tarea tarea = new Tarea("Obra Aula Nosa", "Obra en clase de segundo de DAM", new Timestamp(time), "Pendiente");

        Transaction transaction = session.beginTransaction();
        session.save(tarea);
        transaction.commit();
        session.close();

    }


}
