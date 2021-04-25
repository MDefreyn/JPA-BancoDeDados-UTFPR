package app.navegation;

import app.conect.ConnectManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DinamicQuery {
    Query query;

    public boolean start() {
        System.out.println("\nDinamic Queries\n");
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();

        System.out.println("4. Selecionar todos os atributos de uma disciplina que contenha 'Bio' como substring.");
        query = em.createQuery("SELECT d FROM DisciplinaEntity d WHERE d.titulo LIKE '%Bio%'");
        query.getResultList().forEach(dis -> System.out.println(dis + "\n"));

        System.out.println("5. Listar em ordem alfabetica todos os professores no departamento 'Physics'.");
        query = em.createQuery("SELECT p FROM ProfessorEntity p WHERE p.departamento.depNome = 'Physics' ORDER BY p.nome ASC");
        query.getResultList().forEach(prof -> System.out.println(prof + "\n"));

        System.out.println("6. Encontrar os nomes dos professores com salarios entre 90mil e 100mil.");
        query = em.createQuery("SELECT p FROM ProfessorEntity p WHERE p.salario >= 90000 AND p.salario <= 100000");
        query.getResultList().forEach(prof -> System.out.println(prof + "\n"));

        System.out.println("12. Encontrar todas as disciplinas ministradas nos semestres de outodo de 2009 mas não na primavera de 2010.");
        query = em.createQuery("SELECT d FROM DisciplinaEntity d JOIN MinistraEntity m ON d.id = m.pkId.disciplina " +
                "WHERE m.pkId.ano = 2009 AND m.pkId.semestre = 'Fall' EXCEPT SELECT d FROM DisciplinaEntity d JOIN MinistraEntity m " +
                "ON d.id = m.pkId.disciplina WHERE m.pkId.ano = 2010 AND m.pkId.semestre = 'Spring'");
        query.getResultList().forEach(dis -> System.out.println(dis + "\n"));

        System.out.println("17. Encontrar os departamentos com orçamento máximo.");
        query = em.createQuery("SELECT MAX(d.orcamento) FROM DepartamentoEntity d");
        System.out.println(" O maior orçamento entre os departamentes é de " + query.getResultList() + "\n");

        em.close();
        return true;
    }
}
