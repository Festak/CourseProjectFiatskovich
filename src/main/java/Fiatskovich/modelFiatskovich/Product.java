package Fiatskovich.modelFiatskovich;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Евгений on 19.02.2017.
 */
@Entity
@Table(name="products")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new LinkedHashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_ratings",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "rating_id"))
    private List<Rating> ratings = new LinkedList<Rating>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_advantages",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "advantage_id"))
    private Set<Advantage> advantages = new LinkedHashSet<Advantage>();

    @Column(name="weight")
    private int weight;

    @Column(name="temperature")
    private String temperature;

    @Column(name="memory")
    private int memory;

    @Column(name="price")
    private double price;

    @Column(name = "image_url")
    private String imageUrl;



    public Product(){}

    public Product(String name, int weight, String temperature, int memory, double price, String imageUrl) {
        this.name = name;
        this.weight = weight;
        this.temperature = temperature;
        this.memory = memory;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }



    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setName(String name) {
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
