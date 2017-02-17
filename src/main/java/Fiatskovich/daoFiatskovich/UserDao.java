package Fiatskovich.daoFiatskovich;

import Fiatskovich.modelFiatskovich.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 17.02.2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
