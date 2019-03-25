package encountergenerator.controllers;

import encountergenerator.models.data.TreasuresDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
