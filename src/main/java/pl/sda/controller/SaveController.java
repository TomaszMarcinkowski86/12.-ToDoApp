package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;
import pl.sda.repository.SequenceGenerator;
import pl.sda.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;

@WebServlet("/to-do/save")
public class SaveController extends HttpServlet {

    ToDoService toDoService = new ToDoService() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = SequenceGenerator.getNextValue();
        String title = req.getParameter("title");
        String login =(String) req.getSession().getAttribute("login");
        LocalDateTime creationDate = LocalDateTime.now();
        Category category = Category.valueOf(req.getParameter("category"));
        LocalDateTime deadline = LocalDateTime.parse(req.getParameter("deadline"));
        String description = req.getParameter("description");
        ToDoModel model = new ToDoModel(id,title, category, creationDate, deadline,description, false);
        toDoService.saveNewTask(login, model);
        resp.sendRedirect("/to-do/list");
    }

}