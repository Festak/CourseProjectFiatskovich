package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.cartFiatskovich.Utils;
import Fiatskovich.daoFiatskovich.RoleDao;
import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.Medal;
import Fiatskovich.modelFiatskovich.Product;
import Fiatskovich.modelFiatskovich.Role;
import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.serviceFiatskovich.UserService;
import Fiatskovich.viewmodelFiatskovich.MedalViewModel;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import Fiatskovich.viewmodelFiatskovich.RoleViewModel;
import Fiatskovich.viewmodelFiatskovich.UserViewModel;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Fiatskovich.modelFiatskovich.User user) {
 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
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
        for(User user: users){
            UserViewModel temp = userToUserViewModel(user);
            models.add(temp);
        }
        return models;
    }

    @Override
    public void buyProducts(HttpServletRequest req) {
        Utils.removeCartInSession(req);
    }

    private UserViewModel userToUserViewModel(User user){
UserViewModel model = new UserViewModel(user.getId(),user.getUsername());
        model.setMedals(medalsToMedalsViewModel(user.getMedals()));
        model.setRoles(rolesToRolesViewModel(user.getRoles()));
        return model;
    }

    private Set<MedalViewModel> medalsToMedalsViewModel(Set<Medal> medals){
        Set<MedalViewModel> model = new LinkedHashSet<MedalViewModel>();
        for(Medal medal: medals){
            model.add(medalToMedalViewModel(medal));
        }
        return  model;
    }

    private Set<RoleViewModel> rolesToRolesViewModel(Set<Role> roles){
        Set<RoleViewModel> model = new LinkedHashSet<RoleViewModel>();
        for(Role role: roles){
            model.add(roleToRoleViewModel(role));
        }
        return model;
    }

    private MedalViewModel medalToMedalViewModel(Medal medal){
        MedalViewModel model = new MedalViewModel(medal.getId(),medal.getName(), medal.getDescription(), medal.getImageUrl());
    return model;
    }

    private RoleViewModel roleToRoleViewModel(Role role){
        RoleViewModel model = new RoleViewModel(role.getId(), role.getName());
        return model;
    }




}
