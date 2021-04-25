package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ministra")
public class MinistraEntity implements Serializable {

    @EmbeddedId
    private MinistraEntityId pkId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProfessorEntity professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id",
                    insertable = false, updatable = false),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id", insertable = false, updatable = false),
            @JoinColumn(name = "semestre", referencedColumnName = "semestre", insertable = false, updatable = false),
            @JoinColumn(name = "ano", referencedColumnName = "ano", insertable = false, updatable = false)
    })
    private SessaoEntity sessao;

    public MinistraEntity() {
    }

    public MinistraEntity(MinistraEntityId pkId, ProfessorEntity professor, SessaoEntity sessao) {
        this.pkId = pkId;
        this.professor = professor;
        this.sessao = sessao;
    }

    public MinistraEntityId getPkId() {
        return pkId;
    }

    public void setPkId(MinistraEntityId id) {
        this.pkId = pkId;
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
        return pkId.equals(that.pkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId);
    }

}
