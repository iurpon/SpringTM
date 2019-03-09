package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trandefil.spring.api.UserRepository;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        return userRepository.getLoggedUser(userName, password);
    }

    @Override
    public User save(@NonNull final User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void deleteById(@NonNull final String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(@NonNull final String id) {
        return userRepository.getById(id);
    }

}
