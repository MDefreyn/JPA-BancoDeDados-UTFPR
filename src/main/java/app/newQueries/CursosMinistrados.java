package app.newQueries;

public class CursosMinistrados {

    private Double mediaCreditos;
    private String disciplina;

    public CursosMinistrados(Double mediaCreditos, String disciplina) {
        this.mediaCreditos = mediaCreditos;
        this.disciplina = disciplina;
    }

    public Double getMediaCreditos() {
        return mediaCreditos;
    }

    public void setMediaCreditos(Double mediaCreditos) {
        this.mediaCreditos = mediaCreditos;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Média de Créditos: " + mediaCreditos +
                "\n\tDisciplina: " + disciplina;
    }

}
