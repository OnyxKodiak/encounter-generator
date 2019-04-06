package encountergenerator.controllers;

import encountergenerator.models.data.LoginDao;
import encountergenerator.models.forms.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected LoginDao loginDao;

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
