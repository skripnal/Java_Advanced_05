package ua.skripnal.serviceImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.UserDao;
import ua.skripnal.model.User;
import ua.skripnal.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    public UserServiceImpl(UserDao userDao) {
        LOGGER.info("UserServiceImpl -> constructor");
        this.userDao = userDao;
    }

    @Override
    public void readById(int id) {
        LOGGER.info("UserServiceImpl -> readById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public Optional<User> readByEmail(String email) {
        LOGGER.info("UserServiceImpl -> readByEmail");
        return userDao.readByEmail(email);
    }

    @Override
    public void readAll() {
        LOGGER.info("UserServiceImpl -> readAll");
        for (User user : userDao.readAll()){
            System.out.println(user);
        }
    }

    @Override
    public void updateUserById(int id, String firstName, String lastName, String email, String password, String role) {
        LOGGER.info("UserServiceImpl -> updateUserById");
        userDao.updateById(id,new User(firstName, lastName,email,password,role));
    }

    @Override
    public void updateUserFirstNameById(int id, String firstName) {
        LOGGER.info("UserServiceImpl -> updateUserFirstNameById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setFirstName(firstName);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserLastNameById(int id, String lastName) {
        LOGGER.info("UserServiceImpl -> updateUserLastNameById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setLastName(lastName);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserEmailById(int id, String email) {
        LOGGER.info("UserServiceImpl -> updateUserEmailById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setEmail(email);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserPasswordById(int id, String password) {
        LOGGER.info("UserServiceImpl -> updateUserPasswordById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setPassword(password);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void updateUserRoleById(int id, String role) {
        LOGGER.info("UserServiceImpl -> updateUserRoleById");
        Optional<User> optional = userDao.readById(id);
        if (optional.isPresent()){
            User user = optional.get();
            user.setRole(role);
            userDao.updateById(id,user);
        }else System.out.println("Юзера під данним id не існує");
    }

    @Override
    public void deleteById(int id) {
        LOGGER.info("UserServiceImpl -> deleteById");
        userDao.deleteById(id);
    }

    @Override
    public void insert(String firstName, String lastName, String email, String password, String role) {
        LOGGER.info("UserServiceImpl -> insert");
        userDao.insert(firstName,lastName,email,password,role);
    }
}
