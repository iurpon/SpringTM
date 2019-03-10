package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.api.UserRepository;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        return userRepository.getLoggedUser(userName, password,entityManager);
    }

    @Override
    @Transactional
    public User save(@NonNull final User user) {
        return userRepository.save(user,entityManager);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll(entityManager);
    }

    @Override
    @Transactional
    public void deleteById(@NonNull final String id) {
        userRepository.deleteById(id,entityManager);
    }

    @Override
    public User getById(@NonNull final String id) {
        return userRepository.getById(id,entityManager);
    }

}
