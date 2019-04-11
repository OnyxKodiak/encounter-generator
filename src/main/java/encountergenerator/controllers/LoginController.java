package encountergenerator.controllers;

import encountergenerator.models.data.UserDao;
import encountergenerator.models.forms.User;
import encountergenerator.services.SecurityService;
import encountergenerator.services.UserService;
import encountergenerator.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "login")
public class LoginController{

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loginGet(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Login");
        return "/login/index";
    }


    @RequestMapping(value="register", method = RequestMethod.GET)
    public String getregister(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "/login/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegister(Model model, @ModelAttribute User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "/login/register";
        }

        userService.save(user);
        return "redirect:login";

    }

}