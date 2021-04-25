package app.newQueries;

import app.entities.AlunoEntity;

public class DisciplinaAluno {

    private String aluno;
    private String materia;
    private float creditos;

    public DisciplinaAluno(String aluno, String materia, float creditos) {
        this.aluno = aluno;
        this.materia = materia;
        this.creditos = creditos;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno +
                "\n\tMatéria: " + materia +
                "\n\tCréditos: " + creditos;
    }

}
