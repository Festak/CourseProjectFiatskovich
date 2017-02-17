package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.User;

/**
 * Created by Евгений on 17.02.2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
