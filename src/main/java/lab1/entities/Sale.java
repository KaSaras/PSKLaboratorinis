package lab1.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(max = 50)
    @Column(name = "SALE_STATUS")
    private String status;

    @Column(name ="SALE_CODE", nullable = false, unique = true)
    private String saleCode;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private Shop shop;

    @ManyToMany(mappedBy = "sales")
    private List<Customer> customers = new ArrayList<>();


}
