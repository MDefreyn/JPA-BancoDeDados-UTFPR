package app.conect;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnectManager {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("orm");
    private EntityManager manager = factory.createEntityManager();

    public ConnectManager() {
    }

    public EntityTransaction init() {
        return manager.getTransaction();
    }

    public void close() {
        manager.close();
        factory.close();
    }

    public <Entity> void persistEntity(Entity entidade) {
        manager.persist(entidade);
    }
}
