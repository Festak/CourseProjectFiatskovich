package Fiatskovich.serviceFiatskovich;

import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.viewmodelFiatskovich.UserViewModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by Евгений on 17.02.2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findByUserid(long id);

    Set<UserViewModel> findAllViewModelUsers();

    void buyProducts(HttpServletRequest request);
}
