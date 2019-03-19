package ru.trandefil.spring.repository;

import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ru.trandefil.spring.api.UserRepository;
import ru.trandefil.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private UserRepositoryImpl() {
    }

    @Override
    public User getLoggedUser(@NonNull final String userName,
                              @NonNull final String password,
                              @NonNull final EntityManager entityManager) {
        logger.info("=================================== repository get logged user");
        final Query query = entityManager.createQuery(
                "select u from User u where u.name = :name and u.password = :pass");
        query.setParameter("name", userName);
        query.setParameter("pass", password);
        final User user = (User) query.getSingleResult();
        return user;
    }

    @Override

    public List<User> getAll(@NonNull final EntityManager entityManager) {
        logger.info("=================================== repository get all users");
        final String selectAll = "select u from User u";
        final Query query = entityManager.createQuery(selectAll);
        return query.getResultList();
    }

    @Override
    public User save(User user, EntityManager entityManager) {
        logger.info("=================================== repository save user");
        if (user.isNew()) {
            user.setId(UUID.randomUUID().toString());
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public void deleteById(String id, EntityManager entityManager) {
        logger.info("=================================== repository deleteById user");
        final User user = getById(id, entityManager);
        entityManager.remove(user);
    }

    @Override
    public User getById(String id, EntityManager entityManager) {
        logger.info("=================================== repository get by id user");
        final String getById = "select u from User u where u.id = :id";
        final Query query = entityManager.createQuery(getById);
        query.setParameter("id", id);
        final User user = (User) query.getSingleResult();
        return user;
    }

}
