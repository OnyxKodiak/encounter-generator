package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import encountergenerator.models.forms.Creatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "creatures")
public class CreatureController {

    @Autowired
    private CreaturesDao creaturesDao;

    @RequestMapping(value = "")
    public String creatures(Model model){
        model.addAttribute("creatures", creaturesDao.findAll());
        model.addAttribute("title", "Creatures");
        return "/creatures/index";
    }

//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String addCreature(Model model){
//        model.addAttribute(new Creatures());
//        model.addAttribute("creatures", creaturesDao);
//        model.addAttribute("title", "Add Creature");
//        return "/creatures/add";
//    }

 //       @RequestMapping(value = "add", method = RequestMethod.POST)
 //   public String addCreature(Model model){
 //       creaturesDao.save(creatures);
 //       return "redirect:";
 //   }


}
