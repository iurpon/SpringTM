package ru.trandefil.spring.api;

import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserRepository {

    User getLoggedUser(String userName, String password);

    User save(User user);

    List<User> getAll();

    void deleteById(String id);

    User getById(String id);

}
