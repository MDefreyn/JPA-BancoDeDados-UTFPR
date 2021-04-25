package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity implements Serializable {

    @Id
    @Column(name = "nome_dept", length = 20)
    private String depNome;

    @Column(length = 15)
    private String predio;

    @Column(precision = 12, scale = 2)
    private float orcamento;

    @OneToMany(mappedBy = "departamento")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<AlunoEntity> alunos;

    @OneToMany(mappedBy = "departamento")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<DisciplinaEntity> disciplinas;

    @OneToMany(mappedBy = "departamento")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<ProfessorEntity> professores;

    public DepartamentoEntity() {
    }

    public DepartamentoEntity(String depNome, String predio, float orcamento) {
        this.depNome = depNome;
        this.predio = predio;
        this.orcamento = orcamento;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public Collection<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(Collection<AlunoEntity> alunos) {
        this.alunos = alunos;
    }

    public Collection<DisciplinaEntity> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Collection<DisciplinaEntity> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Collection<ProfessorEntity> getProfessores() {
        return professores;
    }

    public void setProfessores(Collection<ProfessorEntity> professores) {
        this.professores = professores;
    }

    @PreRemove
    private void setNullOnDelete() {
        disciplinas.forEach(dis -> dis.setDepartamento(null));
        professores.forEach(prof -> prof.setDepartamento(null));
        alunos.forEach(aluno -> aluno.setDepartamento(null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartamentoEntity that = (DepartamentoEntity) o;
        return depNome.equals(that.depNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depNome);
    }

}
