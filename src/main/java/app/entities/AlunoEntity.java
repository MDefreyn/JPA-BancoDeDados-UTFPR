package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alunos Não Matriculados", query = "SELECT a FROM AlunoEntity a WHERE a.assiste IS EMPTY"),
        @NamedQuery(name = "Alunos e Cursos", query = "SELECT NEW app.newQueries.DisciplinaAluno " +
                "(a.nome, d.titulo, d.creditos) FROM AssisteEntity at JOIN DisciplinaEntity d ON d.id = at.pkId.disciplina " +
                "JOIN AlunoEntity a ON a.id = at.aluno.id"),
        @NamedQuery(name = "Alunos CompSci", query = "SELECT NEW app.newQueries.AlunosCompSci " +
                "(a.nome, a.departamento.depNome, a.creditos, s.disciplina.id, s.id.semestre, s.id.ano, s.sala.salaId.predio) " +
                "FROM AssisteEntity at JOIN SessaoEntity s ON s.id = at.sessao.id JOIN AlunoEntity a " +
                "WHERE s.id.semestre = 'Spring' AND s.id.ano = 2009 AND s.disciplina.id LIKE '%CS%' AND at.aluno.id = a.id"),
})
@Table(name = "aluno")
public class AlunoEntity implements Serializable {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(name = "tot_cred", precision = 3, scale = 0)
    private float creditos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_dept", referencedColumnName = "nome_dept")
    private DepartamentoEntity departamento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    @JoinColumn(insertable = false, updatable = false)
    private Collection<AssisteEntity> assiste;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    @JoinColumn(insertable = false, updatable = false)
    private OrientadorEntity orientador;

    public AlunoEntity() {
    }

    public AlunoEntity(String id, String nome, float creditos, DepartamentoEntity departamento) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
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

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public Collection<AssisteEntity> getAssiste() {
        return assiste;
    }

    public void setAssiste(Collection<AssisteEntity> assiste) {
        this.assiste = assiste;
    }

    public OrientadorEntity getOrientador() {
        return orientador;
    }

    public void setOrientador(OrientadorEntity orientador) {
        this.orientador = orientador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoEntity that = (AlunoEntity) o;
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
                "\n\tCréditos: " + creditos;
    }

}
