package org.example;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;



public class HibernateUtil {
    public static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            System.out.println("Ha ocurrido un error");
            throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
