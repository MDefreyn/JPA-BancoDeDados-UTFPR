package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrereqEntityId implements Serializable {

    @Column(name = "disciplina_id", length = 8)
    private String disciplina;
    @Column(name = "prereq_id", length = 8)
    private String prerequesito;

    public PrereqEntityId() {
    }

    public PrereqEntityId(String disciplina, String prerequesito) {
        this.disciplina = disciplina;
        this.prerequesito = prerequesito;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPrerequesito() {
        return prerequesito;
    }

    public void setPrerequesito(String prerequesito) {
        this.prerequesito = prerequesito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrereqEntityId that = (PrereqEntityId) o;
        return disciplina.equals(that.disciplina) && prerequesito.equals(that.prerequesito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina, prerequesito);
    }

}
