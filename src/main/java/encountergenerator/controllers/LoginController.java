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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "login")
public class LoginController{

    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loginGet(Model model){
        model.addAttribute(new Users());
        model.addAttribute("title", "Login");
        return "/login/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String loginPost(Model model, @ModelAttribute @Valid Users users, Errors errors,
                            HttpServletRequest request){
        if (errors.hasErrors()){
            return "/login/index";
        }

        Users user = loginDao.findByName(users.getName());
        String password = users.getPassword();

        if (user == null){
            errors.rejectValue("name", "user.invalid", "This user does not exist." );
            return "/login/index";
        }

        if (!user.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "login";
        }

        setUserInSession(request.getSession(), user);
        return "redirect:index";
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String getregister(Model model){
        model.addAttribute(new Users());
        model.addAttribute("title", "Register");
        return "/login/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegister(Model model, @ModelAttribute @Valid Users users, Errors errors,
                                 HttpServletRequest request){
        if(errors.hasErrors()){
            model.addAttribute("title", "Register");
            return "/login/register";
        }

        Users userExists = loginDao.findByName(users.getName());

        if (userExists != null){
            errors.rejectValue("name", "name.alreayexists",
                    "A user with that username already exists");
            return "/login/register";
        }

        loginDao.save(users);
        setUserInSession(request.getSession(), users);
        return "redirect:";

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

    public static final String userSessionKey = "user_id";

    protected Users getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : loginDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, Users users) {
        session.setAttribute(userSessionKey, users.getId());
    }

    @ModelAttribute("users")
    public Users getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }
}