package encountergenerator;

import encountergenerator.controllers.AbstractController;
import encountergenerator.models.data.LoginDao;
import encountergenerator.models.forms.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    LoginDao loginDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> nonAuthPages = Arrays.asList("/index", "/encounter/index", "/login/index", "/login/register");

        if (!nonAuthPages.contains(request.getRequestURI())){
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                Users users = loginDao.findOne(userId);

                if (users != null)
                    return true;
            }
            response.sendRedirect("/login/index");
            return false;
        }

        return true;
    }
}
