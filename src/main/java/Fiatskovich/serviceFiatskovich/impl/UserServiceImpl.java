package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.RoleDao;
import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.Role;
import Fiatskovich.serviceFiatskovich.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    @Override
    public Fiatskovich.modelFiatskovich.User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
