package pl.sda.repository;

import pl.sda.model.Category;
import pl.sda.model.ToDoModel;

import java.time.LocalDateTime;
import java.util.*;

public class ToDoRepository {


    private static Map<String, List<ToDoModel>> toDoMap = loadMock();

    public List<ToDoModel> getToDoList(String login) {
        return toDoMap.get(login);
    }

    public void addToDoList(String login, ToDoModel toDoModel) {
        if (toDoMap.get(login) != null) {
            toDoMap.get(login).add(toDoModel);
        }
        else {
            toDoMap.put(login, new ArrayList<>(Arrays.asList(toDoModel)));
        }
    }

    public void removeFromToDoList(String login, long id) {
        List<ToDoModel> toDoModelList = toDoMap.get(login);
        ToDoModel model = toDoModelList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        toDoModelList.remove(model);
    }

    public void markSaDone(String login, long id) {
        List<ToDoModel> toDoModelList = toDoMap.get(login);
        Optional<ToDoModel> model = toDoModelList.stream().filter(x -> x.getId() == id).findFirst();
        if(model.isPresent()){
            model.get().setTaskDone(true);
        }
    }

    public ToDoModel getToDo(String login, long id){
        List<ToDoModel> toDoModelList = toDoMap.get(login);
        return toDoModelList.stream().filter(todo->todo.getId()==id).findFirst().orElse(null);
    }
    public void editToDo(String login, long id, String newTitle, Category newCategory, LocalDateTime newDeadline, String newDescription){
        List<ToDoModel>toDoModelList = toDoMap.get(login);
        ToDoModel model = toDoModelList.stream().filter(todo->todo.getId()==id).findFirst().orElse(null);
        model.setCategory(newCategory);
        model.setTitle(newTitle);
        model.setDeadlineDate(newDeadline);
        model.setDescription(newDescription);
    }

    private static Map<String, List<ToDoModel>> loadMock() {
        ToDoModel toDoModel1 = new ToDoModel(SequenceGenerator.getNextValue(),
                "Umyć samochód",
                Category.RELAX,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "porządnie",
                false);
        ;
        ToDoModel toDoModel2 = new ToDoModel(SequenceGenerator.getNextValue(),
                "zrobić zakupy",
                Category.HOME,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "na święta",
                false);

        List<ToDoModel> toDoModelList = new ArrayList<>();
        toDoModelList.add(toDoModel1);
        toDoModelList.add(toDoModel2);

        Map<String, List<ToDoModel>> result = new HashMap<>();
        result.put("Unicorn", toDoModelList);
        return result;
    }
}
