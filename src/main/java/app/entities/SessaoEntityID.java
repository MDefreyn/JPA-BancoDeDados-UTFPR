package app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessaoEntityID implements Serializable {

    @Column(name = "disciplina_id")
    private String disciplina;

    @Column(name = "sec_id", length = 8)
    private String sessao;

    @Column(length = 6)
    private String semestre;

    private int ano;

    public SessaoEntityID() {
    }

    public SessaoEntityID(String disciplina, String sessao, String semestre, int ano) {
        this.disciplina = disciplina;
        this.sessao = sessao;
        this.semestre = semestre;
        this.ano = ano;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getSessao() {
        return sessao;
    }

    public String getSemestre() {
        return semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessaoEntityID that = (SessaoEntityID) o;
        return ano == that.ano && disciplina.equals(that.disciplina) && sessao.equals(that.sessao) && semestre.equals(that.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina, sessao, semestre, ano);
    }

}
