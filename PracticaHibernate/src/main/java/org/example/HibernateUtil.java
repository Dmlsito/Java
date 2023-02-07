package org.example;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;



public class HibernateUtil {

    public static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            System.out.println("Error al crear SessionFactory");
            throw new ExceptionInInitializerError();
            }
        }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
   

}
