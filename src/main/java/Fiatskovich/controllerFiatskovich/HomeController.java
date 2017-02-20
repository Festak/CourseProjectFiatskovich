package Fiatskovich.controllerFiatskovich;

import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.modelFiatskovich.Role;
import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.serviceFiatskovich.MedalService;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.serviceFiatskovich.UserService;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Евгений on 19.02.2017.
 */
@Controller
public class HomeController {

@Autowired
private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private MedalService medalService;


    @Transactional
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("product", productService.findProductById(1l));
        model.addAttribute("test", userService.findByUserid(1l));
        return "/index";

    }
}
