package Fiatskovich.controllerFiatskovich;

import Fiatskovich.helpers.Form;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.serviceFiatskovich.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Евгений on 21.02.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/admin/index")
    @Transactional
    public String index(Model model){
        model.addAttribute("form", new Form());
        model.addAttribute("users", userService.findAllViewModelUsers());
        model.addAttribute("products", productService.getAllProducts());
        return "/admin/index";
    }

    @RequestMapping(value = "/admin/addProduct")
    public String addProduct(Model model){
        model.addAttribute("form", new Form());
        return "/admin/addProduct";
    }

    @RequestMapping(value="/admin/deleteProduct/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model){
        productService.removeProductById(id);
        model.addAttribute("form", new Form());
        model.addAttribute("users", userService.findAllViewModelUsers());
        model.addAttribute("products", productService.getAllProducts());
        return "redirect:/admin/index";
    }

}
