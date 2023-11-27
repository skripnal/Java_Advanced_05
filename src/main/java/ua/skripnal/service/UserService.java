package ua.skripnal.service;

import ua.skripnal.model.User;

import java.util.Optional;

public interface UserService {

    void readById(int id);
    Optional<User> readByEmail(String email);
    void readAll();
    void updateUserById(int id, String firstName, String lastName, String email, String password, String role);
    void updateUserFirstNameById(int id, String firstName);
    void updateUserLastNameById(int id, String lastName);
    void updateUserEmailById(int id, String email);
    void updateUserPasswordById(int id, String password);
    void updateUserRoleById(int id, String role);
    void deleteById(int id);
    void insert(String firstName, String lastName, String email, String password, String role);
}
