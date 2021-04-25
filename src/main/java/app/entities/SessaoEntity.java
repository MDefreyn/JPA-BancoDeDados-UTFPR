package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sessao")
public class SessaoEntity implements Serializable {

    @EmbeddedId
    private SessaoEntityID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "disciplina_id", insertable = false, updatable = false)
    private DisciplinaEntity disciplina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "predio", referencedColumnName = "predio"),
            @JoinColumn(name = "numero_sala", referencedColumnName = "numero_sala")
    })
    private SalaEntity sala;

    @Column(name = "intervalo_tempo_id", length = 4)
    private String tempo;

    @OneToMany(mappedBy = "sessao", cascade = CascadeType.REMOVE)
    @JoinColumn(insertable = false, updatable = false)
    private Collection<AssisteEntity> assiste;

    @OneToOne(mappedBy = "sessao", cascade = CascadeType.REMOVE)
    @JoinColumn(insertable = false, updatable = false)
    private MinistraEntity ministra;

    public SessaoEntity() {
    }

    public SessaoEntity(SessaoEntityID id, SalaEntity sala, String tempo) {
        this.id = id;
        this.sala = sala;
        this.tempo = tempo;
    }

    public SessaoEntityID getId() {
        return id;
    }

    public void setId(SessaoEntityID id) {
        this.id = id;
    }

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public Collection<AssisteEntity> getAssiste() {
        return assiste;
    }

    public void setAssiste(Collection<AssisteEntity> assiste) {
        this.assiste = assiste;
    }

    public MinistraEntity getMinistra() {
        return ministra;
    }

    public void setMinistra(MinistraEntity ministra) {
        this.ministra = ministra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessaoEntity that = (SessaoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
