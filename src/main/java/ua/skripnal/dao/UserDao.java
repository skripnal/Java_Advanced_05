package ua.skripnal.dao;

import ua.skripnal.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> readById(int id);
    List<User> readAll();
    void insert(String firstName, String lastName, String email, String password, String role);
    void updateById(int id, User user);
    void deleteById(int id);
}
