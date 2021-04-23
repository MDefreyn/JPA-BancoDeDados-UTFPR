package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssisteEntityID implements Serializable {

    @Column(length = 5)
    private String id;

    @Column(name = "disciplina_id")
    private String disciplina;

    @Column(name = "sec_id", length = 8)
    private String sessao;

    @Column(length = 6)
    private String semestre;

    private int ano;

    public AssisteEntityID() {
    }

    public AssisteEntityID(String id, String disciplina, String sessao, String semestre, int ano) {
        this.id = id;
        this.disciplina = disciplina;
        this.sessao = sessao;
        this.semestre = semestre;
        this.ano = ano;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssisteEntityID that = (AssisteEntityID) o;
        return ano == that.ano && id.equals(that.id) && disciplina.equals(that.disciplina) && sessao.equals(that.sessao) && semestre.equals(that.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplina, sessao, semestre, ano);
    }

}
