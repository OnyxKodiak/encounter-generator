package encountergenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TreasureController {

    @RequestMapping(value = "treasures")
    @ResponseBody
    public String treasures(){
        return "Treasure";
    }
}
