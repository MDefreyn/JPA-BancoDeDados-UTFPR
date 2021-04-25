package app.navegation;

import app.conect.ConnectManager;
import app.newQueries.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SelectNew {

    Query query;

    public boolean start() {
        System.out.println("\nNamed Queries\n");
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();

        System.out.println("7. Encontre os nomes de instrutor e os cursos que eles ministraram para todos os " +
                "professores no departamento biologia que ministraram algum curso.");
        query = em.createNamedQuery("Professores de Bio", ProfessoresBiologia.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("10. Achar o numero de professores em cada departamento que ministram um curso no semestre " +
                "da primavera de 2010.");
        query = em.createNamedQuery("Professores ministram aulas", ProfessoresMinistramAulas.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("11. Para cada sessao de curso oferecida em 2009, ache a media do total de creditos de " +
                "todos os alunosmatriculados na sessao, se a sessao tiver pelo menos dois alunos.");
        query = em.createNamedQuery("Cursos em 2009", CursosMinistrados.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("18. Listar todos os departamentos junto com o número de instrutores em cada departamento.");
        query = em.createNamedQuery("Professores por Departamente", CountProfDepartamento.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("19. Exibir informações de todos (inclusive aqueles que nao fizeram disciplina) alunos e " +
                "cursos que assistiram.");
        query = em.createNamedQuery("Alunos e Cursos", DisciplinaAluno.class);
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        em.close();
        return true;
    }

}
