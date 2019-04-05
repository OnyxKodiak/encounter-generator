package encountergenerator.controllers;

import encountergenerator.models.forms.Users;
import encountergenerator.models.data.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "")
        public String login(Model model){
        model.addAttribute(new Users());
        model.addAttribute("title", "Login");
        return "/login/index";
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute(new Users());
        model.addAttribute("title", "Register");
        return "/login/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processaddUser(Model model, @ModelAttribute @Valid Users users, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Register");
            return "creatures/add";
        }
        loginDao.save(users);
        return "redirect:";
    }
}