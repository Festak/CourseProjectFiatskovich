package Fiatskovich.controllerFiatskovich;

import Fiatskovich.serviceFiatskovich.CategoryService;
import Fiatskovich.serviceFiatskovich.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Евгений on 20.02.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping( value = {"/product/details/{id}"}, method = RequestMethod.GET)
    @Transactional
    public String productDetails(@PathVariable( value = "id") int id, Model model ) {
        model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "/product/details";
    }
}
