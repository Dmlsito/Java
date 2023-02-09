package org.example;

import com.sun.media.jfxmediaimpl.HostUtils;
import net.bytebuddy.pool.TypePool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.ObjectType;
import org.hibernate.type.StringType;


import java.util.List;

public class MetodosCRUD {

    public MetodosCRUD(){}

    //Insert planets objects in the BBDD
    public  void insertPlanets(Planet planet){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();

        Transaction transaction = sesion.beginTransaction();
        sesion.save(planet);
        transaction.commit();
        sesion.close();

    }
    //Inserts OrbitalPlanetsData in the BBDD
    public  void insertOrbitalPlanetsData(OrbitalPlanetData data){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();

        Transaction transaction = sesion.beginTransaction();
        sesion.save(data);
        transaction.commit();
        sesion.close();
    }
    //Recover all data planets
    public void selectAll(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();

        Transaction transaction = sesion.beginTransaction();
        Query<Planet> query = sesion.createNativeQuery("SELECT * FROM Planets", Planet.class);
        List<Planet> listaPlanetas = query.list();
        for(Planet planet: listaPlanetas){
            System.out.println(planet);
            for(OrbitalPlanetData data: planet.getOrbitalPlanetData()){
                System.out.println(data);
            }
        }
        transaction.commit();
        sesion.close();
    }

    public void selectPlanet(String name){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();
        Transaction transaction = sesion.beginTransaction();
        Query<Planet> query = sesion.createQuery("from Planet where name = :name", Planet.class);
        query.setParameter("name", name, StringType.INSTANCE);
        List<Planet> listaPlanetas = query.list();
        for(Planet planet: listaPlanetas){
            System.out.println("DATOS PLANETA " + name + "->");
            System.out.println(planet);
            System.out.println("----------------------------------------------------------------");
            for(OrbitalPlanetData data: planet.getOrbitalPlanetData()){
                System.out.println("DATOS ORBITA");
                System.out.println(data);
                System.out.println("---------------------------------------------------------------");
            }
        }
        transaction.commit();
        sesion.close();
    }


}
