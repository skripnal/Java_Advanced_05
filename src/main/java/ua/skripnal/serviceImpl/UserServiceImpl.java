package ua.skripnal.serviceImpl;

import ua.skripnal.dao.UserDao;
import ua.skripnal.model.User;
import ua.skripnal.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void readById(int id) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void readAll() {
        for (User user : userDao.readAll()){
            System.out.println(user);
        }
    }

    @Override
    public void updateUserById(int id, String firstName, String lastName, String email, String password, String role) {
        userDao.updateById(id,new User(firstName, lastName,email,password,role));
    }

    @Override
    public void updateUserFirstNameById(int id, String firstName) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setFirstName(firstName);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserLastNameById(int id, String lastName) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setLastName(lastName);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserEmailById(int id, String email) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setEmail(email);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserPasswordById(int id, String password) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setPassword(password);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserRoleById(int id, String role) {
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setRole(role);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void insert(String firstName, String lastName, String email, String password, String role) {
        userDao.insert(firstName,lastName,email,password,role);
    }
}
