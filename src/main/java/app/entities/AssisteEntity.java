package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "assiste")
public class AssisteEntity implements Serializable {

    @EmbeddedId
    private AssisteEntityID pkId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private AlunoEntity aluno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id", insertable = false, updatable = false),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id", insertable = false, updatable = false),
            @JoinColumn(name = "semestre", referencedColumnName = "semestre", insertable = false, updatable = false),
            @JoinColumn(name = "ano", referencedColumnName = "ano", insertable = false, updatable = false)
    })
    private SessaoEntity sessao;

    @Column(length = 2)
    private String nota;

    public AssisteEntity() {
    }

    public AssisteEntity(AssisteEntityID id, AlunoEntity aluno, SessaoEntity sessao, String nota) {
        this.pkId = pkId;
        this.aluno = aluno;
        this.sessao = sessao;
        this.nota = nota;
    }

    public AssisteEntityID getPkId() {
        return pkId;
    }

    public void setPkId(AssisteEntityID pkId) {
        this.pkId = pkId;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public SessaoEntity getSessao() {
        return sessao;
    }

    public void setSessao(SessaoEntity sessao) {
        this.sessao = sessao;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssisteEntity that = (AssisteEntity) o;
        return pkId.equals(that.pkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId);
    }

}
