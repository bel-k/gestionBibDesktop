package com.example.labmanager.model.dao;


import com.example.labmanager.model.bo.Adherent;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
public class DAOAdherent {
    public boolean create(Adherent C) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();;
            tx=session.beginTransaction();
            session.save(C);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }

    }


    public Collection<Adherent> retreive() {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();;
            tx=session.beginTransaction();
            Vector<Adherent> LC=new Vector<>();
            List<Adherent> Adherents=session.createQuery("FROM Adherent").list();
            Iterator<Adherent> it = Adherents.iterator();
            while(it.hasNext()){
                Object o=it.next();
                Adherent C=(Adherent) o;
                LC.add(new Adherent(C.getCin(),C.getNom(),C.getPrenom()));
            }
            tx.commit();
            return LC;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }



    public boolean update(String cin,String nom ,String prenom) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Adherent c=(Adherent) session.get(Adherent.class,cin);
            c.setNom(nom);
            c.setPrenom(prenom);
            session.update(c);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }



    public boolean delete(String cin) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Adherent c=(Adherent) session.get(Adherent.class,cin);
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
