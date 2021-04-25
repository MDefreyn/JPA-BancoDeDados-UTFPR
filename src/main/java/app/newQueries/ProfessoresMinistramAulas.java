package app.newQueries;

public class ProfessoresMinistramAulas {

    private String depNome;
    private Long coutProfessor;

    public ProfessoresMinistramAulas(String depNome, Long coutProfessor) {
        this.depNome = depNome;
        this.coutProfessor = coutProfessor;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    public Long getCoutProfessor() {
        return coutProfessor;
    }

    public void setCoutProfessor(Long coutProfessor) {
        this.coutProfessor = coutProfessor;
    }

    @Override
    public String toString() {
        return "Departamento: " + depNome +
                "\n\tNúmero de professores: " + coutProfessor;
    }

}
