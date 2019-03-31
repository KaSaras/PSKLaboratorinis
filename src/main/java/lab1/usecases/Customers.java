package lab1.usecases;

import lab1.entities.Customer;
import lab1.persistence.CustomersDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Customers {

    @Inject
    private CustomersDAO customersDAO;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @Getter
    private List<Customer> allCustomers;

    @PostConstruct
    public void init() {
        loadAllCustomers();
    }

    @Transactional
    public String createCustomer() {
        customersDAO.persist(customerToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllCustomers() {
        allCustomers= customersDAO.loadAll();
    }
}
