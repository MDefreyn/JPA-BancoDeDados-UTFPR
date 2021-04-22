package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "orientador")
public class OrientadorEntity implements Serializable {

    @Id
    @Column(length = 5)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s_id", referencedColumnName = "id")
    private AlunoEntity aluno;
    @Column(length = 5)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_id", referencedColumnName = "id")
    private ProfessorEntity professor;

    public OrientadorEntity() {
    }

    public OrientadorEntity(AlunoEntity aluno, ProfessorEntity professor) {
        this.aluno = aluno;
        this.professor = professor;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrientadorEntity that = (OrientadorEntity) o;
        return aluno.equals(that.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluno);
    }

}
