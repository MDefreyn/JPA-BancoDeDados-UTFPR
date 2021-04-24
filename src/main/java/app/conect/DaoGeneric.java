package app.conect;

import javax.persistence.EntityTransaction;

public class DaoGeneric<Entity> {
    ConnectManager manager;

    public void save(Entity entidade) {
        EntityTransaction transaction = manager.init();
        transaction.begin();

        manager.persistEntity(entidade);

        transaction.commit();
        manager.close();
    }
}
