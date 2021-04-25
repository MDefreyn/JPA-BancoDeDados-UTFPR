package app.newQueries;

public class MediaSalario {

    private double mediaSalario;
    private String depNome;

    public MediaSalario(double mediaSalario, String depNome) {
        this.mediaSalario = mediaSalario;
        this.depNome = depNome;
    }

    public double getMediaSalario() {
        return mediaSalario;
    }

    public void setMediaSalario(double mediaSalario) {
        this.mediaSalario = mediaSalario;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    @Override
    public String toString() {
        return "Departamento: " + depNome +
                "\n\tMédia Salarial: " + mediaSalario;
    }

}
