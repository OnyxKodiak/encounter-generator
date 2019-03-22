package encountergenerator.controllers;

import encountergenerator.models.data.InterestsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "interests")
public class InterestController {

    @Autowired
    private InterestsDao interestsDao;

    @RequestMapping(value = "")
    public String interests(){
        return "/interests/index";
    }
}
