package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
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

}
