package Fiatskovich.controllerFiatskovich;

import Fiatskovich.cartFiatskovich.CartInfo;
import Fiatskovich.cartFiatskovich.Utils;
import Fiatskovich.helpers.Form;
import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.serviceFiatskovich.CategoryService;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Евгений on 20.02.2017.
 */
@Controller
public class ProductController{

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping( value = {"/product/details/{id}"}, method = RequestMethod.GET)
    @Transactional
    public String productDetails(@PathVariable( value = "id") long id, Model model ) {
        model.addAttribute("form", new Form());
        ProductViewModel product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "/product/details";
    }

    @RequestMapping(value="/product/addtobasket/{id}", method = RequestMethod.GET)
    @Transactional
    public void addtobasket(@PathVariable(value="id")long id, Model model, HttpServletRequest req){
        model.addAttribute("form", new Form());
        CartInfo cartInfo = Utils.getCartInSession(req);
        cartInfo.addProduct(productService.productToProductViewModelById(id));
     //   return "redirect:/index";
    }

    @RequestMapping(value="/product/basket", method = RequestMethod.GET)
    @Transactional
    public String checkBasket(Model model, HttpServletRequest req){
        model.addAttribute("form", new Form());
        CartInfo cartInfo = Utils.getCartInSession(req);
        model.addAttribute("products", cartInfo.getCartLines());
        return "/product/basket";
    }

    @RequestMapping(value="/product/removefrombasket/{id}", method = RequestMethod.GET)
    @Transactional
    public String checkBasket(@PathVariable(value = "id")long id,Model model, HttpServletRequest req){
        model.addAttribute("form", new Form());
        CartInfo cartInfo = Utils.getCartInSession(req);
        cartInfo.removeProduct(id);
        model.addAttribute("products", cartInfo.getCartLines());
        return "redirect:/product/basket";
    }
}
