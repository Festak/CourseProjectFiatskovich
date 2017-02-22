package Fiatskovich.controllerFiatskovich;

import Fiatskovich.cartFiatskovich.CartInfo;
import Fiatskovich.cartFiatskovich.Utils;
import Fiatskovich.helpers.Form;
import Fiatskovich.modelFiatskovich.User;
import Fiatskovich.serviceFiatskovich.CategoryService;
import Fiatskovich.serviceFiatskovich.ProductService;
import Fiatskovich.serviceFiatskovich.UserService;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Евгений on 19.02.2017.
 */
@Controller
public class HomeController{

@Autowired
private ProductService productService;

    @Autowired
    private UserService userService;

   @Autowired
   private CategoryService categoryService;

   @Transactional
   @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
   public String index(Model model, HttpServletRequest req) {
       model.addAttribute("form", new Form());
       model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
       model.addAttribute("products", productService.getAllProducts());
       CartInfo cartInfo = Utils.getCartInSession(req);
     //  User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return "/index";
   }

    @Transactional
    @RequestMapping(value = {"/indexsearch"}, method = RequestMethod.GET)
    public String indexsearch(Model model, @Validated Form form) {
        String name = form.getName();
        model.addAttribute("form", new Form());
        model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
        model.addAttribute("products", productService.getProductsByProductName(name));
        return "/index";
    }

    @RequestMapping( value = {"/index/{id}"} )
    @Transactional
    public String indexByCategories(@PathVariable( value = "id") int id, Model model ) {
        model.addAttribute("form", new Form());
        model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "/index";
    }

    @RequestMapping(value = "/roleconditions")
    public String index(Model model){
        model.addAttribute("form", new Form());
        String test="";
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
for(SimpleGrantedAuthority auth: authorities){
    test = auth.getAuthority();
    if(test.equals("ROLE_ADMIN")){
        return "redirect:/admin/index";
    }
}
            return "redirect:/user/userpage";

    }




  //  @Transactional
  //  @RequestMapping( value = {"/index", "/"}, method = RequestMethod.GET )
  //  public @ResponseBody List<ProductViewModel> index() {
  //      List<ProductViewModel> list = new ArrayList<ProductViewModel>();
  //      list.add(productService.productToProductViewModelById(1l));
  //      return list;
  //  }


    }

