package Fiatskovich.controllerFiatskovich;

import Fiatskovich.cartFiatskovich.Utils;
import Fiatskovich.daoFiatskovich.UserDao;
import Fiatskovich.helpers.Form;
import Fiatskovich.modelFiatskovich.Report;

import Fiatskovich.serviceFiatskovich.CategoryService;
import Fiatskovich.serviceFiatskovich.ReportService;
import Fiatskovich.serviceFiatskovich.SecurityService;
import Fiatskovich.serviceFiatskovich.UserService;
import Fiatskovich.validatorFiatskovich.UserValidator;
import Fiatskovich.viewmodelFiatskovich.ProductViewModel;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Евгений on 17.02.2017.
 */
@Controller
public class UserController{
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("form", new Form());
        model.addAttribute("userForm", new Fiatskovich.modelFiatskovich.User());
        return "/registration";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")Fiatskovich.modelFiatskovich.User userForm,
                               BindingResult bindingResult, Model model){
        model.addAttribute("form", new Form());
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "/registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        model.addAttribute("form", new Form());
        if (error != null) {
            model.addAttribute("error", "Введенные логин или пароль неверные.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "/login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "/welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "/admin";
    }


    @RequestMapping(value = "/user/userpage")
    public String userpage(Model model){
        model.addAttribute("form", new Form());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("categories", categoryService.getAllCategoriesViewModelForSubscribe(user.getUsername()));
        model.addAttribute("subscribed", categoryService.getUserCategoriesViewModel(user.getUsername()));
        return "/user/userpage";
    }

    @RequestMapping(value="/user/buy", method = RequestMethod.GET)
    public String buy(Model model){
        model.addAttribute("form", new Form());
        model.addAttribute("report", new Report());
        return "/user/buy";
    }

    @RequestMapping(value = "/user/buyall", method = RequestMethod.POST)
    public String buyAll(@ModelAttribute("report")Report report, HttpServletRequest req){
        report.setBuyDate(new Date());
        report.setPrice(Utils.getCartInSession(req).getAmountTotal());
        userService.buyProducts(req);
        reportService.makeReport(report);
        return "redirect:/index";
    }

    @RequestMapping(value = "/user/subscribe/{id}")
    public String subscribe(Model model, @PathVariable("id")int id){
        model.addAttribute("form", new Form());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.subscribeOnCategory(user.getUsername(), id);
        return "redirect:/user/userpage";
    }

    @RequestMapping(value = "/user/unsubscribe/{id}")
    public String unsubscribe(Model model, @PathVariable("id")int id){
        model.addAttribute("form", new Form());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       userService.unSubscribeOnCategory(user.getUsername(), id);
        return "redirect:/user/userpage";
    }

}
