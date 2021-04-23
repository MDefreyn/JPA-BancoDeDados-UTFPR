package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ministra")
public class MinistraEntity implements Serializable {

    @EmbeddedId
    private MinistraEntityId id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProfessorEntity professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id"),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id"),
            @JoinColumn(name = "semestre", referencedColumnName = "semestre"),
            @JoinColumn(name = "ano", referencedColumnName = "ano")
    })
    private SessaoEntity sessao;

    public MinistraEntity() {
    }

    public MinistraEntity(MinistraEntityId id, ProfessorEntity professor, SessaoEntity sessao) {
        this.id = id;
        this.professor = professor;
        this.sessao = sessao;
    }

    public MinistraEntityId getId() {
        return id;
    }

    public void setId(MinistraEntityId id) {
        this.id = id;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public SessaoEntity getSessao() {
        return sessao;
    }

    public void setSessao(SessaoEntity sessao) {
        this.sessao = sessao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinistraEntity that = (MinistraEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
