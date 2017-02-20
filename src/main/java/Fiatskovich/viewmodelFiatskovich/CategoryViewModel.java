package Fiatskovich.viewmodelFiatskovich;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Евгений on 19.02.2017.
 */

public class CategoryViewModel implements Serializable {

    private int id;
    private String name;

    public CategoryViewModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryViewModel() {
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

}
