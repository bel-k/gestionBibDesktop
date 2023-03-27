package com.example.labmanager.model.dao;



import com.example.labmanager.model.bo.Livre;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DAOLivre {
    public boolean create(Livre L) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            session.save(L);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }

    }


    public Collection<Livre> retreive() {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Vector<Livre> LC=new Vector<>();
            List<Livre> livres=session.createQuery("FROM Livre").list();
            Iterator<Livre> it = livres.iterator();
            while(it.hasNext()){
                Object o=it.next();
                Livre L=(Livre) o;
                LC.add(new Livre(L.getIsbn(),L.getTitre(),L.getNbrexemplaire(),L.getAuteur(),L.getCategorie()));
            }
            tx.commit();
            return LC;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }
    }



    public boolean update(String isbn,String titre,int nbrexemplaire,String aut,String cat) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Livre L=(Livre) session.get(Livre.class,isbn);
            L.setTitre(titre);
            L.setNbrexemplaire(nbrexemplaire);
            L.setAuteur(aut);
            L.setCategorie(cat);
            session.update(L);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }



    public boolean delete(String isbn) {
        Transaction tx=null;
        try{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            Livre L=(Livre) session.get(Livre.class,isbn);
            session.delete(L);
            tx.commit();
            return true;
        }
        catch(HibernateError e){
            tx.rollback();
            return false;
        }
    }
    public Livre getLivre(String isbn){
        Transaction tx=null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Livre L = (Livre) session.get(Livre.class, isbn);
            return L;
        }
        catch(HibernateError e){
            tx.rollback();
            return null;
        }

    }
    public List<Livre>  findLivre(String name) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(" from Livre l where l.titre LIKE CONCAT('%',?1,'%')");
            query.setParameter(1, name);
            List livres = query.getResultList();
            return livres;


        } catch (HibernateError e) {
            tx.rollback();
            return null;
        }
    }
    public List<Livre>  findLivreAut(String name) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(" from Livre l where l.auteur LIKE CONCAT('%',?1,'%')");
            query.setParameter(1, name);
            List livres = query.getResultList();
            return livres;


        } catch (HibernateError e) {
            tx.rollback();
            return null;
        }
    }
    public List<Livre>  findLivreCat(String name) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(" from Livre l where l.categorie LIKE CONCAT('%',?1,'%')");
            query.setParameter(1, name);
            List livres = query.getResultList();
            return livres;


        } catch (HibernateError e) {
            tx.rollback();
            return null;
        }
    }



}
