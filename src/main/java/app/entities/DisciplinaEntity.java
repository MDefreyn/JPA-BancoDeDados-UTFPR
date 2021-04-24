package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "disciplina")
public class DisciplinaEntity implements Serializable {

    @Id
    @Column(name = "disciplina_id", length = 8)
    private String id;

    @Column(length = 50)
    private String titulo;

    @Column(precision = 2, scale = 0)
    private float creditos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_dept", referencedColumnName = "nome_dept")
    private DepartamentoEntity departamento;

    @OneToMany(mappedBy = "disciplina")
    @JoinColumn(insertable = false, updatable = false)
    private Collection<SessaoEntity> sessoes;

    @OneToOne(mappedBy = "disciplina")
    @JoinColumn(insertable = false, updatable = false)
    private PrereqEntity temRequisito;

    @OneToOne(mappedBy = "preRequisito")
    @JoinColumn(insertable = false, updatable = false)
    private PrereqEntity eRequisito;

    public DisciplinaEntity() {
    }

    public DisciplinaEntity(String id, String titulo, float creditos, DepartamentoEntity departamento) {
        this.id = id;
        this.titulo = titulo;
        this.creditos = creditos;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        DisciplinaEntity that = (DisciplinaEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
