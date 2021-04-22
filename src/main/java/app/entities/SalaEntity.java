package app.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sala")
public class SalaEntity {

    @EmbeddedId
    private SalaEntityId salaId;
    @Column(precision = 4, scale = 0)
    private int capacidade;

    public SalaEntity() {
    }

    public SalaEntity(SalaEntityId salaId, int capacidade) {
        this.salaId = salaId;
        this.capacidade = capacidade;
    }

    public SalaEntityId getSalaId() {
        return salaId;
    }

    public void setSalaId(SalaEntityId salaId) {
        this.salaId = salaId;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaEntity sala = (SalaEntity) o;
        return salaId.equals(sala.salaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaId);
    }
}
