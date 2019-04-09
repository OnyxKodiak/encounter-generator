package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import encountergenerator.models.forms.Creature;
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
        model.addAttribute("title", "Creature");
        return "creatures/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddCreature(Model model){
        model.addAttribute(new Creature());
        model.addAttribute("title", "Add Creature");
        return "creatures/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddCreature(Model model, @ModelAttribute @Valid Creature creature, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Creature");
            return "creature/add";
        }
        creaturesDao.save(creature);
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
        Creature creature = creaturesDao.findOne(creatureId);
        if(creature !=null){
            model.addAttribute("title", "Edit - " + creature.getName());
            model.addAttribute("creature", creature);
            return "creature/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{creatureId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Creature creature,
                                      @RequestParam Integer id, Errors errors) {
        if(creature ==null && errors.hasErrors()){
            return "creature/edit";
        }
        Creature updateCreature = creaturesDao.findOne(id);
        updateCreature.setName(creature.getName());
        updateCreature.setType(creature.getType());
        updateCreature.setCr(creature.getCr());
        updateCreature.setStr(creature.getStr());
        updateCreature.setDex(creature.getDex());
        updateCreature.setCon(creature.getCon());
        updateCreature.setIntl(creature.getIntl());
        updateCreature.setWis(creature.getWis());
        updateCreature.setCha(creature.getCha());
        updateCreature.setAc(creature.getAc());
        updateCreature.setHp(creature.getHp());
        updateCreature.setSize(creature.getSize());
        updateCreature.setDescription(creature.getDescription());
        updateCreature.setShared(creature.getShared());
        creaturesDao.save(updateCreature);
        return "redirect:/creature";
    }

}
