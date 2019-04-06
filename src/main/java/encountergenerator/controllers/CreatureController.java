package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import encountergenerator.models.forms.Creatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "edit/{creatureId}", method = RequestMethod.GET)
    public String displayEditCreature(Model model, @PathVariable Integer creatureId) {
        Creatures creatures = creaturesDao.findOne(creatureId);
        if(creatures!=null){
            model.addAttribute("title", "Edit - " + creatures.getName());
            model.addAttribute("creatures", creatures);
            return "creatures/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{creatureId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Creatures creatures,
                                      @RequestParam Integer id, Errors errors) {
        if(creatures==null && errors.hasErrors()){
            return "creatures/edit";
        }
        Creatures updateCreatures = creaturesDao.findOne(id);
        updateCreatures.setName(creatures.getName());
        updateCreatures.setType(creatures.getType());
        updateCreatures.setCr(creatures.getCr());
        updateCreatures.setStr(creatures.getStr());
        updateCreatures.setDex(creatures.getDex());
        updateCreatures.setCon(creatures.getCon());
        updateCreatures.setIntl(creatures.getIntl());
        updateCreatures.setWis(creatures.getWis());
        updateCreatures.setCha(creatures.getCha());
        updateCreatures.setAc(creatures.getAc());
        updateCreatures.setHp(creatures.getHp());
        updateCreatures.setSize(creatures.getSize());
        updateCreatures.setDescription(creatures.getDescription());
        updateCreatures.setShared(creatures.getShared());
        creaturesDao.save(updateCreatures);
        return "redirect:/creatures";
    }

}
