package lab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = "Shop.findAll", query = "select s from Shop as s")
)
@Table(name = "SHOP")
@EqualsAndHashCode(of = { "shopNo" })
@Getter
@Setter
public class Shop implements Serializable{

    public Shop(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SHOP_NO", nullable = false, unique = true)
    private int shopNo;

    @OneToMany(mappedBy = "shop")
    private List<Sale> sales = new ArrayList<>();
}
