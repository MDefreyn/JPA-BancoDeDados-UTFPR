package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Profesores de Deps", query = "SELECT p FROM ProfessorEntity p JOIN DepartamentoEntity d " +
                "ON p.departamento.depNome = d.depNome"),
        @NamedQuery(name = "Professores e Cursos", query = "SELECT DISTINCT p FROM ProfessorEntity p " +
                "JOIN MinistraEntity m ON p.id = m.professor.id"),
        @NamedQuery(name = "Professores de Physics", query = "SELECT p FROM ProfessorEntity p " +
                "WHERE p.departamento.depNome = :valor ORDER BY p.nome ASC"),
        @NamedQuery(name = "Salario NULL", query = "SELECT p FROM ProfessorEntity p WHERE p.salario = :salario"),
        @NamedQuery(name = "Professores de Bio", query = "SELECT NEW app.newQueries.ProfessoresBiologia " +
                "(p.nome, m.pkId.disciplina, d.titulo) FROM ProfessorEntity p JOIN MinistraEntity m " +
                "ON p.id = m.professor.id JOIN DisciplinaEntity d ON m.pkId.disciplina = d.id " +
                "WHERE p.departamento.depNome = 'Biology'"),
        @NamedQuery(name = "Professores ministram aulas", query = "SELECT NEW app.newQueries.ProfessoresMinistramAulas " +
                "(p.departamento.depNome, COUNT(DISTINCT p.id)) FROM ProfessorEntity p JOIN MinistraEntity m " +
                "ON p.id = m.professor.id WHERE m.pkId.semestre = 'Spring' AND m.pkId.ano = 2010 " +
                "GROUP BY p.departamento.depNome"),
        @NamedQuery(name = "Salario medio", query = "SELECT NEW app.newQueries.MediaSalario " +
                "(AVG(p.salario), p.departamento.depNome) FROM ProfessorEntity p GROUP BY p.departamento.depNome " +
                "HAVING AVG(p.salario) > 42000"),
        @NamedQuery(name = "Maximo salario", query = "SELECT NEW app.newQueries.MaximoSalario " +
                "(MAX(p.salario), p.departamento.depNome) FROM ProfessorEntity p GROUP BY p.departamento.depNome"),
})
@Table(name = "professor")
public class ProfessorEntity implements Serializable {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(precision = 8, scale = 2)
    private float salario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_dept", referencedColumnName = "nome_dept")
    private DepartamentoEntity departamento;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    private Collection<MinistraEntity> ministra;

    @OneToMany(mappedBy = "professor")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<OrientadorEntity> orientados;

    public ProfessorEntity() {
    }

    public ProfessorEntity(String id, String nome, float salario, DepartamentoEntity departamento) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public Collection<MinistraEntity> getMinistra() {
        return ministra;
    }

    public void setMinistra(Collection<MinistraEntity> ministra) {
        this.ministra = ministra;
    }

    public Collection<OrientadorEntity> getOrientados() {
        return orientados;
    }

    public void setOrientados(Collection<OrientadorEntity> orientados) {
        this.orientados = orientados;
    }

    @PreRemove
    private void setNullonDelete() {
        orientados.forEach(aluno -> aluno.setProfessor(null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\n\tDepartamento: " + departamento.getDepNome() +
                "\n\tSalario: " + salario;
    }

}
