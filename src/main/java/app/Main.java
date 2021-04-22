package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orm");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

//        transaction.begin();
//
//        System.out.println("Buscando outra entidade");
//        Entidade q = manager.find(Entidade.class, "String querry");
//
//        System.out.println("Criando ID composto");
//        EntidadeID i = new EntidadeID();
//
//        System.out.println("Criando Entidade");
//        Entidade o = new Entidade();
//
//        System.out.println("Persistindo objeto");
//        manager.persist(o);
//
//        System.out.println("Commit");
//        transaction.commit();
//
        System.out.println("Encerrando Manager e Factory");
        manager.close();
        factory.close();
    }
}
