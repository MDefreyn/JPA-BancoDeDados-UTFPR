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
        query = em.createNamedQuery("Profesores de Deps");
        List<ProfessorEntity> professores = query.getResultList();
        for (ProfessorEntity prof : professores) {
            System.out.println(prof + "\n\tPrédio: " + prof.getDepartamento().getPredio() + "\n");
        }

        System.out.println("2. Para todos os professores na universidade que ministraram algum curso, encontre seus nomes e ID de todos os curos que eles ministraram.");
        query = em.createNamedQuery("Professores e Cursos");
        professores = query.getResultList();
        for (ProfessorEntity prof : professores) {
            System.out.println(prof);
            prof.getMinistra().forEach(min -> System.out.println("\tDisciplina: " + min.getSessao().getDisciplina().getTitulo()));
            System.out.println();
        }

        System.out.println("3. Encontre os nomes de todos os instrutores cujo salario e maior do que pelo menos um instrutor do departamento de biologia.");
        query = em.createNamedQuery("Salario > Biology");
        query.getResultList().forEach(prof -> System.out.println(prof + "\n"));

        System.out.println("9. Encontrar todos os instrutores que aparecem na relação instrutor com valores nulos para salario.");
        query = em.createNamedQuery("Salario NULL");
        professores = query.getResultList();
        if (!professores.isEmpty()) {
            for (ProfessorEntity prof : professores) {
                System.out.println(prof);
            }
        } else {
            System.out.println("Nenhum resultado encontrado!\n");
        }

        System.out.println("");


        em.close();
        return true;
    }
}
