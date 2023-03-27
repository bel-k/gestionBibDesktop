package ma.fstm.ilisi.controler;


import ma.fstm.ilisi.model.bo.Livre;
import ma.fstm.ilisi.model.dao.DAOLivre;

import javax.swing.*;
import java.util.Vector;

/**
 *
 * @author Electro Fatal
 */
public class LivreController {
    public static void ajouterLivre(String isbn, String titre, String auteur, String categorie){
        Livre L = new Livre(isbn, titre,auteur,categorie);
        DAOLivre liv = new DAOLivre();
        liv.create(L);
    }
    public static void showLivres(JTable tab){
        DAOLivre l=new DAOLivre();
        Vector<Livre> livres=(Vector<Livre>) l.retreive();
        Vector <Vector<Object>>matrice=new  Vector <Vector<Object>>();
        Vector <String> title=new Vector<String>();
        title.add("ISBN");
        title.add("Titre");
        title.add("nmbExemplaire");
        title.add("auteur");
        title.add("categorie");

        for(Livre L:livres)
        {
            Vector v=new Vector();
            v.add(L.getIsbn());
            v.add(L.getTitre());
            v.add(L.getNbrexemplaire());
            v.add(L.getAuteur());
            v.add(L.getCategorie());

            matrice.add(v);
        }
        tab.setModel(new javax.swing.table.DefaultTableModel(matrice,title));

    }

    public static void updateLivre(String isbn, String titre, String auteur, String categorie){
        DAOLivre D = new DAOLivre();
        Livre l= D.getLivre(isbn);
        D.update(isbn,titre,l.getNbrexemplaire(),auteur,categorie);

    }
}
