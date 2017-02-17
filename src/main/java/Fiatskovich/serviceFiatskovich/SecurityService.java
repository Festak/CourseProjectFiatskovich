package Fiatskovich.serviceFiatskovich;

/**
 * Created by Евгений on 17.02.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
