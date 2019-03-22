package encountergenerator.controllers;

import encountergenerator.models.data.InterestsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "interests")
public class InterestController {

    @Autowired
    private InterestsDao interestsDao;

    @RequestMapping(value = "")
    @ResponseBody
    public String interests(){
        return "Interests";
    }
}
