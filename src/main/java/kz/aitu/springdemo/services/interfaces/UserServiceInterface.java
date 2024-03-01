package kz.aitu.springdemo.services.interfaces;

import kz.aitu.springdemo.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAll();
    User getById(int id);
    User create(User user);
}
//calling all user functions so we can override them and use in future, also we mention their inputs