
package pl.sda.service;

import pl.sda.model.User;
import pl.sda.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    UserRepository repository = new UserRepository();

    public User findUser(String login){
        return repository.findUser(login);
    }
    public void addUser(String login, String email, String password){
        repository.addUser(login, password,email);
    }




}