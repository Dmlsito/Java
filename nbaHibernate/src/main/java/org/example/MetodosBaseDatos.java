package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.List;


public class MetodosBaseDatos {


    // Métodos PARA EQUIPOS


    // Método para insertar Equipo en la base de datos //
    public void insertarEquipo(Team team){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.save(team);
        transaction.commit();
        session.close();
    }



    // Método para comprobar si el Equipo evaluado ya existe en la bbdd //
    public  boolean  comprobarEquipo(Team team){
        boolean exito = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query<Team> query = session.createQuery("from Team where name= :name",Team.class);
        query.setParameter("name", team.getName(), StringType.INSTANCE);
        List<Team> listaEquipos = query.list();

        if(listaEquipos.isEmpty() || listaEquipos==null){
            exito = true;
        }


        return exito;
    }



    // Métodos para JUGADORES //


    // Método para insertar un Jugador en la base de datos //

    public void insertarJugador(Player player){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();


        if(comprobarJugador(player)){
            session.save(player);
            System.out.println("Jugador insertado con éxito");
        }else{
            System.out.println("Jugador NO insertado, Jugador ingresado ya existe en la base de datos");
        }

        transaction.commit();
        session.close();
    }



    // Método para comprobar si el jugador existe ya en la base de datos //
    public  boolean  comprobarJugador(Player player){
        boolean exito = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query<Player> query = session.createQuery("from Player where first_name= :first_name",Player.class);
        query.setParameter("first_name", player.getFirst_name(), StringType.INSTANCE);
        List<Player> listaJugadores = query.list();

        if(listaJugadores.isEmpty() || listaJugadores==null){
            exito = true;
        }


        return exito;
    }



}
