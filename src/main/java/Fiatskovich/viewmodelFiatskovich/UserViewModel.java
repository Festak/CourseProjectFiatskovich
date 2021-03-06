package Fiatskovich.viewmodelFiatskovich;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 17.02.2017.
 */
public class UserViewModel implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String secondAdres;

    private int credit;

    private String confirmPassword;

    private Set<RoleViewModel> roles = new LinkedHashSet<RoleViewModel>();

    private Set<MedalViewModel> medals = new LinkedHashSet<MedalViewModel>();

    private Set<CategoryViewModel> categories = new LinkedHashSet<CategoryViewModel>();

    public UserViewModel(Long id, String username) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.medals = medals;
    }

    public UserViewModel(){}

    public Set<CategoryViewModel> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryViewModel> categories) {
        this.categories = categories;
    }

    public Set<MedalViewModel> getMedals() {
        return medals;
    }

    public void setMedals(Set<MedalViewModel> medals) {
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

    public Set<RoleViewModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleViewModel> roles) {
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