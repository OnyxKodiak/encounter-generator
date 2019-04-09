package encountergenerator.controllers;

import encountergenerator.models.data.TreasuresDao;
import encountergenerator.models.forms.Treasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "treasures")
public class TreasureController {

    @Autowired
    private TreasuresDao treasuresDao;

    @RequestMapping(value = "")
    public String treasures(Model model){
        model.addAttribute("treasures", treasuresDao.findAll());
        model.addAttribute("title", "Treasure");
        return "/treasures/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddTreasures(Model model){
        model.addAttribute(new Treasure());
        model.addAttribute("title", "Add Treasure");
        return "treasures/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddCreature(Model model, @ModelAttribute @Valid Treasure treasure, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Treasure");
            return "treasure/add";
        }
        treasuresDao.save(treasure);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTreasure(Model model) {
        model.addAttribute("treasures", treasuresDao.findAll());
        model.addAttribute("title", "Remove Treasure");
        return "treasures/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTreasure(@RequestParam Integer[] treasureIds) {

        for (Integer treasureId : treasureIds) {
            treasuresDao.delete(treasureId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{treasureId}", method = RequestMethod.GET)
    public String displayEditCreature(Model model, @PathVariable Integer treasureId) {
        Treasure treasure = treasuresDao.findOne(treasureId);
        if(treasure !=null){
            model.addAttribute("title", "Edit - " + treasure.getName());
            model.addAttribute("treasure", treasure);
            return "treasure/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{treasureId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Treasure treasure,
                                      @RequestParam Integer id, Errors errors) {
        if(treasure ==null && errors.hasErrors()){
            return "treasure/edit";
        }
        Treasure updateTreasure = treasuresDao.findOne(id);
        updateTreasure.setName(treasure.getName());
        updateTreasure.setValue(treasure.getValue());
        updateTreasure.setType(treasure.getType());
        updateTreasure.setDescription(treasure.getDescription());
        updateTreasure.setShared(treasure.getShared());
        treasuresDao.save(updateTreasure);
        return "redirect:";
    }
}
