package encountergenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private LoginController LoginDao;

    @RequestMapping(value = "")
    public String login(Model model){
        model.addAttribute("title", "Login");
        return "/login/index";
    }
}