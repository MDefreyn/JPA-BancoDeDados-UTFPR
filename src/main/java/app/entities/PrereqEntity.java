package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "prereq")
public class PrereqEntity implements Serializable {

    @EmbeddedId
    private PrereqEntityId id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id", insertable = false, updatable = false)
    private DisciplinaEntity disciplina;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prereq_id", referencedColumnName = "disciplina_id", insertable = false, updatable = false)
    private DisciplinaEntity preRequisito;

    public PrereqEntity() {
    }

    public PrereqEntity(PrereqEntityId id) {
        this.id = id;
    }

    public PrereqEntityId getId() {
        return id;
    }

    public void setId(PrereqEntityId id) {
        this.id = id;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaEntity getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(DisciplinaEntity preRequisito) {
        this.preRequisito = preRequisito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrereqEntity that = (PrereqEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
