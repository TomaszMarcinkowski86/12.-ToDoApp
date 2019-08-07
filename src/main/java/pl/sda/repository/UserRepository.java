package pl.sda.repository;

import pl.sda.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static List<User> userList = loadMockData();

    public User findUser(String login){
        Optional<User> first = userList.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        if (first.isPresent()){
            return first.get();
        }
        return null;
    }

    public void addUser(String login, String password, String email){
        userList.add(User.builder().login(login).password(password).email(email).build());
    }

    private static List<User> loadMockData() {
        User u1 = User.builder().login("jan").password("123").build();
        User u2 = User.builder().login("Unicorn").password("123").build();
        return new ArrayList<>(Arrays.asList(u1, u2));
    }
}