package lab1.persistence;

import lab1.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {

    @Inject
    private EntityManager em;

    public List<Customer> loadAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Customer findOne(Integer id) {
        return em.find(Customer.class, id);
    }

}
