package lab1.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Many;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name ="Sale.findAll", query = "select s from Sale as s")
        }
)

@Table(name ="SALE")
@Getter
@Setter
@EqualsAndHashCode(of = {"saleCode"})
public class Sale implements Serializable {

    public Sale(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Integer id;


    @Column(name ="SALE_CODE", nullable = false, unique = true)
    private String saleCode;

    @ManyToMany(mappedBy = "sales")
    private List<Customer> customers = new ArrayList<>();

    @ManyToMany(mappedBy = "sales")
    private List<Shop> shops = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

}
