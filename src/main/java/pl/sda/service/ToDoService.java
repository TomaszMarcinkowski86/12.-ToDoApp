package pl.sda.service;


import pl.sda.model.Category;
import pl.sda.model.ToDoModel;
import pl.sda.repository.ToDoRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ToDoService {

    private ToDoRepository toDoRepository = new ToDoRepository();

    public List<ToDoModel> getToDoList(String login) {
        return toDoRepository.getToDoList(login);
    }


    public void remove(String login, long id) {
        toDoRepository.removeFromToDoList(login, id);
    }

    public void markAsDone(String login, long id) {
        toDoRepository.markSaDone(login, id);

    }

    public void saveNewTask(String login, ToDoModel model) {
        toDoRepository.addToDoList(login, model);

    }
    public ToDoModel getToDo(String login, long id){
       return toDoRepository.getToDo(login, id);
    }

    public void edit(String login, long id, String newTitle, Category newCategory, String newDescription, LocalDateTime newDeadline) {
        toDoRepository.editToDo(login, id,newTitle, newCategory, newDeadline,newDescription);

    }
}
