package encountergenerator.controllers;

import encountergenerator.models.data.EncountersDao;
import encountergenerator.models.forms.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "encounters")
public class EncounterController {

    @Autowired
    private EncountersDao encountersDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String encounters(Model model){
        model.addAttribute(new Encounter());
        model.addAttribute("title", "Encounter");
        return "/encounters/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String genEncounter(Model model){
        model.addAttribute("title", "Encounter");
        return "/encounters/index";
    }
}
