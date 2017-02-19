package Fiatskovich.modelFiatskovich;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Евгений on 19.02.2017.
 */
@Entity
@Table(name="advantages")
public class Advantage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "advantages")
    private Set<Product> products;

    public Advantage(){}

    public Advantage(int id, String description, Set<Product> products) {
        this.id = id;
        this.description = description;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
