package com.example.labmanager.model.dao;


import com.example.labmanager.model.bo.Adherent;
import com.example.labmanager.model.bo.Emprunt;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class DAOEmprunt {
    public boolean create(Emprunt em) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            session.save(em);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }

    }


    public Collection<Emprunt> retreive() {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Vector<Emprunt> LC=new Vector<>();
            List<Emprunt> emprunts=session.createQuery("FROM Emprunt").list();
            Iterator<Emprunt> it = emprunts.iterator();
            while(it.hasNext()){
                Object o=it.next();
                Emprunt C=(Emprunt) o;
                LC.add(new Emprunt(C.getCode(),C.getCin(),C.getDateemprunt(),C.getDateretour()));
            }
            tx.commit();
            return LC;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }
    public Emprunt getEmprunt(String cin,String code){
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(" from Emprunt e where e.cin= :cin and e.code= :code ");
            query.setParameter("cin", cin);
            query.setParameter("code", code);
            Emprunt emp = (Emprunt) query.uniqueResult();
            return emp;


        } catch (HibernateError e) {
            tx.rollback();
            return null;
        }

}


    public boolean update(String cin, String code , java.sql.Date dateretour) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Emprunt emp=getEmprunt( cin, code);
            emp.setDateretour(dateretour);
            session.update(emp);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }



//    public boolean delete(String isbn,String cin) {
//        Transaction tx=null;
//        try{
//            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
//            tx=session.beginTransaction();
//            session.delete(new Emprunt("livre2","ee1"));
//            tx.commit();
//            return true;
//        }
//        catch(HibernateError e){
//            tx.rollback();
//            return false;
//        }
//    }
}
