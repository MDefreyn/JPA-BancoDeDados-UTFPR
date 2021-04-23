package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "assiste")
public class AssisteEntity implements Serializable {

    @EmbeddedId
    private AssisteEntityID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AlunoEntity aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id"),
            @JoinColumn(name = "sec_id", referencedColumnName = "sec_id"),
            @JoinColumn(name = "semestre", referencedColumnName = "semestre"),
            @JoinColumn(name = "ano", referencedColumnName = "ano")
    })
    private SessaoEntity sessao;

    @Column(length = 2)
    private String nota;

    public AssisteEntity() {
    }

    public AssisteEntity(AssisteEntityID id, AlunoEntity aluno, SessaoEntity sessao, String nota) {
        this.id = id;
        this.aluno = aluno;
        this.sessao = sessao;
        this.nota = nota;
    }

    public AssisteEntityID getId() {
        return id;
    }

    public void setId(AssisteEntityID id) {
        this.id = id;
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
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
