package pl.sda.controller;

import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/to-do/remove")
public class RemoveToDoController extends HttpServlet {

    ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   String login = String.valueOf( req.getSession().getAttribute("login"));
        String login = (String) req.getSession().getAttribute("login");
        long id = Long.parseLong(req.getParameter("id"));
        toDoService.remove( login, id );
        resp.sendRedirect("/to-do/list");
    }
}
