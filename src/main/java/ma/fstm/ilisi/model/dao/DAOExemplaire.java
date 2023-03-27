package com.example.labmanager.model.dao;


import com.example.labmanager.model.bo.Adherent;
import com.example.labmanager.model.bo.Exemplaire;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DAOExemplaire {
    public boolean create(Exemplaire exemplaire) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
//        Exemplaire e=new Exemplaire ("1234", "livre4");
            session.save(exemplaire);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }

    }


    public Collection<Exemplaire> retreive() {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Vector<Exemplaire> EX=new Vector<>();
            List<Exemplaire> exemplaires=session.createQuery("FROM Exemplaire").list();
            Iterator<Exemplaire> it = exemplaires.iterator();
            while(it.hasNext()){
                Object o=it.next();
                Exemplaire e=(Exemplaire) o;
                EX.add(new Exemplaire(e.getCode(),e.getIsbn(),e.getDisp()));
            }
            tx.commit();
            return EX;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }
    public Collection<Exemplaire> getExemplaireByIsbn(String isbn) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Vector<Exemplaire> EX=new Vector<>();
            List<Exemplaire> exemplaires=session.createQuery("FROM Exemplaire").list();
            Iterator<Exemplaire> it = exemplaires.iterator();
            while(it.hasNext()){
                Object o=it.next();
                Exemplaire e=(Exemplaire) o;
                if(e.getIsbn().equals(isbn))
                    EX.add(new Exemplaire(e.getCode(),e.getIsbn(),e.getDisp()));
            }
            tx.commit();
            return EX;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }
    public Exemplaire getExemplaire(String code){
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Exemplaire e=(Exemplaire) session.get(Exemplaire.class,code);

            return e;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }



    public boolean update(String code) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Exemplaire e=(Exemplaire) session.get(Exemplaire.class,code);
            if(e.getDisp().equals("disponible"))
                e.setDisp("indisponible");
            else e.setDisp("disponible");
            session.update(e);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }



    public boolean delete(String code) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Exemplaire c=(Exemplaire) session.get(Exemplaire.class,code);
            session.delete(c);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }
}
