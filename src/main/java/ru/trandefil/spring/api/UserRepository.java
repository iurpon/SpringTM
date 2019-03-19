package ru.trandefil.spring.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {

    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(String s);

    @Override
    void deleteById(String s);

    @Override
    void delete(User user);

    @Query("select u from User u where u.name = :name and u.password = :password")
    User getLoggedUser(@Param("name") String name, @Param("password") String password);

    @Query("select u from User u where u.name = :name")
    User getByName(@Param("name") String name);

    @Query("select u from User u")
    List<User> getAll();

    /*    User getLoggedUser(String userName, String password, EntityManager entityManager);

    User save(User user,EntityManager entityManager);

    List<User> getAll(EntityManager entityManager);

    void deleteById(String id,EntityManager entityManager);

    User getById(String id,EntityManager entityManager);*/

}
