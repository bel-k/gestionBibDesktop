package ma.fstm.ilisi.model.bo;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Livre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ISBN")
    private String isbn;
    @Basic
    @Column(name = "TITRE")
    private String titre;
    @Basic
    @Column(name = "NBREXEMPLAIRE")
    private BigInteger nbrexemplaire;
    @Basic
    @Column(name = "AUTEUR")
    private String auteur;
    @Basic
    @Column(name = "CATEGORIE")
    private String categorie;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public BigInteger getNbrexemplaire() {
        return nbrexemplaire;
    }

    public void setNbrexemplaire(BigInteger nbrexemplaire) {
        this.nbrexemplaire = nbrexemplaire;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn) && Objects.equals(titre, livre.titre) && Objects.equals(nbrexemplaire, livre.nbrexemplaire) && Objects.equals(auteur, livre.auteur) && Objects.equals(categorie, livre.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titre, nbrexemplaire, auteur, categorie);
    }
}
