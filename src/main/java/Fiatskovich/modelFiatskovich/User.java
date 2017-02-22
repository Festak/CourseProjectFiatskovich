package Fiatskovich.modelFiatskovich;

import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 17.02.2017.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

  //  @OneToMany(mappedBy="users")
  //  private Set<Report> reports;

    @Column(name = "password")
    private String password;

    @Column(name="secondAdres")
    private String secondAdres;

    @Column(name="credit")
    private int credit;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany
    @JoinTable(name = "user_medals",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "medal_id"))
    private Set<Medal> medals = new HashSet<Medal>();

    public User(){}

    @Transient
    private Set<ProductViewModel> products = new LinkedHashSet<ProductViewModel>();

    public Set<ProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductViewModel> products) {
        this.products = products;
    }

    public Set<Medal> getMedals() {
        return medals;
    }

    public void setMedals(Set<Medal> medals) {
        this.medals = medals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getSecondAdres() {
        return secondAdres;
    }

    public void setSecondAdres(String secondAdres) {
        this.secondAdres = secondAdres;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }




}