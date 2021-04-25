package app.newQueries;

public class MaximoSalario {

    private float salario;
    private String depNome;

    public MaximoSalario(float salario, String depNome) {
        this.salario = salario;
        this.depNome = depNome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    @Override
    public String toString() {
        return "Maior Salário: " + salario +
                "\n\tDepartamento: " + depNome;
    }

}
