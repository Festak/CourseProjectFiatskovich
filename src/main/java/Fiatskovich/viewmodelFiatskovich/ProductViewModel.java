package Fiatskovich.viewmodelFiatskovich;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Евгений on 19.02.2017.
 */

public class ProductViewModel implements Serializable {


    private Long id;

    private String name;

    private Set<CategoryViewModel> categories = new LinkedHashSet<CategoryViewModel>();

    private Set<AdvantageViewModel> advantages = new LinkedHashSet<AdvantageViewModel>();

    private int weight;

    private String temperature;

    private int memory;

    private List<RatingViewModel> ratings = new LinkedList<RatingViewModel>();

    private double rating;

    private double price;

    private String imageUrl;

    private AdvantageViewModel advantageViewModel;

    private CategoryViewModel categoryViewModel;


    public ProductViewModel(Long id, String name, int weight, String temperature, int memory, double price, String imageUrl
    ) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.temperature = temperature;
        this.memory = memory;
        this.price = price;
        this.imageUrl = imageUrl;

    }

    public ProductViewModel() {
    }

    public AdvantageViewModel getAdvantageViewModel() {
        return advantageViewModel;
    }

    public void setAdvantageViewModel(AdvantageViewModel advantageViewModel) {
        this.advantageViewModel = advantageViewModel;
    }

    public CategoryViewModel getCategoryViewModel() {
        return categoryViewModel;
    }

    public void setCategoryViewModel(CategoryViewModel categoryViewModel) {
        this.categoryViewModel = categoryViewModel;
    }

    public List<RatingViewModel> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingViewModel> ratings) {
        this.ratings = ratings;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
