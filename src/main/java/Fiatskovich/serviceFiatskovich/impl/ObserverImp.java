package Fiatskovich.serviceFiatskovich.impl;

import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.Category;
import Fiatskovich.modelFiatskovich.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Евгений on 11.03.2017.
 */
@Service
public class ObserverImp{

    @Autowired
    private UserDao userDao;

    @Transactional
    public void notifyObservers(Set<Category> categories){
    List<User> users = userDao.findAll();
        for(User user: users){
            for(Category category: categories) {
                if (user.getCategories().contains(category)) {
                    // TODO Finnaly send an email :C
                   // SendEmail sm = new SendEmail("null", "null", "null");
                    System.out.println("Send email");
                }
            }
        }
    }
}
