package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MetodoBaseDatos {

    public void insertarObra(Obra obra){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.save(obra);

        transaction.commit();
        session.close();
    }

    public void insertarMiniatura(Thumbnail thumbnail){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.save(thumbnail);

        transaction.commit();
        session.close();
    }
    public void selectAll(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sesion = sessionFactory.getCurrentSession();
        Transaction transaction = sesion.beginTransaction();
        Query<Obra> query = sesion.createNativeQuery("SELECT * FROM Obras", Obra.class);
        List<Obra> listaObras= query.list();
        for(Obra obra: listaObras){
            System.out.println(obra);
            for(Thumbnail thumbnail:obra.getThumbnails()){
                System.out.println(thumbnail);
            }
        }
        transaction.commit();
        sesion.close();
    }

}
