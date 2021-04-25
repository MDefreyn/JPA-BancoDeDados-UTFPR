package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sala")
public class SalaEntity implements Serializable {

    @EmbeddedId
    private SalaEntityId salaId;

    @Column(precision = 4, scale = 0)
    private int capacidade;

    @OneToMany(mappedBy = "sala")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<SessaoEntity> sessoes;

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

    public Collection<SessaoEntity> getSessoes() {
        return sessoes;
    }

    public void setSessoes(Collection<SessaoEntity> sessoes) {
        this.sessoes = sessoes;
    }

    @PreRemove
    private void setNullOnDelete() {
        sessoes.forEach(sessao -> sessao.setSala(null));
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
