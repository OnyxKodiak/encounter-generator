package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import encountergenerator.models.forms.Creatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "creatures")
public class CreatureController {

    @Autowired
    private CreaturesDao creaturesDao;

    @RequestMapping(value = "")
    public String creatures(Model model){
        model.addAttribute("creatures", creaturesDao.findAll());
        model.addAttribute("title", "Creatures");
        return "creatures/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddCreature(Model model){
        model.addAttribute(new Creatures());
        model.addAttribute("title", "Add Creature");
        return "creatures/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddCreature(Model model, @ModelAttribute @Valid Creatures creatures, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Creature");
            return "creatures/add";
        }
        creaturesDao.save(creatures);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCreature(Model model) {
        model.addAttribute("creatures", creaturesDao.findAll());
        model.addAttribute("title", "Remove Creature");
        return "creatures/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCreature(@RequestParam Integer[] creatureIds) {

        for (Integer creatureId : creatureIds) {
            creaturesDao.delete(creatureId);
        }

        return "redirect:";
    }

}
