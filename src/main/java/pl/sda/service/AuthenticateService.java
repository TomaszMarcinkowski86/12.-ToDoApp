package pl.sda.service;

import pl.sda.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthenticateService {
    UserService service = new UserService();

    public boolean authenticate(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = service.findUser(login);
        if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
            req.getSession().setAttribute("login", login);
            return true;
        }
        return false;
    }

    public boolean isAuthenticated(HttpServletRequest req) {
        if (req.getSession().getAttribute("login") != null) {
            return true;
        }
        return false;
    }
}