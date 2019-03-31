package lab1.usecases;

import lab1.entities.Sale;
import lab1.persistence.SalesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Sales implements Serializable {

    @Inject
    private SalesDAO salesDAO;

    @Getter @Setter
    private Sale saleToCreate= new Sale();

    private List<Sale> allSales;

    @PostConstruct
    public void init() {
        loadSales();
    }

    private void loadSales() {
        this.allSales = salesDAO.loadAll();
    }

    public List<Sale> getAllSales() {
        return allSales;
    }

    @Transactional
    public String createSale() {
        salesDAO.persist(saleToCreate);
        return "index?faces-redirect=true";
    }
}
