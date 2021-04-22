package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity {
    @Id
    @Column(name = "nome_dept", length = 20)
    private String depNome;
    @Column(length = 15)
    private String predio;
    @Column(precision = 12, scale = 2)
    private int orcamento;

    public DepartamentoEntity() {
    }

    public DepartamentoEntity(String depNome, String predio, int orcamento) {
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

    public int getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
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
