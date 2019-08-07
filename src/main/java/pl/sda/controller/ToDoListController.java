package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;
import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/to-do/list")
public class ToDoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        ToDoService service = new ToDoService();
        List<ToDoModel> toDoModelList = service.getToDoList(login);
        req.setAttribute("categories", Category.values());
        req.setAttribute("TasksList", toDoModelList);
        req.getRequestDispatcher("/WEB-INF/views/to-do-home.jsp").forward(req, resp);
    }
}
