package ru.trandefil.spring.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trandefil.spring.api.UserRepository;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        logger.info("==================================== user service impl getLoggedUser");
        return userRepository.getLoggedUser(userName, password);
    }

    @Override
    @Transactional
    public User save(@NonNull final User user) {
        logger.info("==================================== user service impl save");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        logger.info("==================================== user service impl getAll");
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public void deleteById(@NonNull final String id) {
        logger.info("==================================== user service impl deleteById");
        userRepository.deleteById(id);
    }

    @Override
    public User getById(@NonNull final String id) {
        logger.info("==================================== user service impl getById");
        return userRepository.findById(id).orElse(null);
    }

}
