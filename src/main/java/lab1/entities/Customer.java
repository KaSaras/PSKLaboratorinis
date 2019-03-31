package lab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer as c")
})
@Table(name = "Customer")
@Getter @Setter
@EqualsAndHashCode(of = { "personalCode" } )
public class Customer implements Serializable {

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name ="PERSONAL_CODE", nullable = false, unique =  true)
    private int personalCode;

    @ManyToMany
    @JoinTable(name = "CUSTOMER_SALE")
    private List<Sale> sales = new ArrayList<>();
}
