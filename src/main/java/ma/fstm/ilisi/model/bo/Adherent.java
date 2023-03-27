package ma.fstm.ilisi.model.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Adherent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CIN")
    private String cin;
    @Basic
    @Column(name = "NOM")
    private String nom;
    @Basic
    @Column(name = "PRENOM")
    private String prenom;
    @OneToMany(mappedBy = "adherentByCin")
    private Collection<Emprunt> empruntsByCin;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adherent adherent = (Adherent) o;
        return Objects.equals(cin, adherent.cin) && Objects.equals(nom, adherent.nom) && Objects.equals(prenom, adherent.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin, nom, prenom);
    }

    public Collection<Emprunt> getEmpruntsByCin() {
        return empruntsByCin;
    }

    public void setEmpruntsByCin(Collection<Emprunt> empruntsByCin) {
        this.empruntsByCin = empruntsByCin;
    }
}
