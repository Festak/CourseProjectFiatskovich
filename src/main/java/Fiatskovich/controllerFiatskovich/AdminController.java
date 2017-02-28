package Fiatskovich.controllerFiatskovich;

import Fiatskovich.helpers.Form;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.serviceFiatskovich.ReportService;
import Fiatskovich.serviceFiatskovich.UserService;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.StandardCharsets;

/**
 * Created by Евгений on 21.02.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ReportService reportService;


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
        model.addAttribute("productForm", new ProductViewModel());
        return "/admin/addProduct";
    }

    @RequestMapping(value="/admin/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("productForm")ProductViewModel product,
                              Model model){
        productService.addProductViewModelToDataBase(product);
        model.addAttribute("form", new Form());
        return "redirect:/admin/index";
    }


    @RequestMapping(value="/admin/deleteProduct/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model){
        productService.removeProductById(id);
        model.addAttribute("form", new Form());
        model.addAttribute("users", userService.findAllViewModelUsers());
        model.addAttribute("products", productService.getAllProducts());
        return "redirect:/admin/index";
    }

    @RequestMapping(value = "/admin/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        model.addAttribute("form",new Form());
        model.addAttribute("product", productService.findProductById(id));
        return "/admin/edit";
    }

    @RequestMapping(value = "/admin/editproduct", method = RequestMethod.POST)
    public String editProductAndToIndex(@ModelAttribute("product")ProductViewModel product){
    //    product.setName(new String(product.getName().getBytes(), StandardCharsets.ISO_8859_1));
        productService.editProduct(product);
        return "redirect:/admin/index";
    }

    @RequestMapping(value = "/admin/report", method = RequestMethod.GET)
    public String report(Model model){
        model.addAttribute("form", new Form());
        model.addAttribute("reports", reportService.getAllReports());
        return "/admin/report";
    }

}
