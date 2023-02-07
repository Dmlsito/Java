package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MetodosCRUD {

    public MetodosCRUD(){}

    //Insert BBDD
    public  void insertPlanets(Planet planet){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();

        Transaction transaction = sesion.beginTransaction();
        sesion.save(planet);
        transaction.commit();
        sesion.close();

    }
    public  void insertOrbitalPlanetsData(OrbitalPlanetData data){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();

        Transaction transaction = sesion.beginTransaction();
        sesion.save(data);
        transaction.commit();
        sesion.close();

    }
}
