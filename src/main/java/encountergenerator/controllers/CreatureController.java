package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "creatures")
public class CreatureController {

    @Autowired
    private CreaturesDao creaturesDao;

    @RequestMapping(value = "")
    public String creatures(){
        return "/creatures/index";
    }
}
