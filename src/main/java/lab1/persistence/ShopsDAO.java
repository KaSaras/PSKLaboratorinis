package lab1.persistence;

import lab1.entities.Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ShopsDAO {

    @Inject
    private EntityManager em;

    public List<Shop> loadAll() {
        return em.createNamedQuery("Shop.findAll", Shop.class).getResultList();
    }

    public void persist(Shop shop) {
        em.persist(shop);
    }

    public Shop findOne(Integer id) {
        return em.find(Shop.class, id);
    }
}
