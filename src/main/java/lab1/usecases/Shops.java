package lab1.usecases;

import lab1.entities.Shop;
import lab1.persistence.ShopsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Shops {

    @Inject
    private ShopsDAO shopsDAO;

    @Getter @Setter
    private Shop shopToCreate = new Shop();

    @Getter
    private List<Shop> allShops;

    @PostConstruct
    public void init() {
        loadAllShops();
    }

    @Transactional
    public String createShop() {
        this.shopsDAO.persist(shopToCreate);

        return "index?faces-redirect=true";
    }

    private void loadAllShops() {
        allShops = shopsDAO.loadAll();
    }
}
