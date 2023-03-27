package ma.fstm.ilisi.model.bo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmpruntPK implements Serializable {
    @Column(name = "CODE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    @Column(name = "CIN")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cin;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntPK empruntPK = (EmpruntPK) o;
        return Objects.equals(code, empruntPK.code) && Objects.equals(cin, empruntPK.cin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, cin);
    }
}
