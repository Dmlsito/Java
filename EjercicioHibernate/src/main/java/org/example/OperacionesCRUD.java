package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperacionesCRUD {

    public OperacionesCRUD(){}

    public static void insert(Suppliers supplier){
        SessionFactory sessionFactory = new     Configuration().configure().buildSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();
        Transaction transaction = sesion.beginTransaction();
        sesion.save(supplier);
        transaction.commit();
        sesion.close();
    }
}
