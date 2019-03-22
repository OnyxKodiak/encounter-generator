package encountergenerator.controllers;

import encountergenerator.models.data.TreasuresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "treasures")
public class TreasureController {

    @Autowired
    private TreasuresDao treasuresDao;

    @RequestMapping(value = "")
    @ResponseBody
    public String treasures(){
        return "Treasure";
    }
}
