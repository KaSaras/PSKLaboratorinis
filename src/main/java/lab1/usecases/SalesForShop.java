package lab1.usecases;

import lab1.entities.Customer;
import lab1.entities.Sale;
import lab1.entities.Shop;
import lab1.persistence.CustomersDAO;
import lab1.persistence.SalesDAO;
import lab1.persistence.ShopsDAO;

import lombok.Getter;
import lombok.Setter;
import lombok.var;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

@Model
public class SalesForShop implements Serializable {

    @Inject
    private ShopsDAO shopsDAO;

    @Inject
    private SalesDAO salesDAO;

    @Inject
    private CustomersDAO customersDAO;

    @Getter @Setter
    private Shop shop;

    @Getter @Setter
    private Customer customer;

    @Getter @Setter
    private Sale saleToCreate= new Sale();

    @PostConstruct
    public void init() {
        var requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        var shopId = Integer.parseInt(requestParameters.get("shopId"));

        shop = shopsDAO.findOne(shopId);
    }

    @Transactional
    public String createSale() {
        this.saleToCreate.setShop(this.shop);
        salesDAO.persist(saleToCreate);
        return "/courses?faces-redirect=true&teacherId=" + this.shop.getId();
    }
}
