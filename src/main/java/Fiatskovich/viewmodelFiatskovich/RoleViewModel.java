package Fiatskovich.viewmodelFiatskovich;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class RoleViewModel implements Serializable {

    private Long id;

    private String name;

    public RoleViewModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleViewModel() {
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


}
