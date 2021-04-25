package app.navegation;

import app.conect.ConnectManager;
import app.newQueries.AlunosCompSci;
import app.newQueries.MaximoSalario;
import app.newQueries.MediaSalario;

import javax.persistence.*;

public class Outras {

    Query query;

    public boolean start() {

        System.out.println("\nOutras Queries\n");
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();

        System.out.println("8. Achar o conjunto de todos as disciplinas ministranas no outono de 2002, mas nao na " +
                "primavera de 2010.");
        query = em.createQuery("SELECT d.id FROM DisciplinaEntity d JOIN MinistraEntity m ON d.id = m.pkId.disciplina " +
                "WHERE m.pkId.ano = 2002 AND m.pkId.semestre = 'Fall' EXCEPT SELECT d.id FROM DisciplinaEntity d " +
                "JOIN MinistraEntity m ON d.id = m.pkId.disciplina WHERE m.pkId.ano = 2010 AND m.pkId.semestre = 'Spring'");
        if (!query.getResultList().isEmpty()) {
            query.getResultList().forEach(result -> System.out.println(result + "\n"));
        } else {
            System.out.println("Nenhum resultado encontrado!\n");
        }

        System.out.println("13. Achar o numero total de alunos distintos que realizaram sessoes de cursos ministradas " +
                "pelo professor com id 110011.");
        query = em.createQuery("SELECT COUNT(DISTINCT a) FROM MinistraEntity m JOIN AssisteEntity at " +
                "ON m.sessao.id = at.sessao.id JOIN AlunoEntity a WHERE m.professor.id = '1100101' AND at.aluno.id = a.id");
        query.getResultList().forEach(result -> System.out.println("O número de alunos que realizam sessões do " +
                "professor 110011 é de " + result + "\n"));

        System.out.println("14. Achar todos os alunos que realoizaram todos os cursos oferecidos no departamento de biology.");
        query = em.createQuery("SELECT DISTINCT a FROM AssisteEntity at JOIN AlunoEntity a ON a.id = at.aluno.id " +
                "JOIN DisciplinaEntity d ON d.id = at.pkId.disciplina WHERE d.departamento.depNome = 'Biology'");
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("15. Achar os salarios medios dos professores dos departamentos onde o salario medio eh " +
                "maior que R$42.000.");
        query = em.createNamedQuery("Salario medio", MediaSalario.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("16. Achar dentre todos os departamentos, o máximo do salário total em cada departamento.");
        query = em.createNamedQuery("Maximo salario", MaximoSalario.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("21. Exibir uma lista de todos os alunos no departamento de computação junto com as sessões " +
                "de disciplinas, se houver, que eles realizaram na primavera de 2009; todas as sessões das disciplinas " +
                "da primavera de 2009 devem ser exibidas, mesmo que nenhum aluno do dept de computação tenha realizado " +
                "a sessão do curso.");
        query = em.createNamedQuery("Alunos CompSci", AlunosCompSci.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        em.close();
        return true;
    }

}
