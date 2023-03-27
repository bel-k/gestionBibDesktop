package com.example.labmanager.service;

import com.example.labmanager.model.bo.Emprunt;
import com.example.labmanager.model.bo.Exemplaire;
import com.example.labmanager.model.bo.Livre;

import java.util.Collection;
import java.util.Vector;

public class ServiceEmprunt {

    public ServiceEmprunt() {
    }
    public static Vector<Livre> livreDisponaible(Vector<Livre> livres){
        Vector<Livre> l=new Vector<>();
        for (Livre liv:livres) {
            System.out.println("livre "+liv.getIsbn()+" nbr "+liv.getNbrexemplaire());
            if (liv.getNbrexemplaire()!= 0){

                l.add(liv);
            }

        }
        return l;
    }
    public static Exemplaire exemplaireDisponaible(Collection<Exemplaire> exemplaire){

        for (Exemplaire ex:exemplaire) {
            if (ex.getDisp().equals("disponible"))
                return ex;
        }
        return null;
    }

}
