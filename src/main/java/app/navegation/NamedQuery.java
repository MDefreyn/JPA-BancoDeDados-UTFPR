package app.navegation;

import app.conect.ConnectManager;
import app.entities.AlunoEntity;
import app.entities.ProfessorEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class NamedQuery {

    Query query;

    public boolean start() {
        System.out.println("\nNamed Queries\n");
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();

        System.out.println("1. Obter os nomes de todos os instrutores, junto com seus nomes de departamento e nome de predio do departamento.");
        query = em.createNamedQuery("Profesores de Deps", ProfessorEntity.class);
        List<ProfessorEntity> professores = query.getResultList();
        for (ProfessorEntity result : professores) {
            System.out.println(result + "\n\tPrédio: " + result.getDepartamento().getPredio() + "\n");
        }

        System.out.println("2. Para todos os professores na universidade que ministraram algum curso, encontre seus nomes e ID de todos os curos que eles ministraram.");
        query = em.createNamedQuery("Professores e Cursos", ProfessorEntity.class);
        professores = query.getResultList();
        for (ProfessorEntity result : professores) {
            System.out.println(result);
            result.getMinistra().forEach(res -> System.out.println("\tDisciplina: " + res.getSessao().getDisciplina().getTitulo()));
            System.out.println();
        }

        System.out.println("5. Listar em ordem alfabetica todos os professores no departamento 'Physics'.");
        query = em.createNamedQuery("Professores de Physics", ProfessorEntity.class).setParameter("valor", "Physics");
        query.getResultList().forEach(result -> System.out.println(result + "\n"));

        System.out.println("9. Encontrar todos os instrutores que aparecem na relação instrutor com valores nulos para salario.");
        query = em.createNamedQuery("Salario NULL", ProfessorEntity.class).setParameter("salario", null);
        if (!query.getResultList().isEmpty()) {
            query.getResultList().forEach(result -> System.out.println(result + "\n"));
        } else {
            System.out.println("Nenhum resultado encontrado!\n");
        }

        System.out.println("20. Achar todos os alunos que não realizaram um curso.");
        query = em.createNamedQuery("Alunos Não Matriculados", AlunoEntity.class);
        query.getResultList().forEach(result -> System.out.println(result));

        em.close();
        return true;
    }

}
