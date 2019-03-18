package encountergenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EncounterController {

    @RequestMapping(value = "encounters")
    @ResponseBody
    public String encounters(){
        return "Encounters";
    }
}
