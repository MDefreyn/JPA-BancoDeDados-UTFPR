package app.newQueries;

public class ProfessoresBiologia {

    private String nome, disciplina, titulo;

    public ProfessoresBiologia(String nome, String disciplina, String titulo) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\n\tDisciplina: " + disciplina +
                "\n\tMatéria: "+ titulo;
    }

}
