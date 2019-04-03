package encountergenerator.controllers;

import encountergenerator.models.data.TreasuresDao;
import encountergenerator.models.forms.Treasures;
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
        model.addAttribute("title", "Treasures");
        return "/treasures/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddTreasures(Model model){
        model.addAttribute(new Treasures());
        model.addAttribute("title", "Add Treasure");
        return "treasures/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processaddCreature(Model model, @ModelAttribute @Valid Treasures treasures, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Treasure");
            return "treasures/add";
        }
        treasuresDao.save(treasures);
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
        Treasures treasures = treasuresDao.findOne(treasureId);
        if(treasures!=null){
            model.addAttribute("title", "Edit - " + treasures.getName());
            model.addAttribute("treasures", treasures);
            return "treasures/edit";
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{treasureId}", method = RequestMethod.POST)
    public String processEditCreature(Model model, @ModelAttribute @Valid Treasures treasures,
                                      @RequestParam Integer id, Errors errors) {
        if(treasures==null && errors.hasErrors()){
            return "treasures/edit";
        }
        Treasures updateTreasures = treasuresDao.findOne(id);
        updateTreasures.setName(treasures.getName());
        updateTreasures.setValue(treasures.getValue());
        updateTreasures.setType(treasures.getType());
        updateTreasures.setDescription(treasures.getDescription());
        updateTreasures.setShared(treasures.getShared());
        treasuresDao.save(updateTreasures);
        return "redirect:";
    }
}
