package encountergenerator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterestController {

    @RequestMapping(value = "interests")
    @ResponseBody
    public String interests(){
        return "Interests";
    }
}
