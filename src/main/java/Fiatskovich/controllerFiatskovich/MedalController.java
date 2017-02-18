package Fiatskovich.controllerFiatskovich;

import Fiatskovich.modelFiatskovich.Medal;
import Fiatskovich.serviceFiatskovich.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Евгений on 18.02.2017.
 */
@Controller
public class MedalController {
    private MedalService medalService;

    @Autowired(required = true)
    @Qualifier(value = "medalService")
    public void setMedalService(MedalService medalService) {
        this.medalService = medalService;
    }

    @RequestMapping(value = "/medals", method = RequestMethod.GET)
    public String listMedals(Model model){
        model.addAttribute("medal", new Medal());
        model.addAttribute("listMedals", this.medalService.getAllMedals());

        return "medals";
    }

    @RequestMapping(value = "/medal/add", method = RequestMethod.POST)
    public String addMedal(@ModelAttribute("medal") Medal medal){
        if(medal.getId() == 0){
            this.medalService.addMedal(medal);
        }else {
            this.medalService.updateMedal(medal);
        }

        return "redirect:/medal";
    }

    @RequestMapping("/remove/{id}")
    public String removeMedal(@PathVariable("id") int id){
        this.medalService.removeMedal(id);

        return "redirect:/medal";
    }

    @RequestMapping("edit/{id}")
    public String editMedal(@PathVariable("id") int id, Model model){
        model.addAttribute("medal", this.medalService.getMedalById(id));
        model.addAttribute("listMedals", this.medalService.getAllMedals());

        return "medals";
    }

    @RequestMapping("medaldata/{id}")
    public String medalData(@PathVariable("id") int id, Model model){
        model.addAttribute("medal", this.medalService.getMedalById(id));

        return "medaldata";
    }


}
