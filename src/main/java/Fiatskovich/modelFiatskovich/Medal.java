package Fiatskovich.modelFiatskovich;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Евгений on 18.02.2017.
 */
@Entity
@Table(name="medals")
public class Medal {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "medals")
    private Set<User> users;

    public Medal() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
