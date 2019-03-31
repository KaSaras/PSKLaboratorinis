package lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import lab1.mybatis.dao.ShopMapper;
import lab1.mybatis.model.Shop;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ShopsMyBatis {
    @Inject
    private ShopMapper shopMapper;

    @Getter
    private List<Shop> allShops;

    @Getter @Setter
    private Shop shopToCreate= new Shop();

    @PostConstruct
    public void init() {
        this.loadAllShops();
    }

    private void loadAllShops() {
        this.allShops= shopMapper.selectAll();
    }

    @Transactional
    public String createShop() {
        shopMapper.insert(shopToCreate);
        return "index?faces-redirect=true";
    }
}