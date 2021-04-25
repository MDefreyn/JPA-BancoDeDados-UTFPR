package app.conect;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectManager {

    private static EntityManagerFactory factory = null;

    static {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("orm");
        }
    }

    public static EntityManager getManager() {
        return factory.createEntityManager();
    }

}
