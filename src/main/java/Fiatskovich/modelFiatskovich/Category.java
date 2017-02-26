package Fiatskovich.modelFiatskovich;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 19.02.2017.
 */
@Entity
@Table(name="categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<User> users = new LinkedHashSet<User>();

    public Category(int id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Category() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
