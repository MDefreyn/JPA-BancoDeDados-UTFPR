package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalaEntityId implements Serializable {

    @Column(length = 15)
    private String predio;

    @Column(name = "numero_sala", length = 7)
    private String salaNum;

    public SalaEntityId() {
    }

    public SalaEntityId(String predio, String salaNum) {
        this.predio = predio;
        this.salaNum = salaNum;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getSalaNum() {
        return salaNum;
    }

    public void setSalaNum(String salaNum) {
        this.salaNum = salaNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaEntityId salaEntityId = (SalaEntityId) o;
        return predio.equals(salaEntityId.predio) && salaNum.equals(salaEntityId.salaNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predio, salaNum);
    }

}
