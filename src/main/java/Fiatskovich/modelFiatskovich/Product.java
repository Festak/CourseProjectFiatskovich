package Fiatskovich.modelFiatskovich;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Евгений on 19.02.2017.
 */
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private int name;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "product_advantages",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "advantage_id"))
    private Set<Advantage> advantages;

 //   @ManyToOne
 //   @JoinColumn(name="user_id")
 //   private User user;

    @Column(name="weight")
    private int weight;

    @Column(name="temperature")
    private String temperature;

    @Column(name="memory")
    private int memory;

    @Column(name="price")
    private double price;

    public Product(){}

    public Product(int name, Set<Category> categories, Set<Advantage> advantages, int weight, String temperature, int memory, double price) {

        this.name = name;
        this.categories = categories;
        this.advantages = advantages;
        this.weight = weight;
        this.temperature = temperature;
        this.memory = memory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Advantage> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(Set<Advantage> advantages) {
        this.advantages = advantages;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
