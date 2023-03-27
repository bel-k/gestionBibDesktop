package ma.fstm.ilisi.model.bo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(EmpruntPK.class)
public class Emprunt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODE")
    private String code;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CIN")
    private String cin;
    @Basic
    @Column(name = "DATEEMPRUNT")
    private Date dateemprunt;
    @Basic
    @Column(name = "DATERETOUR")
    private Date dateretour;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(Date dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprunt emprunt = (Emprunt) o;
        return Objects.equals(code, emprunt.code) && Objects.equals(cin, emprunt.cin) && Objects.equals(dateemprunt, emprunt.dateemprunt) && Objects.equals(dateretour, emprunt.dateretour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, cin, dateemprunt, dateretour);
    }
}
