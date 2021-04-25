package app.conect;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGeneric<Entity> {

    public void save(Entity entidade) {
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Entity entidade) {
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Entity entidade, Entity nova) {
        EntityManager em = ConnectManager.getManager();
        em.getTransaction().begin();
        em.detach(entidade);
        em.merge(nova);
        em.getTransaction().commit();
        em.close();
    }

}
