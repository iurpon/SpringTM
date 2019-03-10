package ru.trandefil.spring.api;

import ru.trandefil.spring.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserRepository {

    User getLoggedUser(String userName, String password, EntityManager entityManager);

    User save(User user,EntityManager entityManager);

    List<User> getAll(EntityManager entityManager);

    void deleteById(String id,EntityManager entityManager);

    User getById(String id,EntityManager entityManager);

}
