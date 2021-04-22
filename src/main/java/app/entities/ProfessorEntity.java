package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professor")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 5)
    private String id;
    @Column(length = 20, nullable = false)
    private String nome;
    @Column(precision = 8, scale = 2)
    private float salario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_dept", referencedColumnName = "nome_dept")
    private DepartamentoEntity departamento;

    public ProfessorEntity() {
    }

    public ProfessorEntity(String id, String nome, float salario, DepartamentoEntity departamento) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public ProfessorEntity(String nome, float salario, DepartamentoEntity departamento) {
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
}
