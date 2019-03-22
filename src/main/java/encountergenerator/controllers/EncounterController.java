package encountergenerator.controllers;

import encountergenerator.models.data.EncountersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "encounters")
public class EncounterController {

    @Autowired
    private EncountersDao encountersDao;

    @RequestMapping(value = "")
    public String encounters(){
        return "/encounters/index";
    }
}
