package pl.sda.controller;

import pl.sda.service.AuthenticateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    AuthenticateService authenticateService = new AuthenticateService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (authenticateService.authenticate(req)) {
            req.setAttribute("valid", true);
            resp.sendRedirect("/to-do/list");
        }else{
            req.setAttribute("valid", false);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }
    }
}
