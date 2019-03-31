package lab1.persistence;

import lab1.entities.Sale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SalesDAO {

    @Inject
    private EntityManager em;

    public List<Sale> loadAll() {
        return em.createNamedQuery("Sale.findAll", Sale.class).getResultList();
    }

    public void persist(Sale sale) { em.persist(sale); }

    public void remove(Sale sale) {
        em.remove(sale);
    }
}
