package ma.fstm.ilisi.model.bo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Exemplaire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "ISBN")
    private String isbn;
    @Basic
    @Column(name = "DISP")
    private String disp;
    @OneToMany(mappedBy = "exemplaireByCode")
    private Collection<Emprunt> empruntsByCode;
    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", nullable = false)
    private Livre livreByIsbn;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(code, that.code) && Objects.equals(isbn, that.isbn) && Objects.equals(disp, that.disp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, isbn, disp);
    }

    public Collection<Emprunt> getEmpruntsByCode() {
        return empruntsByCode;
    }

    public void setEmpruntsByCode(Collection<Emprunt> empruntsByCode) {
        this.empruntsByCode = empruntsByCode;
    }

    public Livre getLivreByIsbn() {
        return livreByIsbn;
    }

    public void setLivreByIsbn(Livre livreByIsbn) {
        this.livreByIsbn = livreByIsbn;
    }
}
