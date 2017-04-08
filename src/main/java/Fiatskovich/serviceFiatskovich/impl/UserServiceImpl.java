package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.cartFiatskovich.Utils;
import Fiatskovich.daoFiatskovich.CategoryDao;
import Fiatskovich.daoFiatskovich.MedalDao;
import Fiatskovich.daoFiatskovich.RoleDao;
import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.*;
import Fiatskovich.serviceFiatskovich.UserService;
import Fiatskovich.viewmodelFiatskovich.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Евгений on 17.02.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MedalDao medalDao;

    @Transactional
    @Override
    public void save(Fiatskovich.modelFiatskovich.User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDao.getOne(1L));
        Set<Medal> medals = new LinkedHashSet<>();
        medals.add(medalDao.findOne(1));
        user.setRoles(roles);
        user.setMedals(medals);
        userDao.save(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional
    public User findByUserid(long id) {
        return userDao.findOne(id);
    }

    @Override
    @Transactional
    public Set<UserViewModel> findAllViewModelUsers() {
        Set<User> users = new LinkedHashSet<User>(userDao.findAll());
        Set<UserViewModel> models = new LinkedHashSet<UserViewModel>();
        for (User user : users) {
            UserViewModel temp = userToUserViewModel(user);
            models.add(temp);
        }
        return models;
    }

    @Override
    public void buyProducts(HttpServletRequest req) {
        Utils.removeCartInSession(req);
    }

    @Transactional
    @Override
    public void unSubscribeOnCategory(String username, int categoryId) {
        User user = userDao.findByUsername(username);
        Category category = categoryDao.findOne(categoryId);
        user.getCategories().remove(category);
        userDao.save(user);
    }

    @Transactional
    @Override
    public void subscribeOnCategory(String username, int categoryId) {
        User user = userDao.findByUsername(username);
        Category category = categoryDao.findOne(categoryId);
        user.getCategories().add(category);
        userDao.save(user);
    }

    private UserViewModel userToUserViewModel(User user) {
        UserViewModel model = new UserViewModel(user.getId(), user.getUsername());
        model.setMedals(medalsToMedalsViewModel(user.getMedals()));
        model.setRoles(rolesToRolesViewModel(user.getRoles()));
        model.setCategories(initCategoriesViewModel(user.getCategories()));
        return model;
    }

    private Set<MedalViewModel> medalsToMedalsViewModel(Set<Medal> medals) {
        Set<MedalViewModel> model = new LinkedHashSet<MedalViewModel>();
        for (Medal medal : medals) {
            model.add(medalToMedalViewModel(medal));
        }
        return model;
    }

    private Category categoryViewModelToCategory(CategoryViewModel model) {
        Category category = new Category();
        category.setName(model.getName());
        return category;
    }

    private Set<CategoryViewModel> initCategoriesViewModel(Set<Category> categories) {
        Set<CategoryViewModel> model = new LinkedHashSet<CategoryViewModel>();
        for (Category category : categories) {
            model.add(new CategoryViewModel(category.getId(), category.getName()));
        }
        return model;
    }

    private Set<RoleViewModel> rolesToRolesViewModel(Set<Role> roles) {
        Set<RoleViewModel> model = new LinkedHashSet<RoleViewModel>();
        for (Role role : roles) {
            model.add(roleToRoleViewModel(role));
        }
        return model;
    }

    private MedalViewModel medalToMedalViewModel(Medal medal) {
        MedalViewModel model = new MedalViewModel(medal.getId(), medal.getName(), medal.getDescription(), medal.getImageUrl());
        return model;
    }

    private RoleViewModel roleToRoleViewModel(Role role) {
        RoleViewModel model = new RoleViewModel(role.getId(), role.getName());
        return model;
    }


}
