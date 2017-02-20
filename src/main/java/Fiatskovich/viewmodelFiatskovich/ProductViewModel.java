package Fiatskovich.viewmodelFiatskovich;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Евгений on 19.02.2017.
 */

public class ProductViewModel implements Serializable {

    private Long id;

    private String name;

    private Set<CategoryViewModel> categories = new HashSet<CategoryViewModel>();

    private Set<AdvantageViewModel> advantages = new HashSet<AdvantageViewModel>();

    private int weight;

    private String temperature;

    private int memory;

    private double price;

    private String imageUrl;


    public ProductViewModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategoryViewModel> getCategories() {
        return categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategories(Set<CategoryViewModel> categories) {
        this.categories = categories;
    }

    public Set<AdvantageViewModel> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(Set<AdvantageViewModel> advantages) {
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
