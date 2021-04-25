package app.newQueries;

public class AlunosCompSci {
    private String nome, depNome, disciplina, semestre, predio;
    private float creditos;
    private int ano;

    public AlunosCompSci(String nome, String depNome, float creditos, String disciplina, String semestre, int ano, String predio) {
        this.nome = nome;
        this.depNome = depNome;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.predio = predio;
        this.creditos = creditos;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome +
                "\n\tCreditos: " + creditos +
                "\n\tDepartamento: " + depNome +
                "\n\tDisciplina: " + disciplina +
                "\n\tSemestre: " + semestre +
                "\n\tPredio:" + predio + '\'' +
                "\n\tAno: " + ano;
    }
}
