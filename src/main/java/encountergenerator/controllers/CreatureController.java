package encountergenerator.controllers;

import encountergenerator.models.data.CreaturesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "creatures")
public class CreatureController {

    @Autowired
    private CreaturesDao creaturesDao;

    @RequestMapping(value = "")
    @ResponseBody
    public String creatures(){
        return "Creatures";
    }
}
