package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.TemporalType;
import javax.swing.tree.TreeNode;
import java.util.List;

public class ServicioHibernate {

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

    public int insertar(Futbolista futbolista){
        SessionFactory SessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(futbolista);
        transaction.commit();
        return futbolista.getId();
    }

    public void insertarLista(List<Futbolista> listadoFutbolistas){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (Futbolista futbolista : listadoFutbolistas) {
                session.save(futbolista);
            }
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }


    public void eliminar(int id){
        SessionFactory sesionFactory = getSessionFactory();
        Session sesion = sesionFactory.getCurrentSession();
        Transaction transaction = sesion.beginTransaction();
        Futbolista futbolista = sesion.get(Futbolista.class, id);
        sesion.delete(futbolista);
        transaction.commit();

    }
    public void actualizar(Futbolista futbolista){
        SessionFactory sessionFactory = getSessionFactory();
        Session sesion =  sessionFactory.getCurrentSession();
        Transaction transaction = sesion.beginTransaction();
        sesion.update(futbolista);
        transaction.commit();

    }
    public Futbolista consultar(int id){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Futbolista futbolista = session.get(Futbolista.class, id);
        transaction.commit();
        return futbolista;
    }

    public List<Futbolista> listarTodo(){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query<Futbolista> query = session.createNativeQuery("SELECT * FROM Futbolistas", Futbolista.class);
        List<Futbolista> listFutbolist = query.list();
        transaction.commit();
        return listFutbolist;
    }









}
