package app;

import app.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orm");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

       transaction.begin();

        System.out.println("Buscando outra entidade");
        SalaEntity q = manager.find(SalaEntity.class, new SalaEntityId("Bloco E", "302"));
        DisciplinaEntity q2 = manager.find(DisciplinaEntity.class, "TSI34A");

        System.out.println("Criando ID composto");
        SessaoEntityID i = new SessaoEntityID(q2.getId(), "1", "1 Sem", 2021);

        System.out.println("Criando Entidade");
        SessaoEntity o = new SessaoEntity(i, q, "D");

        System.out.println("Persistindo objeto");
        manager.persist(o);

        System.out.println("Commit");
        transaction.commit();

        System.out.println("Encerrando Manager e Factory");
        manager.close();
        factory.close();
    }
}
