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
 * Created by Евгений on 19.02.2017.
 */
@Controller
public class HomeController {

@Autowired
private ProductService productService;

   @Autowired
   private CategoryService categoryService;

   @Transactional
   @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
   public String index(Model model) {
       model.addAttribute("test", productService.getAllProductsByCategoryId(1));
       model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
       model.addAttribute("products", productService.getAllProducts());
       return "/index";
   }

    @RequestMapping( value = {"/index/{id}"} )
    @Transactional
    public String indexByCategories(@PathVariable( value = "id") int id, Model model ) {
        model.addAttribute("categories", categoryService.getAllCategoriesViewModel());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "/index";
    }

  //  @Transactional
  //  @RequestMapping( value = {"/index", "/"}, method = RequestMethod.GET )
  //  public @ResponseBody List<ProductViewModel> index() {
  //      List<ProductViewModel> list = new ArrayList<ProductViewModel>();
  //      list.add(productService.productToProductViewModelById(1l));
  //      return list;
  //  }


    }

