package encountergenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreatureController {

    @RequestMapping(value = "creatures")
    @ResponseBody
    public String creatures(){
        return "Creatures";
    }
}
